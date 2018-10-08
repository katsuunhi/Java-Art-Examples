package ch20;
//Demo: Shapes in Graphics class

import java.awt.*;
import javax.swing.*;

public class GraphicsShapesApplet extends JApplet{
   public void paint(Graphics g){
      g.drawLine(100,30,30,70);
      g.drawRect(120,30,70,40);
      g.drawRoundRect(210,30,70,40,30,30);
      g.drawOval(300,30,70,40);
      g.drawArc(30,90,70,40,30,120);
      int[] xPoints = {120,155,190};
      int[] yPoints = {130,90,130};
      Polygon triangle = new Polygon(xPoints, yPoints, 3);
      g.drawPolygon(triangle);
   }
}