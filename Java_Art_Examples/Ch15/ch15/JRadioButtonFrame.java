package ch15;

//Test:  Event handling of JRadioButton

import javax.swing.*;
import java.awt.*;

class JRadioButtonFrame extends JFrame {
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d = tk.getScreenSize();
	public JRadioButtonFrame() {
		setTitle("Book information");
		setSize(400, 120);							//宽400，高120像素
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		centerWindow(this);						//调用自定义在中心位置显示框架的方法
		JPanel panel = new JRadioButtonPanel();		//创建控制板对象
		this.add(panel);							//将控制板加入或注册到框架
		}
	private void centerWindow(JFrame frame) {		//按屏幕中心位置显示框架的自定义方法
		int centeredWidth = ((int)d.getWidth() - frame.getWidth())/2;	//计算中心宽度
		int centeredHeight = ((int)d.getHeight() - frame.getHeight())/3;	//计算中心高度
		setLocation(centeredWidth, centeredHeight);				//设置显示位置
	}
}
