package ch17;

//Demo:  Test of JMenu with submenu

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class JMenuPanel extends JPanel implements ActionListener{
		JMenuBar productMenuBar;		//申明菜单栏
		JMenu fileMenu;					//申明菜单
		JMenu openMenu;
		JMenuItem openFromFile, openFromDatabase;			//申明菜单选项
		JMenuItem exitItem;
		JMenuItem saveItem;

	public JMenuPanel() {
		setLayout(new FlowLayout(FlowLayout.LEFT));

		productMenuBar = new JMenuBar();	//创建菜单栏
		fileMenu = new JMenu("File");		//创建菜单
		productMenuBar.add(fileMenu);		//将菜单注册到菜单栏

		fileMenu.addActionListener(this);

		openMenu = new JMenu("Open");						//创建菜单
		fileMenu.add(openMenu);							//将openMenu作为子菜单注册到fileMenu

		fileMenu.setMnemonic('F');

		openMenu.addActionListener(this);

		openFromFile = new JMenuItem("Open from File");			//创建菜单优选项
		openFromDatabase = new JMenuItem("Open from Database");
		openMenu.add(openFromFile);							//在子菜单中注册菜单选项
		openMenu.add(openFromDatabase);

		openFromFile.addActionListener(this);
		openFromDatabase.addActionListener(this);

		exitItem = new JMenuItem("Exit");
		fileMenu.add(exitItem);
		exitItem.addActionListener(this);

		if (productMenuBar.getMenu(0)  == fileMenu)
			System.out.println("The menu name is File");	//打印The menu name is File
		System.out.println(productMenuBar.getMenuCount());	//打印1
		if(fileMenu.getItem(1) == exitItem)
			System.out.println("The menu item is Exit");	//打印The menu item is Exit
		System.out.println(fileMenu.getItemCount());		//打印2

		fileMenu.insertSeparator(1);							//在Open菜单选项下面插入一行分隔线

		add(productMenuBar);
	}
 	public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			if (source == exitItem) {
				JOptionPane.showMessageDialog(null, "You have selected to exit.");
				System.exit(0);
			}
			else if(source == saveItem)
					JOptionPane.showMessageDialog(null, "You have selected Save from File.");
			else if (source == openFromFile)
					JOptionPane.showMessageDialog(null, "You have selected Open from File.");
			else if (source == openFromDatabase)
					JOptionPane.showMessageDialog(null, "You have selected Open from Database.");
	}
}

class JMenuFrame extends JFrame {
	JMenuFrame() {
		JPanel panel = new JMenuPanel();						//创建控制板
		this.add(panel);							//将控制板加入或注册到框架
		setTitle("JMenu Demo");
		setSize(300,150);							//宽210，高100像素
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		centerWindow(this);							//调用自定义在中心位置显示框架的方法
	}
	private void centerWindow(JFrame frame) {		//按屏幕中心位置显示框架的自定义方法
			Toolkit tk = Toolkit.getDefaultToolkit();
			Dimension d = tk.getScreenSize();
			int centeredWidth = ((int)d.getWidth() - frame.getWidth())/2;	//计算中心宽度
			int centeredHeight = ((int)d.getHeight() - frame.getHeight())/2;	//计算中心高度
			frame.setLocation(centeredWidth, centeredHeight);				//设置显示位置
	}

}
 class JMenuTest1 {
	public static void main(String[] args) {
		JMenuFrame menuFrame = new JMenuFrame();
		menuFrame.setVisible(true);
	}
}


