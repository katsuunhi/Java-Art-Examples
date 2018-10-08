package ch15;
//Demo:  Two buttons with event handling

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TwoButtonPanel2 extends JPanel implements ActionListener{  //编写按钮的JPanel类并处理按钮事件
	private JButton okButton, exitButton;		//申明两个按钮
	public TwoButtonPanel2() {					//构造器
		okButton = new JButton("Ok");			//创建两个按钮
		exitButton = new JButton("Exit");
		this.add(okButton);						//或add(okButton);将按钮注册到控制板
		this.add(exitButton);
		okButton.addActionListener(this);			//将Ok按钮注册到事件处理
		exitButton.addActionListener(this);			//将Exit按钮注册到事件处理
	}
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == okButton) {
 			JOptionPane.showMessageDialog(null, "Ok button is pressed...");
		}
		else if (source == exitButton) {
			JOptionPane.showMessageDialog(null, "Good bye!\nPress 确定 to close window...");
			System.exit(0);
		}
	}
}