package ch15;
//Demo:  Two buttons with event handling

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TwoButtonPanel2 extends JPanel implements ActionListener{  //��д��ť��JPanel�ಢ����ť�¼�
	private JButton okButton, exitButton;		//����������ť
	public TwoButtonPanel2() {					//������
		okButton = new JButton("Ok");			//����������ť
		exitButton = new JButton("Exit");
		this.add(okButton);						//��add(okButton);����ťע�ᵽ���ư�
		this.add(exitButton);
		okButton.addActionListener(this);			//��Ok��ťע�ᵽ�¼�����
		exitButton.addActionListener(this);			//��Exit��ťע�ᵽ�¼�����
	}
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == okButton) {
 			JOptionPane.showMessageDialog(null, "Ok button is pressed...");
		}
		else if (source == exitButton) {
			JOptionPane.showMessageDialog(null, "Good bye!\nPress ȷ�� to close window...");
			System.exit(0);
		}
	}
}