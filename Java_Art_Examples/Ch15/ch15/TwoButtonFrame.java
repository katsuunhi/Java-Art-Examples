package ch15;
//Demo: Two buttons in a frame
import javax.swing.*;
import java.awt.*;

class TwoButtonFrame extends JFrame {
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d = tk.getScreenSize();
	public TwoButtonFrame() {
		setTitle("Two Button Frame");
		setSize(300, 200);							//宽300，高200像素
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		centerWindow(this);							//调用自定义在中心位置显示框架的方法
		JPanel panel = new TwoButtonPanel();	//创建控制板对象
		this.add(panel);							//将控制板加入或注册到框架
		}
	private void centerWindow(JFrame frame) {		//按屏幕中心位置显示框架的自定义方法
		int centeredWidth = ((int)d.getWidth() - frame.getWidth())/2;	//计算中心宽度
		int centeredHeight = ((int)d.getHeight() - frame.getHeight())/2;	//计算中心高度
		setLocation(centeredWidth, centeredHeight);				//设置显示位置
	}
}