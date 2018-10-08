package ch18;

// Application:  Use of Border, GridBagLayout, JList, JLabel, JTextField, JTextArea and event handling
//to show common use OOP terms.

import javax.swing.*;


import java.awt.*;

class OOPListFrame extends JFrame {
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d = tk.getScreenSize();
	public OOPListFrame() {
		setTitle("OOP Terminology");
		setSize(530, 250);							//宽530，高250像素
		//setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		centerWindow(this);						//调用自定义在中心位置显示框架的方法
		JPanel panel = new OOPListPanel();		//创建控制板对象
		this.add(panel);							//将控制板加入或注册到框架
		}
	private void centerWindow(JFrame frame) {		//按屏幕中心位置显示框架的自定义方法
		int centeredWidth = ((int)d.getWidth() - frame.getWidth())/2;	//计算中心宽度
		int centeredHeight = ((int)d.getHeight() - frame.getHeight())/3;	//计算中心高度
		setLocation(centeredWidth, centeredHeight);				//设置显示位置
	}
}
