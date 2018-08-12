package as2;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

import static java.awt.Color.*;
import static java.awt.BasicStroke.*;

/**
 * Project: Cat Snake - Graphics 2D Animation
 * Date:    2/27/2018
 *
 * Purpose:
 *      This applet program will create an animation of a shape cat moving
 *      across the screen using Graphics2D. The face will slowly move across
 *      the screen from left to right using the static sleep method. This
 *      program is design to adjust the animation if the state of the applet's
 *      size change. Objects are proportional to the width and height of the
 *      applet viewer.
 *
 * @author Jay Morales
 */

public class catsnake extends JApplet
{
    // Admin settings - for update and modification
    private final static int INIT_WIDTH = 400;      // Initial width of the component
    private final static int INIT_HEIGHT = 300;     // Initial height of the component
    private final static int INIT_LOC_X = 10;       // Initial x location - upper left of the cat
    private final static int INIT_LOC_Y = 180;      // Initial y location - upper left of the cat
    private final static int CAT_FACE_THICK = 5;    // Stroke thickness
    private final static long MIL_SLEEP_TIME = 20;  // Between frames - in milliseconds

    // Color settings - for update and modification
    private final static Color CAT_FACE_COLOR = RED;
    private final static Color CAT_EYES_COLOR = BLUE;
    private final static Color SUN_COLOR = YELLOW;
    private final static Color SKY1_COLOR = WHITE;
    private final static Color SKY2_COLOR = CYAN;
    private final static Color GRASS_COLOR = GREEN;
    private final static Color TREE_COLOR = DARK_GRAY;
    private final static Color LEAVES_COLOR = GREEN;

    private boolean firstTime;      // Flag to avoid repainting the background
    private double relX;            // Relational x, proportional to the width of the applet
    private double relY;            // Relational y, proportional to the height of the applet
    private int instanceWidth;      // To determine changes of the applet's width
    private int instanceHeight;     // To determine changes of the applet's height

    /**
     * This initialized the object's data fields. This is called by the browser
     * or applet viewer to inform this applet that is has been loaded into the
     * system.
     */
    @Override
    public void init()
    {
        firstTime = true;   // Set initial value to true
        relX = INIT_LOC_X;
        relY = INIT_LOC_Y;
        instanceWidth = getWidth();
        instanceHeight = getHeight();

        setSize(INIT_WIDTH, INIT_HEIGHT);
    }

    /**
     * This method will start and resume animation after it was hidden.
     */
    @Override
    public void start()
    {
        firstTime = true;   // To repaint the background
    }

    /**
     * Just calls paint(g). This method was overridden to prevent an
     * unnecessary call to clear the background. JApplet already override
     * this method from Container class, no need to do this.
     *
     * @param g the specified Graphics window
     */
    @Override
    public void update(Graphics g)
    {
        paint(g);
    }

    /**
     * This method is called when the contents of the component should
     * be painted; such as when the component is first being shown or
     * is damaged and in need of repair.
     *
     * @param g the graphics context to use for painting.
     */
    @Override
    public void paint(Graphics g)
    {
        final Graphics2D G2D = (Graphics2D) g;

        // Paint the background when first run or when resizing the window
        if (firstTime || instanceWidth != getWidth() || instanceHeight != getHeight())
        {
            firstTime = false;
            relY = proDisY(INIT_LOC_Y);
            instanceWidth = getWidth();
            instanceHeight = getHeight();

            paintBackground(G2D);
            paintCat(G2D);
        }
        else
        {
            // Move the cat by incrementing the relational x
            if (relX < getWidth() - proDisX(50))
            {
                relX++;
                paintCat(G2D);
            }
        }

        try
        {
            Thread.sleep(MIL_SLEEP_TIME);
        }
        catch (InterruptedException ignore) {} // ignore exception
        repaint();
    }

