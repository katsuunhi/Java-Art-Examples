package ch15;

//Test:  Event handling of JRadioButton

import javax.swing.*;
import java.awt.event.*;

class JRadioButtonPanel extends JPanel implements ActionListener{
	private JLabel entryLabel;
	private JRadioButton check, creditCard, debtCard;
	private JButton okButton;
	public JRadioButtonPanel() {						//������
		entryLabel = new JLabel("Enter your payment type:");
		add(entryLabel);
		check =  new JRadioButton("Check", true);			//������Ԥѡ
		creditCard = new JRadioButton("Credit Card");		//����
		debtCard = new JRadioButton("Debt Card");
		add(check);											//ע�ᵽ���ư�
		add(creditCard);
		add(debtCard);
		ButtonGroup paymentGroup = new ButtonGroup();	//������ť��
		paymentGroup.add(check);						//ע�ᵽ��ť��
		paymentGroup.add(creditCard);
		paymentGroup.add(debtCard);
		check.addActionListener(this);					//ע�ᵽ�¼�����ӿ�
		creditCard.addActionListener(this);
		debtCard.addActionListener(this);
		okButton = new JButton("Ok");
		add(okButton);;
		okButton.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {	//�����¼�����ӿڷ���
		Object source = e.getSource();				//�õ��¼�����Դ
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