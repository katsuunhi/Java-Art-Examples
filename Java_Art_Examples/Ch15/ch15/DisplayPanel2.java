package ch15;
//Demo:  Use of JLabel, JTextField,JButton and event handling 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

class DisplayPanel3 extends JPanel implements ActionListener{					//��д�������ŵ�JPanel��
	private final double cdPrice = 2.99,
						 dvdPrice = 19.89;
	private JTextField productField, quantityField, totalField;
	private JButton okButton, exitButton;
	public DisplayPanel3() {						//������
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		add(new JLabel("Enter product name:"));
		productField = new JTextField("CD or DVD", 10);
		add(productField);
		add(new JLabel("Enter the quantity:"));
		quantityField = new JTextField(10);
		add(quantityField);
		add(new JLabel("The total amount:"));
		totalField = new JTextField("$0.00", 10);
		totalField.setEditable(false);
		add(totalField);
		okButton = new JButton("Ok");				//����������ť
		exitButton = new JButton("Exit");
		add(okButton);							//��add(okButton);����ťע�ᵽ���ư�
		add(exitButton);
		okButton.addActionListener(this);
		exitButton.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == okButton) {
		 	if (productField.getText().equals("CD")) {
				double total = Integer.parseInt(quantityField.getText()) * cdPrice;
				totalField.setText(NumberFormat.getCurrencyInstance().format(total));
			}
			else if (productField.getText().equals("DVD")) {
				double total = Integer.parseInt(quantityField.getText()) * dvdPrice;
				totalField.setText(NumberFormat.getCurrencyInstance().format(total));
			}
		}
		else if (source == exitButton) {
			JOptionPane.showMessageDialog(null, "Good bye!\nPress ȷ�� to close window...");
			System.exit(0);
		}
	}
}
