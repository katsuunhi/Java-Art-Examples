package ch17;

//Demo:  Test of JList

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

class JListPanel extends JPanel implements ListSelectionListener{
		String[] foods = {"Pizza", "Hamburger", "French Fries", "KFC", "Salad"};
		JList foodList;
	public JListPanel() {
		foodList = new JList(foods);					//创建具有5行选项的列表
		foodList.setFixedCellWidth(200);
		foodList.setVisibleRowCount(4);
		foodList.setSelectedIndex(0);
		foodList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		add(new JScrollPane(foodList));

		foodList.addListSelectionListener(this);
	}
 	public void valueChanged(ListSelectionEvent e) {
			Object source = e.getSource();
			if (source == foodList) {
				String selected = (String) foodList.getSelectedValue();
				if ( selected == "Pizza")				//如果选项是Pizza
					JOptionPane.showMessageDialog(null, "You have selected Pizza.");
				else if (selected == "Hamburger")		//如果选项是Hamburger
					JOptionPane.showMessageDialog(null, "You have selected Hamburger.");
				else if (selected == "French Fries")	//如果选项是French Fries
					JOptionPane.showMessageDialog(null, "You have selected French Fries.");
				else if (selected == "KFC")				//如果选项是KFC
					JOptionPane.showMessageDialog(null, "You have selected KFC.");
				else if (selected == "Salad")
					JOptionPane.showMessageDialog(null, "You have selected Salad.");
			}
			else
				System.exit(0);
	}

}
class JListFrame1 extends JFrame {
	public JListFrame1() {
		JPanel listPanel = new JListPanel();
		add(listPanel);
		setTitle("JList event handling Test 1");
		setSize(250,140);							//宽250，高160像素
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
public class ListFrame1Test {
	public static void main(String[] args) {
		JFrame frame = new JListFrame1();
		frame.setVisible(true);
	}
}