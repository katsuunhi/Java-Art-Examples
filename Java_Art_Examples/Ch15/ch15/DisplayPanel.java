package ch15;
//Demo:  Test of JLabel

import javax.swing.*;
import java.awt.*;

class DisplayPanel extends JPanel {					//编写用来安排的JPanel类
	private JLabel productLabel, quantityLabel, totalLabel;
	public DisplayPanel() {						//构造器
		setLayout(new FlowLayout(FlowLayout.RIGHT));	//
		add(new JLabel("Enter product name:"));			//
		add(new JLabel("Enter the quantity:"));
		add(new JLabel("The total amount:"));
	}
}