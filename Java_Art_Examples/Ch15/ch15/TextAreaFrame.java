package ch15;
//Example:  Use of JTextArea, JScrollPane and event handling
//Copy the content of the text area to output window of the JOptionPane

import javax.swing.*;
import java.awt.*;

class TextAreaFrame extends JFrame {
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d = tk.getScreenSize();
	public TextAreaFrame() {
		setTitle("TextArea Test");
		setSize(280, 200);							//��300����200����
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		centerWindow(this);						//�����Զ���������λ����ʾ��ܵķ���
		JPanel panel = new TextAreaPanel();		//�������ư����
		this.add(panel);							//�����ư�����ע�ᵽ���
		}
	private void centerWindow(JFrame frame) {		//����Ļ����λ����ʾ��ܵ��Զ��巽��
		int centeredWidth = ((int)d.getWidth() - frame.getWidth())/2;	//�������Ŀ��
		int centeredHeight = ((int)d.getHeight() - frame.getHeight())/3;	//�������ĸ߶�
		setLocation(centeredWidth, centeredHeight);				//������ʾλ��
	}
}
