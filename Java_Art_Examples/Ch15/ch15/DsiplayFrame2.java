package ch15;
//Demo:  Use of JLabel, JTextField,JButton and event handling 

import javax.swing.*;
import java.awt.*;

class DisplayFrame3 extends JFrame {
	public DisplayFrame3() {
		setTitle("Display Frame");
		setSize(280,200);							//��280����200����
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		centerWindow(this);							//�����Զ���������λ����ʾ��ܵķ���
		JPanel panel = new DisplayPanel3();	//�������ư����
		this.add(panel);							//�����ư�����ע�ᵽ���
		}
	private void centerWindow(JFrame frame) {		//����Ļ����λ����ʾ��ܵ��Զ��巽��
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		int centeredWidth = ((int)d.getWidth() - frame.getWidth())/2;	//�������Ŀ��
		int centeredHeight = ((int)d.getHeight() - frame.getHeight())/2;	//�������ĸ߶�
		setLocation(centeredWidth, centeredHeight);				//������ʾλ��
	}
}