package ch19;

import java.awt.*;
import java.applet.*;

public class MovingBannerApplet extends Applet implements Runnable {
   private Thread bannerThread;
   private int x;

   public void init(){
      x = 10;
   }
   public void start() {
      if (bannerThread == null) {
         bannerThread = new Thread(this);
         bannerThread.start();
      }
   }

   public void run() {
      Thread myThread = Thread.currentThread();
      while (bannerThread == myThread) {
         try{
            Thread.sleep(100);
         }
         catch (InterruptedException e){}

         repaint();
      }
   }
   public void paint(Graphics g) {
      x += 3;
      Dimension d = getSize();
      if (x > (d.width - 10))
         x = 10;
      g.setFont(new Font("SansSerif", Font.BOLD, 24));
      g.setColor(Color.red);
      g.drawString("Java SE 7 is out now!", x, 50);
   }
   public void stop() {
      bannerThread = null;
   }
}
