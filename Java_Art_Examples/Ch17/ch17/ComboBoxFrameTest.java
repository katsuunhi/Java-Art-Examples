package ch17;

//Demo:  Test of JComboBox

import javax.swing.*;
import java.awt.*;

class ComboBoxFrame extends JFrame {
		String[] books = {"Programming Arts in Java", "All C/C++ Programming", "JSP and Servlets"};
	public ComboBoxFrame() {
		JComboBox bookComboBox = new JComboBox(books);	//��������3��ѡ��������б�
		add(bookComboBox);								//ע�ᵽ��ǰ����

		setTitle("JComboBox Test");
		setSize(250,60);							//��250����60����
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
public class ComboBoxFrameTest {
	public static void main(String[] args) {
		JFrame frame = new ComboBoxFrame();
		frame.setVisible(true);
	}
}

