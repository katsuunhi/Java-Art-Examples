package ch17;

//Use of JDesktopPane and JInternalFrame to create a three-window frame
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class DesktopPaneFrame extends JFrame {
  	private JDesktopPane desk;
  	private JButton myButton, yourButton, herButton;
	private JLabel myLabel, yourLabel, herLabel;
  	public DesktopPaneFrame() {
    	super("JDesktopPane 演示程序");
    	desk = new JDesktopPane();
    	setContentPane(desk);
    	 for (int i = 0; i < 3; i++) {
    	      addFrame(i);
    	}
    	JInternalFrame[] frames = desk.getAllFrames();
    	myLabel = new JLabel("这是我的窗口...");
		frames[0].add(myLabel, BorderLayout.NORTH);
		myLabel.setVisible(false);
    	myButton = new JButton("我的按钮");
    	frames[0].add(myButton, BorderLayout.SOUTH);
    	myButton.addActionListener(new ActionListener() {
	    	 public void actionPerformed(ActionEvent actionEvent) {
			  	 myLabel.setVisible(true);
	      }
    	});
    	yourLabel = new JLabel("这是你的窗口...");
		frames[1].add(yourLabel, BorderLayout.SOUTH);
		yourLabel.setVisible(false);
    	yourButton = new JButton("你的按钮");
    	frames[1].add(yourButton, BorderLayout.NORTH);
    	yourButton.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent actionEvent) {
					yourLabel.setVisible(true);
	      	}
    	});
    	herLabel = new JLabel("这是她的窗口...");
		frames[2].add(herLabel, BorderLayout.EAST);
		herLabel.setVisible(false);
    	herButton = new JButton("她的按钮");
    	frames[2].add(herButton, BorderLayout.WEST);
    	herButton.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent actionEvent) {
					herLabel.setVisible(true);
	      	}
    	});
		setDefaultCloseOperation(EXIT_ON_CLOSE);
  	}

  	private void addFrame(int number) {
    	JInternalFrame frame = new JInternalFrame("窗口 " + number, true, true,true, true);
    	frame.setBounds(number * 40, number * 90, 200, 100);
    	desk.add(frame);
    	frame.setVisible(true);
  	}
}
public class DesktopPaneFrameApp {
  	public static void main(String[] args) {
    	JFrame frame = new DesktopPaneFrame();
    	frame.setSize(380, 320);
   	 	frame.setVisible(true);

  	}
}