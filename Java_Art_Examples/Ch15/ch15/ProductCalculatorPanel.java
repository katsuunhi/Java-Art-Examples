package ch15;

//Example:  Use of JLabel, JTextField,JButton and event handling to calculate product total

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

class ProductCalculatorPanel extends JPanel implements ActionListener{
	private final double CD_PRICE = 2.99,
					     DVD_PRICE = 19.89;
	private JTextField productField, quantityField, totalField;
	private JButton okButton, exitButton;
	public ProductCalculatorPanel() {						//������
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
		okButton.addActionListener(this);			//��Ok��ťע�ᵽ�¼�����
		exitButton.addActionListener(this);			//��Exit��ťע�ᵽ�¼�����
	}
	public void actionPerformed(ActionEvent e) {	//�����¼�����ӿڷ���
		String source = e.getActionCommand();			//�õ��¼�����Դ
			if (source == "Ok") {				//�����okButton�������¼�
	 			if (productField.getText().equals("CD")) {
					int quantity = Integer.parseInt(quantityField.getText());
					double total = CD_PRICE * quantity;
					totalField.setText(NumberFormat.getCurrencyInstance().format(total));
				}
				else if (productField.getText().equals("DVD")) {
					Integer quantity = Integer.parseInt(quantityField.getText());
					double total = DVD_PRICE * quantity;
					totalField.setText(NumberFormat.getCurrencyInstance().format(total));
				}
				else {
					JOptionPane.showMessageDialog(null, "Entry error!\nPlease check product name and try again...");
					System.exit(0);
				}
			}
			else if (source == "Exit") {			//�����exitButton�������¼�
				JOptionPane.showMessageDialog(null, "Good bye!\nPress ȷ�� to close window...");
				System.exit(1);					//��������¼�
			}
		}
}