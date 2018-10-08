package ch20;

//Applet: Movable photo

import java.awt.*;
//import java.net.URL;
import javax.swing.*;

public class AnimatedImageApplet extends JApplet implements Runnable {
  private Image photo;
  private int imageWidth,
   			  imageHeight;

  public void init() {
    photo = getImage(getCodeBase(), "images/javaLogo.gif");
    imageWidth = getWidth()-300;
    imageHeight = getHeight()-150;
  }
  public void start() {
    Thread thread = new Thread(this);
    thread.start();
  }
  public void paint(Graphics g) {
    g.drawImage(photo,10,10,imageWidth,imageHeight,this);
  }

  public void run() {
    int dx=10, dy=5;
    while (true) {
      for(int i=0; i<20; i++) {
        imageWidth += dx;
        imageHeight += dy;
        repaint();
        try {
          Thread.sleep(280);
        }catch(InterruptedException e) {
           e.printStackTrace();
        }
      }
      dx = -dx; dy = -dy;
    }
  }
}