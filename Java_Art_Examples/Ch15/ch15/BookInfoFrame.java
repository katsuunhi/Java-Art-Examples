package ch15;
//Example:  Use of JCheckBox, other componenets and event handling

import javax.swing.*;
import java.awt.*;

class BookInfoFrame extends JFrame {
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d = tk.getScreenSize();
	public BookInfoFrame() {
		setTitle("Book information");
		setSize(520, 125);							//��300����200����
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		centerWindow(this);						//�����Զ���������λ����ʾ��ܵķ���
		JPanel panel = new BookInfoPanel();		//�������ư����
		this.add(panel);							//�����ư�����ע�ᵽ���
		}
	private void centerWindow(JFrame frame) {		//����Ļ����λ����ʾ��ܵ��Զ��巽��
		int centeredWidth = ((int)d.getWidth() - frame.getWidth())/2;	//�������Ŀ��
		int centeredHeight = ((int)d.getHeight() - frame.getHeight())/3;	//�������ĸ߶�
		setLocation(centeredWidth, centeredHeight);				//������ʾλ��
	}
}
