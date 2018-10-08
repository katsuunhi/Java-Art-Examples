package ch16;
//Demo:  Use of BorderLayout and FlowLayout to display two buttons at the lower-right corner

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class BorderLayoutPanel2 extends JPanel {
	private JButton okButton, exitButton;
	public BorderLayoutPanel2() {
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		okButton = new JButton("Ok");
		exitButton = new JButton("Exit");
		buttonPanel.add(okButton);
		buttonPanel.add(exitButton);
		setLayout(new BorderLayout());
		add(buttonPanel, BorderLayout.SOUTH);
	}
}

class BorderLayoutFrame2 extends JFrame {
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d = tk.getScreenSize();
	public BorderLayoutFrame2() {
		setTitle("Two Buttons Frame");
		setSize(300, 200);							//宽300，高200像素
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		centerWindow(this);							//调用自定义在中心位置显示框架的方法
		JPanel panel = new BorderLayoutPanel2();	//创建控制板对象
		this.add(panel);							//将控制板加入或注册到框架
		}
	private void centerWindow(JFrame frame) {		//按屏幕中心位置显示框架的自定义方法
		int centeredWidth = ((int)d.getWidth() - frame.getWidth())/2;	//计算中心宽度
		int centeredHeight = ((int)d.getHeight() - frame.getHeight())/2;	//计算中心高度
		setLocation(centeredWidth, centeredHeight);				//设置显示位置
	}
}
public class BorderLayoutFrameTest2 {
	public static void main(String[] args) {
		JFrame frame = new BorderLayoutFrame2();
		frame.setVisible(true);
	}
}
