package ch17;

//Demo:  Test of JComboBox

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SelectPanel extends JPanel implements ActionListener {		//编写用来安排下拉列表的JPanel类
		JComboBox myComboBox;					//申明一个下拉列表
	public SelectPanel() {						//构造器
		myComboBox = new JComboBox();			//创建一个空下拉列表
		myComboBox.addItem("Pizza");			//在下列列表中增添3行选项
		myComboBox.addItem("Hamburger");
		myComboBox.addItem("KFC");
		myComboBox.insertItemAt("French Fries", 2);			//在KFC前插入这个选项行
		add(myComboBox);
		myComboBox.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == myComboBox) {				//如果下拉列表触发了事件
			if (myComboBox.getSelectedItem() == "Pizza")				//如果选项是Pizza
				JOptionPane.showMessageDialog(null, "You have selected Pizza.");
			else if (myComboBox.getSelectedItem() == "Hamburger")		//如果选项是Hamburger
				JOptionPane.showMessageDialog(null, "You have selected Hamburger.");
			else if (myComboBox.getSelectedItem() == "French Fries")	//如果选项是French Fries
				JOptionPane.showMessageDialog(null, "You have selected French Fries.");
			else													//如果选项是KFC
				JOptionPane.showMessageDialog(null, "You have selected KFC.");
		}
	}
}
class ComboBoxFrame2 extends JFrame {
	public ComboBoxFrame2() {
		JPanel selectPanel = new SelectPanel();						//创建控制板
		this.add(selectPanel);							//将控制板加入或注册到框架
		setTitle("JComboBox Test");
		setSize(250,80);							//宽250，高80像素
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
public class ComboBoxFrame2Test {
	public static void main(String[] args) {
		JFrame frame = new ComboBoxFrame2();
		frame.setVisible(true);
	}
}

