package ch16;

import javax.swing.*;

public class ButtonClickFrameTest {
	public static void main(String[] args) {
		JFrame frame = new ButtonClickFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(450, 80);
		frame.setVisible(true);
	}
}
