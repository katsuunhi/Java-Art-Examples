package ch20;

/*********************************************************************************
 * Frame Class which sets the frame and gets the players information
 *It is used by GamePanel class
 *********************************************************************************/

import javax.swing.*;
import java.awt.*;
import java.applet.*;
import java.net.*;
import java.io.*;

class GameFrame extends JFrame {
	String player = "";
	/***************************************************************************************
    *  Function to center the frame
 	************************************************************************************/
	private void centerWindow(Window w) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		setLocation((d.width-w.getWidth())/2, (d.height-w.getHeight())/2);
	}
	/***************************************************************************************
    *  gets player name and creates the main frame for the program to run in.
    *  Passes the player to the GamePanel
	************************************************************************************/

	public GameFrame() {
		player = JOptionPane.showInputDialog(null,"打入你的名字: ");
		setTitle("欢迎你， "+ player +", 来玩认字母游戏！");
		setSize(820,720);
		//setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new GamePanel(player);
		PlaySound.playBGMusic();
		this.add(panel);
		centerWindow(this);
  }
}