package ch16;

//Demo:  Test of components in X-Axis in BoxLayout

import javax.swing.*;
import java.awt.*;

class BoxLayoutPanel extends JPanel {
	BoxLayout boxLayout;
	public BoxLayoutPanel() {
		boxLayout = new BoxLayout(this, BoxLayout.X_AXIS);
		setLayout(boxLayout);					 
		add(new JLabel("Label"));
		add(new JTextField("Text Field"));
		add(new JButton("Button"));
		add(new JCheckBox("Check Box"));
	}
}
class BoxLayoutFrame extends JFrame {
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d = tk.getScreenSize();
	public BoxLayoutFrame() {
		setTitle("Components in Y-Axis in BoxLayout");
		setSize(400, 100);							//��400����100����
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		centerWindow(this);							//�����Զ���������λ����ʾ��ܵķ���
		JPanel panel = new BoxLayoutPanel();	//�������ư����
		this.add(panel);							//�����ư�����ע�ᵽ���
		}
	private void centerWindow(JFrame frame) {		//����Ļ����λ����ʾ��ܵ��Զ��巽��
		int centeredWidth = ((int)d.getWidth() - frame.getWidth())/2;	//�������Ŀ��
		int centeredHeight = ((int)d.getHeight() - frame.getHeight())/2;	//�������ĸ߶�
		setLocation(centeredWidth, centeredHeight);				//������ʾλ��
	}
}
public class BoxLayoutFrameTest {
	public static void main(String[] args) {
		JFrame frame = new BoxLayoutFrame();
		frame.setVisible(true);
	}
}