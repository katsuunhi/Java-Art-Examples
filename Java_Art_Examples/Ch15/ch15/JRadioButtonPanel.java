package ch15;

//Test:  Event handling of JRadioButton

import javax.swing.*;
import java.awt.event.*;

class JRadioButtonPanel extends JPanel implements ActionListener{
	private JLabel entryLabel;
	private JRadioButton check, creditCard, debtCard;
	private JButton okButton;
	public JRadioButtonPanel() {						//构造器
		entryLabel = new JLabel("Enter your payment type:");
		add(entryLabel);
		check =  new JRadioButton("Check", true);			//创建并预选
		creditCard = new JRadioButton("Credit Card");		//创建
		debtCard = new JRadioButton("Debt Card");
		add(check);											//注册到控制板
		add(creditCard);
		add(debtCard);
		ButtonGroup paymentGroup = new ButtonGroup();	//创建按钮组
		paymentGroup.add(check);						//注册到按钮组
		paymentGroup.add(creditCard);
		paymentGroup.add(debtCard);
		check.addActionListener(this);					//注册到事件处理接口
		creditCard.addActionListener(this);
		debtCard.addActionListener(this);
		okButton = new JButton("Ok");
		add(okButton);;
		okButton.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {	//完善事件处理接口方法
		Object source = e.getSource();				//得到事件发生源
		if (source == okButton) {
		    if (check.isSelected())
			   JOptionPane.showMessageDialog(null, "Check is selected...");
		    else if (creditCard.isSelected())
			    JOptionPane.showMessageDialog(null, "Credit card is selected...");
			else if (debtCard.isSelected())
				JOptionPane.showMessageDialog(null, "Debt card is selected...");
		}
		if (source == check)
			  JOptionPane.showMessageDialog(null, "check triggered the event...");
		if (source == creditCard)
			  JOptionPane.showMessageDialog(null, "creditCard triggered the event...");
		if (source == debtCard)
			  JOptionPane.showMessageDialog(null, "debtCard triggered the event...");
	}
}