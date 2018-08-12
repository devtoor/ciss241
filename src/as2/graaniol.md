# Cat Snake - Graphics 2D Animation

Write an applet program that will create an animation of a shape (a cat? or a snake?) moving across the screen using `Graphics2D` (see below). Create an applet similar to the image below using `setSize()` to size your applet and applet viewer. It will have `Ellipse2D` shape for the yellow sun, `Rectangle2D` green grass, and the `Rectangle2D` cyan and white sky. Create a `GradientPaint` cyclic object for the shift in colors for the sky. You will also draw a little dark gray `Line2D` tree trunk with a green `Arc2D` for the leaves.

You will draw a red `GeneralPath` for the face with 2 blue eyes. Use a `BasicStroke` to make the lines around the face thicker. The face (and eyes) will slowly move across the screen from left to right using the static `sleep()` method.  Override the `update()` method to lesson flicker.  Each time in `paint()`, you will draw over the previous shape in the green grass color, then make the move and redraw the face a short distance to the right (keep track of an x variable that keeps incrementing in `paint()` and a y that stays constant).  You can leave all other shapes drawn on the screen.

So the `paint()` method will:
1.  If it is the first time run, draw everything with a `Graphics2D` object.

2.  If it is not the first time: 

    a. Use a `GeneralPath` (with an x coordinate) with a `BasicStroke` and Ellipse to draw
    either just the cat snake face or all the grass in green to cover the previous face.

    b. Move the x coordinate to the right a short distance.

    c. Recreate the `GeneralPath` and redraw the cat snake face in blue and red.

    d. Go to sleep for a few milliseconds.

    e. Continue your cat snake moving until it is to the right edge of the applet. If your cat
    snake is not there yet, call `repaint()` to repeat.  Stop your cat snake while it is visible on
    the right edge of the applet.

Add a full paragraph of documentation (at least 4 lines each) to your main program. Supply extra documentation (at least 5 comments) throughout for all of the not easily understandable lines of code for your main program. Run your applet. The final `.java` file and a picture of the output applet viewer with the applet running should be submitted. A picture of the applet viewer can be taken by holding down the <kbd>Alt</kbd> key and pressing the <kbd>Ptrscr</kbd> key (will take a picture of the active window and save onto the clipboard). The picture can be pasted into Paint and saved.
