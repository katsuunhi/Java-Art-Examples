package ch16;

//Demo:  5 regions in BorderLayout

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

class BorderLayoutPanel extends JPanel {
	private JButton[] buttons;
	private BorderLayout layout;
	private int post;
	public BorderLayoutPanel() {
		buttons = new JButton[5];	//创建5个元素的按钮数组
		post = 0;						//区域值
		layout = new BorderLayout(5, 5);
		setLayout(layout);			//创建围界布局，每个区域的周边空隙为5个像素

		for (int i = 0; i < 5; i++)
		  buttons[i] = new JButton("button" + post++);

		add(buttons[0], BorderLayout.NORTH);
		add(buttons[1], BorderLayout.SOUTH);
		add(buttons[2], BorderLayout.WEST);
		add(buttons[3], BorderLayout.EAST);
		add(buttons[4]);
	}
}