    /**
     * This method paints the background using the Graphics2D class.
     * Objects are using the proDisX() and proDisY methods to adopt
     * to any changes in the applet viewer size.
     *
     * @param g the graphics 2D context to use for painting.
     */
    private void paintBackground(Graphics2D g)
    {
        // Create objects based on the current width and height of the applet viewer
        GradientPaint skyPaint =
                new GradientPaint(0f, 0f, SKY1_COLOR, (float) proDisX(300), (float) proDisY(150), SKY2_COLOR);
        Rectangle2D sky =
                new Rectangle2D.Double(0, 0, getWidth(), proDisY(150));
        Ellipse2D sun =
                new Ellipse2D.Double(proDisX(50), proDisY(30), proDisX(40), proDisY(40));
        Rectangle2D grass =
                new Rectangle2D.Double(0, proDisY(150), getWidth(), proDisY(150));
        Line2D treeTrunk =
                new Line2D.Double(proDisX(230), proDisY(100), proDisX(230), proDisY(150));
        Arc2D leaves =
                new Arc2D.Double(proDisX(204), proDisY(80), proDisX(50), proDisY(50), 0, 180, Arc2D.CHORD);

        // Draw the objects
        g.setPaint(skyPaint);
        g.fill(sky);

        g.setColor(GRASS_COLOR);
        g.fill(grass);

        g.setColor(SUN_COLOR);
        g.fill(sun);

        g.setStroke(new BasicStroke((int)proDisY(6), CAP_ROUND, JOIN_ROUND));
        g.setColor(TREE_COLOR);
        g.draw(treeTrunk);

        g.setColor(LEAVES_COLOR);
        g.fill(leaves);
    }

    /**
     * This method paints the face of the cat using Graphics2D class.
     * Objects are using the proDisX() and proDisY methods to adopt
     * to any changes in the applet viewer size.
     *
     * @param g the graphics 2D context to use for painting.
     */
    private void paintCat(Graphics2D g)
    {
        // Create objects based on the current width and height of the applet viewer
        GeneralPath cat = new GeneralPath();
        Ellipse2D.Double eye1 =
                new Ellipse2D.Double(relX + proDisX(6), relY + proDisY(16), proDisX(10), proDisY(10));
        Ellipse2D.Double eye2  =
                new Ellipse2D.Double(relX + proDisX(26), relY + proDisY(16), proDisX(10), proDisY(10));

        // Set points base on the relational x and y
        cat.moveTo(relX, relY);
        cat.lineTo(relX + proDisX(10), relY + proDisY(10));
        cat.lineTo(relX + proDisX(30), relY + proDisY(10));
        cat.lineTo(relX + proDisX(40), relY);
        cat.lineTo(relX + proDisX(40), relY + proDisY(40));
        cat.lineTo(relX, relY + proDisY(40));
        cat.closePath();

        // Cover the previous face
        deleteScene(g);

        // Draw the objects
        g.setStroke(new BasicStroke(CAT_FACE_THICK, CAP_ROUND, JOIN_ROUND));
        g.setColor(CAT_FACE_COLOR);
        g.draw(cat);

        g.setColor(CAT_EYES_COLOR);
        g.fill(eye1);
        g.fill(eye2);
    }

    /**
     * This method will cover the previous face using the GRASS_COLOR
     *
     * @param g the graphics 2D context to use for painting.
     */
    private void deleteScene(Graphics2D g)
    {
        // Create objects based on the current width and height of the applet viewer
        Rectangle2D.Double rec =
                new Rectangle2D.Double(relX - proDisX(5), relY - proDisY(7.5), proDisX(65), proDisY(60));

        g.setColor(GRASS_COLOR);
        g.fill(rec);
    }

    /**
     * This method return the proportional x value of the argument base on
     * 400 pixel width. For example, if the argument is 200 it will return half
     * of the current width. So any changes to the width, this method will return
     * proportional distance of x base on the 400 width setup.
     *
     * @param x distance base on the 400 width setup
     *
     * @return proportional x distance of the value base on the current width
     */
    private double proDisX(double x)
    {
        return getWidth() * x / 400;
    }

    /**
     * This method return the proportional y value of the argument base on
     * 300 pixel height. For example, if the argument is 150 it will return half
     * of the current height. So any changes to the height, this method will return
     * proportional distance of y base on the 300 height setup.
     *
     * @param y distance base on the 300 height setup
     *
     * @return proportional y distance of the value base on the current height
     */
    private double proDisY(double y)
    {
        return getHeight() * y / 300;
    }
}
