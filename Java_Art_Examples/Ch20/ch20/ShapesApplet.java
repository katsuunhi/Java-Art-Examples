package ch20;

import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

public class ShapesApplet extends JApplet{
   public void init(){
      JPanel panel = new ShapesPanel();
      add(panel);
   }
}
class ShapesPanel extends JPanel{

   Shape shape;
   JComboBox  shapeComboBox, colorComboBox;
   JRadioButton drawButton, fillButton;

   boolean fill;
   Color color;

   public ShapesPanel(){

      String[] shapes = {"Line", "Rectangle", "Round Rectangle", "Ellipse",
	                           "Arc"};
	  shapeComboBox = new JComboBox(shapes);

	  shapeComboBox.setSelectedItem("Rectangle");
      shape = new Rectangle2D.Double(100, 60, 200, 60);
       shapeComboBox.addItemListener(new ShapeEventHandler());

      String[] colors = {"Black", "Red", "Blue", "Green", "yellow"};
      colorComboBox = new JComboBox(colors);
      colorComboBox.setSelectedItem("Black");
      colorComboBox.addItemListener(new ColorEventHandler());

	  drawButton = new JRadioButton("not fill");
	  fillButton = new JRadioButton("fill");
	  ButtonGroup drawGroup = new ButtonGroup();		//创建按钮组
	  drawGroup.add(drawButton);						//注册到按钮组
	  drawGroup.add(fillButton);

      drawButton.addItemListener(new DrawEventHandler());
      fillButton.addItemListener(new DrawEventHandler());

      JPanel northPanel = new JPanel();
      northPanel.add(shapeComboBox);
      northPanel.add(colorComboBox);
      northPanel.add(drawButton);
      northPanel.add(fillButton);

      setLayout(new BorderLayout());
      add(northPanel, BorderLayout.NORTH);
   }
   public void paintComponent(Graphics g){
      super.paintComponent(g);
	  Graphics2D gg = (Graphics2D) g;
	  gg.setColor(color);
	  if (fill)
      	gg.fill(shape);
      else
        gg.draw(shape);
   }

   class ShapeEventHandler implements ItemListener {
	  public void itemStateChanged(ItemEvent e){
		String shapeString = (String)shapeComboBox.getSelectedItem();
		int x = 100, y = 60, w = 200, h = 60;
		if (shapeString.equals("Line"))
			shape = new Line2D.Double(x, y, w+100, h+100);
		else if (shapeString.equals("Rectangle"))
		   shape = new Rectangle2D.Double(x, y, w, h);
		else if (shapeString.equals("Round Rectangle"))
		   shape = new RoundRectangle2D.Double(x, y, w, h, 40, 40);
		else if (shapeString.equals("Ellipse"))
		   shape = new Ellipse2D.Double(x, y, w, h);
		else if (shapeString.equals("Arc"))
		   shape = new Arc2D.Double(x, y, w, h, 30, 210, Arc2D.CHORD);
		repaint();
	   }
   }

   class ColorEventHandler implements ItemListener {
	  public void itemStateChanged(ItemEvent e){
		String colorString = (String) colorComboBox.getSelectedItem();
		if (colorString.equals("Black"))
			color = Color.black;
		else if (colorString.equals("Blue"))
			color = Color.blue;
		else if (colorString.equals("Red"))
			color = Color.red;
		else if (colorString.equals("Green"))
			color = Color.green;
		else if (colorString.equals("yellow"))
			color = Color.yellow;
		repaint();
	}
   }
   class DrawEventHandler implements ItemListener {
	  public void itemStateChanged(ItemEvent e){
        if (drawButton.isSelected())
          	fill = false;
      	else if (fillButton.isSelected())
       	 	fill = true;
      repaint();
  	 }
   }
}
