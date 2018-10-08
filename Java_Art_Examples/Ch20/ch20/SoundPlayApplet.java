package ch20;

import java.awt.*;
import java.applet.*;
import javax.swing.*;

public class SoundPlayApplet extends JApplet {
	AudioClip sound;
	public void init() {
   		sound = getAudioClip(getCodeBase(), "file:sounds//event.au");
   		sound.play();
 	}
	public void start() {
  		sound.loop();    	//continue to play
	}
	public void stop() {
  		sound.stop();  	// stop while close the applet
	}
	public void paint(Graphics g) {
   		Graphics2D g2D = (Graphics2D) g;
    	g2D.drawString("Playing Event Sound, Click Close Window to Stop....", 10, 20);
  	}
	}

