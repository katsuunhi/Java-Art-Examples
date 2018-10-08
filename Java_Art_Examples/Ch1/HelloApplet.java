//Demo:  Example of display "Hello World!" as an applet

import javax.swing.*;  //include JApplet API class
import java.awt.*;

public class HelloApplet extends JApplet {	//define an applet
  public void paint(Graphics g) {  	//define the pain() method
	  	super.paint(g);				//call superclass paint()
	  	g.drawString("Hello, World!", 25, 30);
  } // end of paint()
}  // end of applet class