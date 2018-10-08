package ch16;
//Demo:  Use of FlowLayout

import java.awt.*;
import javax.swing.*;

class TwoButtonsPanel extends JPanel {
   public TwoButtonsPanel() {
   	FlowLayout flowLayout = new FlowLayout(FlowLayout.RIGHT);//创建组件向右对齐流程布局管理
   	setLayout(flowLayout);									 //将这个布局管理注册到控制板
   	add(new JButton("Button One"));							 //创建两个演示按钮
   	add(new JButton("Button Two"));
   }
}
class TwoButtonsFrame extends JFrame {
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d = tk.getScreenSize();
	public TwoButtonsFrame() {
		setTitle("Use of FlowLayout");
		setSize(300, 120);							//宽400，高220像素
		//setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		centerWindow(this);						//调用自定义在中心位置显示框架的方法
		JPanel panel = new TwoButtonsPanel();		//创建控制板对象
		this.add(panel);							//将控制板加入或注册到框架
		}
	private void centerWindow(JFrame frame) {		//按屏幕中心位置显示框架的自定义方法
		int centeredWidth = ((int)d.getWidth() - frame.getWidth())/2;	//计算中心宽度
		int centeredHeight = ((int)d.getHeight() - frame.getHeight())/3;	//计算中心高度
		setLocation(centeredWidth, centeredHeight);				//设置显示位置
	}
}
public class TwoButtonsFrameTest {
	public static void main(String[] args) {
		JFrame frame = new TwoButtonsFrame();
		frame.setVisible(true);
	}
}
