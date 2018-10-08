package ch15;

//Demo:  creating text fields

import javax.swing.*;
import java.awt.*;

class DisplayPanel2 extends JPanel {				//编写用来显示文本字段的JPanel子类
	private JTextField productField, quantityField, totalField;
	public DisplayPanel2() {						//构造器
		setLayout(new FlowLayout(FlowLayout.RIGHT));	//向右对齐
		productField = new JTextField(18);				//创建显示18个字符串的文本字段
		add(productField);								//注册到控制板
		quantityField = new JTextField(15);				//创建显示10个字符串的文本字段
		add(quantityField);								//注册到控制板
		totalField = new JTextField("$0.00", 10);				//创建有预设显示内容的文本字段
		totalField.setEditable(false);						//设置为内容不可编辑，即做输出显示
		add(totalField);								//注册到控制板

	}
}
class DisplayFrame2 extends JFrame {
	public DisplayFrame2() {
		setTitle("Display Frame");
		setSize(220,160);							
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		centerWindow(this);							//调用自定义在中心位置显示框架的方法
		JPanel panel = new DisplayPanel2();			//创建控制板对象
		this.add(panel);							//将控制板加入或注册到框架
		}
	private void centerWindow(JFrame frame) {		//按屏幕中心位置显示框架的自定义方法
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		int centeredWidth = ((int)d.getWidth() - frame.getWidth())/2;	//计算中心宽度
		int centeredHeight = ((int)d.getHeight() - frame.getHeight())/2;	//计算中心高度
		setLocation(centeredWidth, centeredHeight);				//设置显示位置
	}
}
public class DisplayFrame2Test {
	public static void main(String[] args) {
		JFrame frame = new DisplayFrame2();
		frame.setVisible(true);
	}
}