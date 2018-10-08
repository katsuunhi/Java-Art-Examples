package ch16;

//Example:  Use of JLabel, JPasswordField, JTextField, JButton and event handling

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class PasswordPanel extends JPanel implements ActionListener{
	private JPasswordField passwordField;
	private JButton okButton, exitButton;
	static private boolean correct;
	public PasswordPanel() {						//������
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		add(new JLabel("Enter your password:"));
		passwordField = new JPasswordField(10);
		add(passwordField);
		okButton = new JButton("Ok");				//����������ť
		exitButton = new JButton("Exit");
		add(okButton);							//��add(okButton);����ťע�ᵽ���ư�
		add(exitButton);
		okButton.addActionListener(this);			//��Ok��ťע�ᵽ�¼�����
		exitButton.addActionListener(this);			//��Exit��ťע�ᵽ�¼�����
		correct = false;
	}
	public void actionPerformed(ActionEvent e) {	//�����¼�����ӿڷ���
			Object source = e.getSource();			//�õ��¼�����Դ
			if (source == okButton) {				//�����okButton�������¼�
	 			String password = new String(passwordField.getPassword());
	 			if (password.equals("abc123")) {
					correct = true;
					setVisible(false);
					JFrame frame = new JTabbedPaneFrame2();
					frame.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Entry error!\nPlease check password and try again...");
					System.exit(0);
				}
			}
			else if (source == exitButton) {			//�����exitButton�������¼�
				JOptionPane.showMessageDialog(null, "Good bye!\nPress ȷ�� to close window...");
				System.exit(1);					//��������¼�
			}
		}
}