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
		buttons = new JButton[5];	//����5��Ԫ�صİ�ť����
		post = 0;						//����ֵ
		layout = new BorderLayout(5, 5);
		setLayout(layout);			//����Χ�粼�֣�ÿ��������ܱ߿�϶Ϊ5������

		for (int i = 0; i < 5; i++)
		  buttons[i] = new JButton("button" + post++);

		add(buttons[0], BorderLayout.NORTH);
		add(buttons[1], BorderLayout.SOUTH);
		add(buttons[2], BorderLayout.WEST);
		add(buttons[3], BorderLayout.EAST);
		add(buttons[4]);
	}
}


