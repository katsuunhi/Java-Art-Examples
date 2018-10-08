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
	public ProductCalculatorPanel() {						//构造器
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
		okButton = new JButton("Ok");				//创建两个按钮
		exitButton = new JButton("Exit");
		add(okButton);							//或add(okButton);将按钮注册到控制板
		add(exitButton);
		okButton.addActionListener(this);			//将Ok按钮注册到事件处理
		exitButton.addActionListener(this);			//将Exit按钮注册到事件处理
	}
	public void actionPerformed(ActionEvent e) {	//完善事件处理接口方法
		String source = e.getActionCommand();			//得到事件发生源
			if (source == "Ok") {				//如果是okButton触发了事件
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
			else if (source == "Exit") {			//如果是exitButton触发了事件
				JOptionPane.showMessageDialog(null, "Good bye!\nPress 确定 to close window...");
				System.exit(1);					//处理这个事件
			}
		}
}