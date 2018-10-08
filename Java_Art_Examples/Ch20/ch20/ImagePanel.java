package ch20;

import javax.swing.*;
import java.awt.*;
import java.net.*;

class ImagePanel extends JPanel{
	Toolkit tk;							//申明Toolkit
	Image flowers, myPhoto , javaLogo;
	URL imageUrl;
	
public ImagePanel(){						//构造器
	tk = Toolkit.getDefaultToolkit();
	flowers = tk.createImage("ch20\\flowers.gif");
	myPhoto = tk.getImage("images\\gao.jpg");
	try {
     imageUrl = new URL("http://www.writeside.com/images/reviews/review133.gif");
     javaLogo = tk.getImage(imageUrl);
	}
	catch (MalformedURLException e) {}
}
public void paintComponent(Graphics g){
  	super.paintComponent(g);
  	Graphics2D gg = (Graphics2D) g;
    gg.drawImage(flowers, 0, 0, this);			//在当前控制板中显示图像
	gg.drawImage(myPhoto, 265, 5, this);
	gg.drawImage(javaLogo, 520, 0, this);
	
}
}
