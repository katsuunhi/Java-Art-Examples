package ch16;

//Demo:  Test of nested BoxLayout with BorderLayout

import javax.swing.*;
import java.awt.*;

class BoxLayoutFrame2 extends JFrame {
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d = tk.getScreenSize();
	public BoxLayoutFrame2() {
		//setLayout(new FlowLayout());
		JPanel componentPanel1 = new JPanel();
		componentPanel1.setLayout(new BoxLayout(componentPanel1, BoxLayout.Y_AXIS));
		componentPanel1.add(new JLabel("Label"));
		componentPanel1.add(new JTextField("Text Field"));

		JPanel componentPanel2 = new JPanel();
		componentPanel2.setLayout(new BoxLayout(componentPanel2, BoxLayout.X_AXIS));
		componentPanel2.add(new JCheckBox("Check Box"));
		componentPanel2.add(new JButton("Button"));

		add(componentPanel1, BorderLayout.NORTH);
		add(componentPanel2, BorderLayout.SOUTH);

		//Container contentPane = getContentPane();
		//contentPane.add(componentPanel1, BorderLayout.NORTH);
		//contentPane.add(componentPanel2, BorderLayout.SOUTH);

		setTitle("Components in nested Layouts");
		setSize(220, 200);							//��220����200����
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		centerWindow(this);							//�����Զ���������λ����ʾ��ܵķ���
		}
	private void centerWindow(JFrame frame) {		//����Ļ����λ����ʾ��ܵ��Զ��巽��
		int centeredWidth = ((int)d.getWidth() - frame.getWidth())/2;	//�������Ŀ��
		int centeredHeight = ((int)d.getHeight() - frame.getHeight())/2;	//�������ĸ߶�
		setLocation(centeredWidth, centeredHeight);				//������ʾλ��
	}
}
public class BoxLayoutFrameTest2 {
	public static void main(String[] args) {
		JFrame frame = new BoxLayoutFrame2();
		frame.setVisible(true);
	}
}

