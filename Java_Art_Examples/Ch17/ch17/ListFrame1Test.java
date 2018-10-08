package ch17;

//Demo:  Test of JList

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

class JListPanel extends JPanel implements ListSelectionListener{
		String[] foods = {"Pizza", "Hamburger", "French Fries", "KFC", "Salad"};
		JList foodList;
	public JListPanel() {
		foodList = new JList(foods);					//��������5��ѡ����б�
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
				if ( selected == "Pizza")				//���ѡ����Pizza
					JOptionPane.showMessageDialog(null, "You have selected Pizza.");
				else if (selected == "Hamburger")		//���ѡ����Hamburger
					JOptionPane.showMessageDialog(null, "You have selected Hamburger.");
				else if (selected == "French Fries")	//���ѡ����French Fries
					JOptionPane.showMessageDialog(null, "You have selected French Fries.");
				else if (selected == "KFC")				//���ѡ����KFC
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
		setSize(250,140);							//��250����160����
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		centerWindow(this);							//�����Զ���������λ����ʾ��ܵķ���
	}

	private void centerWindow(JFrame frame) {		//����Ļ����λ����ʾ��ܵ��Զ��巽��
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		int centeredWidth = ((int)d.getWidth() - frame.getWidth())/2;	//�������Ŀ��
		int centeredHeight = ((int)d.getHeight() - frame.getHeight())/2;	//�������ĸ߶�
		setLocation(centeredWidth, centeredHeight);				//������ʾλ��
	}
}
public class ListFrame1Test {
	public static void main(String[] args) {
		JFrame frame = new JListFrame1();
		frame.setVisible(true);
	}
}