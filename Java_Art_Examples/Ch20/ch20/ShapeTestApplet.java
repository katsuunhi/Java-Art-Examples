package ch20;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class ShapeTestApplet extends JApplet{
	public void paint(Graphics g) {
		Graphics2D gg = (Graphics2D) g;
		Shape e = new Ellipse2D.Double(30, 30, 150, 85);

		gg.setPaint(new GradientPaint(30, 30, Color.red, 80, 50, Color.yellow, true));
		gg.fill(e);
		gg.setPaint(Color.BLUE);
		gg.setStroke(new BasicStroke(6.0f));

		gg.draw(new Rectangle2D.Double(20, 20, 170, 105));
	}
}
