package ch16;

//Demo:  Test of components in 3 rows and 2 columns in GridLayout

import javax.swing.*;
import java.awt.*;

class GridLayoutPanel extends JPanel {
	public GridLayoutPanel() {
		setLayout(new GridLayout(3, 2));			//创建
		add(new JLabel("Label"));
		add(new JTextField("Text Field"));
		add(new JButton("Button"));
		add(new JCheckBox("Check Box"));
		add(new JTextArea("Text Area"));
	}
}
class GridLayoutFrame extends JFrame {
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d = tk.getScreenSize();
	public GridLayoutFrame() {
		setTitle("Components in Y-Axis in BoxLayout");
		setSize(300, 200);							//宽400，高100像素
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		centerWindow(this);							//调用自定义在中心位置显示框架的方法
		JPanel panel = new GridLayoutPanel();	//创建控制板对象
		this.add(panel);							//将控制板加入或注册到框架
		}
	private void centerWindow(JFrame frame) {		//按屏幕中心位置显示框架的自定义方法
		int centeredWidth = ((int)d.getWidth() - frame.getWidth())/2;	//计算中心宽度
		int centeredHeight = ((int)d.getHeight() - frame.getHeight())/2;	//计算中心高度
		setLocation(centeredWidth, centeredHeight);				//设置显示位置
	}
}
public class GridLayoutFrameTest {
	public static void main(String[] args) {
		JFrame frame = new GridLayoutFrame();
		frame.setVisible(true);
	}
}