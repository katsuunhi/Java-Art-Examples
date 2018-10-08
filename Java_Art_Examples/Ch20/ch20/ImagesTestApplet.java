package ch20;

//Demo: Display images in an applet

import java.awt.*;
import javax.swing.*;

public class ImagesTestApplet extends JApplet {
	private Image flowers, myPhoto;
	public void init() {
		flowers = getImage(getCodeBase(),"ch20\\flowers.gif");
		myPhoto = getImage(getDocumentBase(), "images/ygao.jpg");
	}
	public void paint(Graphics g) {
		super.paint(g);

		g.drawImage(flowers, 0, 0, this);
		g.drawImage(myPhoto, 265, 0, this);
	}
}


