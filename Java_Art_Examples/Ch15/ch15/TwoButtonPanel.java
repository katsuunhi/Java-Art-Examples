package ch15;
//Demo: two buttons in a frame
import javax.swing.*;

class TwoButtonPanel extends JPanel {				//��д�������Ű�ť��JPanel��
	private JButton okButton, exitButton;			//����������ť
	public TwoButtonPanel() {						//������
		okButton = new JButton("Ok");				//����������ť
		exitButton = new JButton("Exit");
		this.add(okButton);							//��add(okButton);����ťע�ᵽ���ư�
		this.add(exitButton);
	}
}