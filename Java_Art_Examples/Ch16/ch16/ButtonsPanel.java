package ch16;
//Demo:  Two buttons panel

import javax.swing.*;
import java.awt.*;

class ButtonsPanel extends JPanel {				//��д�������Ű�ť��JPanel��
	private JButton okButton, exitButton;		//����������ť
	public ButtonsPanel() {						//������
		okButton = new JButton("Ok");			//����������ť
		exitButton = new JButton("Exit");
		this.add(okButton);						//��add(okButton);����ťע�ᵽ���ư�
		this.add(exitButton);
	}
}