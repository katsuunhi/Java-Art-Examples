package ch16;

//Demo:  Test of nested BoxLayout with BorderLayout

import javax.swing.*;
import java.awt.*;

class BoxLayoutFrame2 extends JFrame {
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d = tk.getScreenSize();
	public BoxLayoutFrame2() {
		//setLayout(new FlowLayout());
		JPanel componentPanel1 = new JPanel();
		componentPanel1.setLayout(new BoxLayout(componentPanel1, BoxLayout.Y_AXIS));
		componentPanel1.add(new JLabel("Label"));
		componentPanel1.add(new JTextField("Text Field"));

		JPanel componentPanel2 = new JPanel();
		componentPanel2.setLayout(new BoxLayout(componentPanel2, BoxLayout.X_AXIS));
		componentPanel2.add(new JCheckBox("Check Box"));
		componentPanel2.add(new JButton("Button"));

		add(componentPanel1, BorderLayout.NORTH);
		add(componentPanel2, BorderLayout.SOUTH);

		//Container contentPane = getContentPane();
		//contentPane.add(componentPanel1, BorderLayout.NORTH);
		//contentPane.add(componentPanel2, BorderLayout.SOUTH);

		setTitle("Components in nested Layouts");
		setSize(220, 200);							//宽220，高200像素
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		centerWindow(this);							//调用自定义在中心位置显示框架的方法
		}
	private void centerWindow(JFrame frame) {		//按屏幕中心位置显示框架的自定义方法
		int centeredWidth = ((int)d.getWidth() - frame.getWidth())/2;	//计算中心宽度
		int centeredHeight = ((int)d.getHeight() - frame.getHeight())/2;	//计算中心高度
		setLocation(centeredWidth, centeredHeight);				//设置显示位置
	}
}
public class BoxLayoutFrameTest2 {
	public static void main(String[] args) {
		JFrame frame = new BoxLayoutFrame2();
		frame.setVisible(true);
	}
}

