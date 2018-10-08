package ch16;

//Example:  Use of JLabel, JPasswordField, JTextField, JButton and event handling

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class PasswordPanel extends JPanel implements ActionListener{
	private JPasswordField passwordField;
	private JButton okButton, exitButton;
	static private boolean correct;
	public PasswordPanel() {						//构造器
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		add(new JLabel("Enter your password:"));
		passwordField = new JPasswordField(10);
		add(passwordField);
		okButton = new JButton("Ok");				//创建两个按钮
		exitButton = new JButton("Exit");
		add(okButton);							//或add(okButton);将按钮注册到控制板
		add(exitButton);
		okButton.addActionListener(this);			//将Ok按钮注册到事件处理
		exitButton.addActionListener(this);			//将Exit按钮注册到事件处理
		correct = false;
	}
	public void actionPerformed(ActionEvent e) {	//完善事件处理接口方法
			Object source = e.getSource();			//得到事件发生源
			if (source == okButton) {				//如果是okButton触发了事件
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
			else if (source == exitButton) {			//如果是exitButton触发了事件
				JOptionPane.showMessageDialog(null, "Good bye!\nPress 确定 to close window...");
				System.exit(1);					//处理这个事件
			}
		}
}