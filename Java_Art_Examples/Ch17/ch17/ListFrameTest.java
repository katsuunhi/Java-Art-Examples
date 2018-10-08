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
		foodList = new JList(foods);					//��������5��ѡ����б�
		foodList.setFixedCellWidth(200);
		foodList.setVisibleRowCount(4);
		foodList.setSelectedIndex(0);
		foodList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		foodPanel.add(new JScrollPane(foodList));
		add(foodPanel);

		setTitle("JList Test");
		setSize(250,140);							//��250����140����
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
public class ListFrameTest {
	public static void main(String[] args) {
		JFrame frame = new JListFrame();
		frame.setVisible(true);
	}
}
