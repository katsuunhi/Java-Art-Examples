package ch20;

import java.io.File;
import java.net.URL;
import java.applet.*;
/********************************************************************************* 
 *The PlaySound class hold two AudioClip objects to play music/sound files. One is for the 
 *background music, and the other one is for the sound effects.
 *It is used by GamePanel class
 *********************************************************************************/

public class PlaySound{
	static AudioClip BGClip;   // AudioClip object for background music 
	static AudioClip SoundEffectClip;   // AudioClip object for sound effect
    static URL myUrl; // file link to sound files

    /***************************************************************************************
     * link the <code> String</code> to AudioClip object, SoundEffectClip, and play
     * @param <code> String </code> for the sound file name
     ************************************************************************************/
    public static void play(String fileName) {
    	       try{
    	            myUrl=new URL("file:" + new File(".").getCanonicalPath()
    	                                 + "//" + fileName);
    	            SoundEffectClip=Applet.newAudioClip(myUrl);
    	            SoundEffectClip.play();
    	        }catch(Exception e){
    	        }

    	   }

       	/***************************************************
        * play  background Music "sounds/undersea.mid" in loop.
        *************************************************/
    	public static void playBGMusic() {
    	       try{
    	    	    String fileName="sounds/undersea.mid";
    	            myUrl=new URL("file:" + new File(".").getCanonicalPath()
    	                                 + "//" + fileName);
    	            BGClip=Applet.newAudioClip(myUrl);

    	            BGClip.loop();

    	        }catch(Exception e){
    	        }

    	   }

    	/***************************************************
    	 * stop the background Music from playing
    	 *************************************************/
       	public static void stopBGMusic() {
 	       try{
 	    	    String fileName="sounds/undersea.mid";
 	            myUrl=new URL("file:" + new File(".").getCanonicalPath()
 	                                 + "//" + fileName);
 	             BGClip.stop();
 	        }catch(Exception e){
 	        }
 	   }
 }