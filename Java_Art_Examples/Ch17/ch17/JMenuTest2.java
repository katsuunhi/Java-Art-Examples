package ch17;
//Demo:  Test of JMenu with keyborad mnemonics and accelerators

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class JMenuPanel2 extends JPanel implements ActionListener{
		JMenuBar productMenuBar;		//�����˵���
		JMenu fileMenu;					//�����˵�
		JMenu openMenu;
		JMenuItem openFromFile, openFromDatabase;			//�����˵�ѡ��
		JMenuItem exitItem;
		JMenuItem saveItem;

	public JMenuPanel2() {
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

		openFromFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.ALT_MASK));
		openFromDatabase.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.SHIFT_MASK));

		openFromFile.addActionListener(this);
		openFromDatabase.addActionListener(this);

		exitItem = new JMenuItem("Exit");
		fileMenu.add(exitItem);
		exitItem.addActionListener(this);

		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_MASK
								+ KeyEvent.ALT_MASK));


		exitItem.setMnemonic('x');

		if (productMenuBar.getMenu(0)  == fileMenu)
			System.out.println("The menu name is File");	//��ӡThe menu name is File
		System.out.println(productMenuBar.getMenuCount());	//��ӡ1
		if(fileMenu.getItem(1) == exitItem)
			System.out.println("The menu item is Exit");	//��ӡThe menu item is Exit
		System.out.println(fileMenu.getItemCount());		//��ӡ2

		fileMenu.insertSeparator(1);							//��Open�˵�ѡ���������һ�зָ���

		saveItem = new JMenuItem("Save" , 'S');			//�����������Ǽ��Ĳ˵�ѡ��
		fileMenu.add(saveItem, 1);								//�ڵڶ�ѡ���в���


		saveItem.addActionListener(this);

		saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK));

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

class JMenuFrame2 extends JFrame {
	JMenuFrame2() {
		JPanel panel = new JMenuPanel2();						//�������ư�
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
public class JMenuTest2 {
	public static void main(String[] args) {
		JMenuFrame2 menuFrame = new JMenuFrame2();
		menuFrame.setVisible(true);
	}
}
