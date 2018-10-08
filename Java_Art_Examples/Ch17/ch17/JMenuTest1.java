package ch17;

//Demo:  Test of JMenu with submenu

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class JMenuPanel extends JPanel implements ActionListener{
		JMenuBar productMenuBar;		//�����˵���
		JMenu fileMenu;					//�����˵�
		JMenu openMenu;
		JMenuItem openFromFile, openFromDatabase;			//�����˵�ѡ��
		JMenuItem exitItem;
		JMenuItem saveItem;

	public JMenuPanel() {
		setLayout(new FlowLayout(FlowLayout.LEFT));

		productMenuBar = new JMenuBar();	//�����˵���
		fileMenu = new JMenu("File");		//�����˵�
		productMenuBar.add(fileMenu);		//���˵�ע�ᵽ�˵���

		fileMenu.addActionListener(this);

		openMenu = new JMenu("Open");						//�����˵�
		fileMenu.add(openMenu);							//��openMenu��Ϊ�Ӳ˵�ע�ᵽfileMenu

		fileMenu.setMnemonic('F');

		openMenu.addActionListener(this);

		openFromFile = new JMenuItem("Open from File");			//�����˵���ѡ��
		openFromDatabase = new JMenuItem("Open from Database");
		openMenu.add(openFromFile);							//���Ӳ˵���ע��˵�ѡ��
		openMenu.add(openFromDatabase);

		openFromFile.addActionListener(this);
		openFromDatabase.addActionListener(this);

		exitItem = new JMenuItem("Exit");
		fileMenu.add(exitItem);
		exitItem.addActionListener(this);

		if (productMenuBar.getMenu(0)  == fileMenu)
			System.out.println("The menu name is File");	//��ӡThe menu name is File
		System.out.println(productMenuBar.getMenuCount());	//��ӡ1
		if(fileMenu.getItem(1) == exitItem)
			System.out.println("The menu item is Exit");	//��ӡThe menu item is Exit
		System.out.println(fileMenu.getItemCount());		//��ӡ2

		fileMenu.insertSeparator(1);							//��Open�˵�ѡ���������һ�зָ���

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
		JPanel panel = new JMenuPanel();						//�������ư�
		this.add(panel);							//�����ư�����ע�ᵽ���
		setTitle("JMenu Demo");
		setSize(300,150);							//��210����100����
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		centerWindow(this);							//�����Զ���������λ����ʾ��ܵķ���
	}
	private void centerWindow(JFrame frame) {		//����Ļ����λ����ʾ��ܵ��Զ��巽��
			Toolkit tk = Toolkit.getDefaultToolkit();
			Dimension d = tk.getScreenSize();
			int centeredWidth = ((int)d.getWidth() - frame.getWidth())/2;	//�������Ŀ��
			int centeredHeight = ((int)d.getHeight() - frame.getHeight())/2;	//�������ĸ߶�
			frame.setLocation(centeredWidth, centeredHeight);				//������ʾλ��
	}

}
 class JMenuTest1 {
	public static void main(String[] args) {
		JMenuFrame menuFrame = new JMenuFrame();
		menuFrame.setVisible(true);
	}
}


