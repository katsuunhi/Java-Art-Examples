package ch16;

//Demo:  Test of 5 regions and changes in BorderLayout

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class BorderLayoutPanel3 extends JPanel implements ActionListener {
	private JButton[] buttons;
	private BorderLayout layout;
	private int post,
				count;
	public BorderLayoutPanel3() {
		buttons = new JButton[5];	//����5��Ԫ�صİ�ť����
		post = count = 0;						//����ֵ
		layout = new BorderLayout(5, 5);
		setLayout(layout);			//����Χ�粼�֣�ÿ��������ܱ߿�϶Ϊ5������

		for (int i = 0; i < 5; i++)
		  buttons[i] = new JButton("button" + post++);

		add(buttons[0], BorderLayout.NORTH);
		add(buttons[1], BorderLayout.SOUTH);
		add(buttons[2], BorderLayout.WEST);
		add(buttons[3], BorderLayout.EAST);
		add(buttons[4]);

		for (int i = 0; i < 5; i++)
			buttons[i].addActionListener(this);			//ע��ÿ����ť�¼�����
	}
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (count < 4) {
			for (int i = 0; i < 5; i++)
				if (source == buttons[i]) {
		  			buttons[i].setVisible(false);
		  			count++;
				}
		}
	    else {
		  for(JButton button : buttons)
		    button.setVisible(true);
		  count = 0;
		}
	}
}
class BorderLayoutFrame3 extends JFrame {
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d = tk.getScreenSize();
	public BorderLayoutFrame3() {
		setTitle("Five Buttons in BorderLayout");
		setSize(360, 200);							//��360����200����
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		centerWindow(this);							//�����Զ���������λ����ʾ��ܵķ���
		JPanel panel = new BorderLayoutPanel3();	//�������ư����
		this.add(panel);							//�����ư�����ע�ᵽ���
		}
	private void centerWindow(JFrame frame) {		//����Ļ����λ����ʾ��ܵ��Զ��巽��
		int centeredWidth = ((int)d.getWidth() - frame.getWidth())/2;	//�������Ŀ��
		int centeredHeight = ((int)d.getHeight() - frame.getHeight())/2;	//�������ĸ߶�
		setLocation(centeredWidth, centeredHeight);				//������ʾλ��
	}
}
public class BorderLayoutFrameTest3 {
	public static void main(String[] args) {
		JFrame frame = new BorderLayoutFrame3();
		frame.setVisible(true);
	}
}

