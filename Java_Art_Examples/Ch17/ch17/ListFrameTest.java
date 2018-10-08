package ch17;

//Demo:  Test of JList

import javax.swing.*;
import java.awt.*;

class JListFrame extends JFrame {
		String[] foods = {"Pizza", "Hamburger", "French Fries", "KFC", "Salad"};
		JList foodList;
		JPanel foodPanel;
	public JListFrame() {
		foodPanel = new JPanel();
		foodList = new JList(foods);					//创建具有5行选项的列表
		foodList.setFixedCellWidth(200);
		foodList.setVisibleRowCount(4);
		foodList.setSelectedIndex(0);
		foodList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		foodPanel.add(new JScrollPane(foodList));
		add(foodPanel);

		setTitle("JList Test");
		setSize(250,140);							//宽250，高140像素
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
public class ListFrameTest {
	public static void main(String[] args) {
		JFrame frame = new JListFrame();
		frame.setVisible(true);
	}
}
