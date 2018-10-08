package ch16;
//Demo:  Use of BorderLayout and FlowLayout to display two buttons at the lower-right corner

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class BorderLayoutPanel2 extends JPanel {
	private JButton okButton, exitButton;
	public BorderLayoutPanel2() {
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		okButton = new JButton("Ok");
		exitButton = new JButton("Exit");
		buttonPanel.add(okButton);
		buttonPanel.add(exitButton);
		setLayout(new BorderLayout());
		add(buttonPanel, BorderLayout.SOUTH);
	}
}

class BorderLayoutFrame2 extends JFrame {
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d = tk.getScreenSize();
	public BorderLayoutFrame2() {
		setTitle("Two Buttons Frame");
		setSize(300, 200);							//��300����200����
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		centerWindow(this);							//�����Զ���������λ����ʾ��ܵķ���
		JPanel panel = new BorderLayoutPanel2();	//�������ư����
		this.add(panel);							//�����ư�����ע�ᵽ���
		}
	private void centerWindow(JFrame frame) {		//����Ļ����λ����ʾ��ܵ��Զ��巽��
		int centeredWidth = ((int)d.getWidth() - frame.getWidth())/2;	//�������Ŀ��
		int centeredHeight = ((int)d.getHeight() - frame.getHeight())/2;	//�������ĸ߶�
		setLocation(centeredWidth, centeredHeight);				//������ʾλ��
	}
}
public class BorderLayoutFrameTest2 {
	public static void main(String[] args) {
		JFrame frame = new BorderLayoutFrame2();
		frame.setVisible(true);
	}
}
