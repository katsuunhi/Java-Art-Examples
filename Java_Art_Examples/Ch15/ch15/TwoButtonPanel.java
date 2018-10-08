package ch15;
//Demo: two buttons in a frame
import javax.swing.*;

class TwoButtonPanel extends JPanel {				//编写用来安排按钮的JPanel类
	private JButton okButton, exitButton;			//申明两个按钮
	public TwoButtonPanel() {						//构造器
		okButton = new JButton("Ok");				//创建两个按钮
		exitButton = new JButton("Exit");
		this.add(okButton);							//或add(okButton);将按钮注册到控制板
		this.add(exitButton);
	}
}