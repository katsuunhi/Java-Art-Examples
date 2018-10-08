package ch17;

//Demo�� use of MenuListener to handling Menu events.

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class JMenuTest3 extends JFrame implements MenuListener {
	private JMenu fileMenu, helpMenu;
  public JMenuTest3() {
    super("�˵��¼�������ʾ");

    fileMenu = new JMenu("�ļ�(F)");
    fileMenu.setMnemonic('F');
    fileMenu.addMenuListener(this);
    fileMenu.add(new JMenuItem("��"));
    fileMenu.add(new JMenuItem("�ر�"));

    helpMenu = new JMenu("����(H)");
    helpMenu.setMnemonic('H');
    helpMenu.addMenuListener(this);
    helpMenu.add(new JMenuItem("���ڲ˵�"));
    helpMenu.insertSeparator(1);

    helpMenu.add(new JMenuItem("�����¼�����"));

    JMenuBar mb = new JMenuBar();
    mb.add(fileMenu);
    mb.add(helpMenu);
    setJMenuBar(mb);


	setSize(250,140);							//��250����140����
	setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	centerWindow(this);							//�����Զ���������λ����ʾ��ܵķ���
  }
  public void menuSelected(MenuEvent e) {
	  display("Menu Selected: ", e);
	  if(e.getSource() == helpMenu) {
	  	fileMenu.setVisible(false);
	  	menuCanceled(e);
	  }
  }
  public void menuDeselected(MenuEvent e) {
  	  display("Menu deselected:", e);
  	  if(e.getSource() == helpMenu) {
	  	  	fileMenu.setVisible(true);
	  }
  }
  public void menuCanceled(MenuEvent e) {
  	  display("Menu canceled �ļ� menu:", e);
  }
  private void display(String s, MenuEvent e) {
          JMenu menu = (JMenu) e.getSource();
          System.out.println(s + ": " + menu.getText());
  }

  private void centerWindow(JFrame frame) {		//����Ļ����λ����ʾ��ܵ��Զ��巽��
  			Toolkit tk = Toolkit.getDefaultToolkit();
  			Dimension d = tk.getScreenSize();
  			int centeredWidth = ((int)d.getWidth() - frame.getWidth())/2;	//�������Ŀ��
  			int centeredHeight = ((int)d.getHeight() - frame.getHeight())/2;	//�������ĸ߶�
  			frame.setLocation(centeredWidth, centeredHeight);				//������ʾλ��
	}


  public static void main(String args[]) {
    JFrame frame = new JMenuTest3();
    frame.setVisible(true);
  }
}