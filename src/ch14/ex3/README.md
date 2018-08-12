4-3

Write a program that will draw a stick figure doing a jumping jack. Use arrays for the coordinates for the left arm, right arm, left leg, and right leg (arrays included). Make sure the arms and legs jump in coordination and they don't jump too fast. Override `update()` and only redraw the parts that are changing. Increment through the arrays for the end points of the arms and legs.

```java
package threads14;

/* Bill Wohlleber
Exercise 14-3
This applet will have a stick figure doing a jumping jack
*/
import java.awt.*;
import javax.swing.*;
public class ex143a extends JApplet
{
    int index = 0;
    int[] leftarmx = {100,90,85,80,72,72,70,70,70,72,75,80};
    int[] leftarmy = {200,190,180,170,160,150,140,130,120,110,100,90};
    int[] rightarmx = {200,210,215,220,228,228,230,230,230,228,225,220};
    int[] rightarmy = {200,190,180,170,160,150,140,130,120,110,100,90};
    int[] leftlegx = {145,140,135,130,125,120,115,110,105,100,95,90};
    int[] leftlegy = {280,280,280,280,280,280,280,280,280,280,280,280};
    int[] rightlegx = {155,160,165,170,175,180,185,190,195,200,205,210};
    int[] rightlegy = {280,280,280,280,280,280,280,280,280,280,280,280};
    int sleep = 50;
    boolean goingup = true, first = true;
    Container c;
}
```