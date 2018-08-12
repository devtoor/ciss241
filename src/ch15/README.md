15-2

Write an applet that will draw random colored (from an array of `Color` objects):
                  
a. Random thick lines - use `Line2D` objects with rounded edges. Set it up like a horizontal bar chart with a series of lines going from left to right. The x coordinate will be starting from the left edge, the y coordinate will increment a set amount, and the width and height will be random numbers (but keep the height on the chart (not higher than the y's increment) and the width on the applet (you can `getSize().width` for your applet's width - the default is usually 400 x 300).  Use a for loop to loop through all the drawn lines with the loop variable being the y coordinate that will increment the lines vertically. 

b. Lab exercise 15-2b is shown in the Labs section, it is different because the loop is just counting and it is drawing random `GeneralPath` Triangle so all sides are random, but has some `random()` calls, strokes, and the array of `Color` objects that could be useful. 

15-10

Using your own layouts with `setBounds()`, design the attached lycos search page. Plan out the coordinates for the placement and sizes of the two checkboxes, textfield, button, and image. You do not have to supply the event handlers for clicking or typing. The image is also attached. Lycos (with their image periodically changing) can be found at [www.lycos.com](http://www.lycos.com/). Make sure your checkbox is checked, colors are used, and the applet is sized properly. Take a picture of your applet with the components and image. Submit your code and picture of your applet.

Hint: It works best when you draw the image in a regular `paint()` method (after running the super `JApplet` `paint()` method). Also, checkboxes have a background around them so you may need to set the checkboxes background to the container's background.
