package ch15;
//Demo:  Test of JLabel

import javax.swing.*;
import java.awt.*;

class DisplayPanel extends JPanel {					//��д�������ŵ�JPanel��
	private JLabel productLabel, quantityLabel, totalLabel;
	public DisplayPanel() {						//������
		setLayout(new FlowLayout(FlowLayout.RIGHT));	//
		add(new JLabel("Enter product name:"));			//
		add(new JLabel("Enter the quantity:"));
		add(new JLabel("The total amount:"));
	}
}