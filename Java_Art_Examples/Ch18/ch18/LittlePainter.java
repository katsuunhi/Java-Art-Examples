package ch18;

//Use of Mouse event handling and JColorChooser to draw.

import javax.swing.*;
import javax.swing.colorchooser.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.awt.*;

public class LittlePainter extends JFrame {
   private JColorChooser colorChooser;
   private ColorSelectionModel model;
   private ChangeListener changeListener;
   private Color color;

   public LittlePainter() {
      super( "小画家练习板" );
      PaintPanel paintPanel = new PaintPanel();

      colorChooser = new JColorChooser();
	  add(colorChooser, BorderLayout.NORTH);

	  		changeListener = new ChangeListener() {
	  		      public void stateChanged(ChangeEvent changeEvent) {
	  		        	color = colorChooser.getColor();
	  		      }
	      	};
	  model = colorChooser.getSelectionModel();
      model.addChangeListener(changeListener);
      colorChooser.setPreviewPanel(paintPanel);
   	  add(paintPanel, BorderLayout.CENTER );
      setSize(400, 500);
      setVisible(true);
   }
   public static void main( String args[] ) {
      LittlePainter app = new LittlePainter();

      app.addWindowListener(
         new WindowAdapter() {
            public void windowClosing( WindowEvent e ) {
               System.exit( 0 );
            }
         }
      );
   }
   class PaintPanel extends JPanel {
	private int xValue, yValue;
	JTextArea textArea;

	PaintPanel() {
		add(new Label( "用鼠标按下空白区，然后按下回车开始。 "
						+ " 按下回车清除绘画。"), BorderLayout.NORTH );

		textArea = new JTextArea(14, 35);
		pack();
		setVisible(true);

		add(textArea, BorderLayout.SOUTH);
		textArea.addMouseMotionListener(
			new MouseMotionAdapter() {
		    	public void mouseDragged( MouseEvent e ) {
		               xValue = e.getX();
		               yValue = e.getY() + 20;
		               repaint();
		         }
			}
      );
	}
	public void paint( Graphics g ) {
		  g.setColor(color);
	      g.fillOval( xValue, yValue, 4, 4 );
	   }
  }
}

