package ch17;

//Demo:  Test of JComboBox

import javax.swing.*;
import java.awt.*;

class ComboBoxFrame extends JFrame {
		String[] books = {"Programming Arts in Java", "All C/C++ Programming", "JSP and Servlets"};
	public ComboBoxFrame() {
		JComboBox bookComboBox = new JComboBox(books);	//创建具有3行选项的下拉列表
		add(bookComboBox);								//注册到当前窗口

		setTitle("JComboBox Test");
		setSize(250,60);							//宽250，高60像素
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		centerWindow(this);							//调用自定义在中心位置显示框架的方法
	}
	private void centerWindow(JFrame frame) {		//按屏幕中心位置显示框架的自定义方法
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		int centeredWidth = ((int)d.getWidth() - frame.getWidth())/2;	//计算中心宽度
		int centeredHeight = ((int)d.getHeight() - frame.getHeight())/2;	//计算中心高度
		setLocation(centeredWidth, centeredHeight);				//设置显示位置
	}
}
public class ComboBoxFrameTest {
	public static void main(String[] args) {
		JFrame frame = new ComboBoxFrame();
		frame.setVisible(true);
	}
}

