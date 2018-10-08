package ch16;

//Demo:  Test of 5 regions and changes in BorderLayout

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class BorderLayoutPanel3 extends JPanel implements ActionListener {
	private JButton[] buttons;
	private BorderLayout layout;
	private int post,
				count;
	public BorderLayoutPanel3() {
		buttons = new JButton[5];	//创建5个元素的按钮数组
		post = count = 0;						//区域值
		layout = new BorderLayout(5, 5);
		setLayout(layout);			//创建围界布局，每个区域的周边空隙为5个像素

		for (int i = 0; i < 5; i++)
		  buttons[i] = new JButton("button" + post++);

		add(buttons[0], BorderLayout.NORTH);
		add(buttons[1], BorderLayout.SOUTH);
		add(buttons[2], BorderLayout.WEST);
		add(buttons[3], BorderLayout.EAST);
		add(buttons[4]);

		for (int i = 0; i < 5; i++)
			buttons[i].addActionListener(this);			//注册每个按钮事件处理
	}
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (count < 4) {
			for (int i = 0; i < 5; i++)
				if (source == buttons[i]) {
		  			buttons[i].setVisible(false);
		  			count++;
				}
		}
	    else {
		  for(JButton button : buttons)
		    button.setVisible(true);
		  count = 0;
		}
	}
}
class BorderLayoutFrame3 extends JFrame {
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d = tk.getScreenSize();
	public BorderLayoutFrame3() {
		setTitle("Five Buttons in BorderLayout");
		setSize(360, 200);							//宽360，高200像素
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		centerWindow(this);							//调用自定义在中心位置显示框架的方法
		JPanel panel = new BorderLayoutPanel3();	//创建控制板对象
		this.add(panel);							//将控制板加入或注册到框架
		}
	private void centerWindow(JFrame frame) {		//按屏幕中心位置显示框架的自定义方法
		int centeredWidth = ((int)d.getWidth() - frame.getWidth())/2;	//计算中心宽度
		int centeredHeight = ((int)d.getHeight() - frame.getHeight())/2;	//计算中心高度
		setLocation(centeredWidth, centeredHeight);				//设置显示位置
	}
}
public class BorderLayoutFrameTest3 {
	public static void main(String[] args) {
		JFrame frame = new BorderLayoutFrame3();
		frame.setVisible(true);
	}
}

