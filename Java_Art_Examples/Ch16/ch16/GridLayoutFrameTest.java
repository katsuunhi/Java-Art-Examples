package ch16;

//Demo:  Test of components in 3 rows and 2 columns in GridLayout

import javax.swing.*;
import java.awt.*;

class GridLayoutPanel extends JPanel {
	public GridLayoutPanel() {
		setLayout(new GridLayout(3, 2));			//����
		add(new JLabel("Label"));
		add(new JTextField("Text Field"));
		add(new JButton("Button"));
		add(new JCheckBox("Check Box"));
		add(new JTextArea("Text Area"));
	}
}
class GridLayoutFrame extends JFrame {
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d = tk.getScreenSize();
	public GridLayoutFrame() {
		setTitle("Components in Y-Axis in BoxLayout");
		setSize(300, 200);							//��400����100����
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		centerWindow(this);							//�����Զ���������λ����ʾ��ܵķ���
		JPanel panel = new GridLayoutPanel();	//�������ư����
		this.add(panel);							//�����ư�����ע�ᵽ���
		}
	private void centerWindow(JFrame frame) {		//����Ļ����λ����ʾ��ܵ��Զ��巽��
		int centeredWidth = ((int)d.getWidth() - frame.getWidth())/2;	//�������Ŀ��
		int centeredHeight = ((int)d.getHeight() - frame.getHeight())/2;	//�������ĸ߶�
		setLocation(centeredWidth, centeredHeight);				//������ʾλ��
	}
}
public class GridLayoutFrameTest {
	public static void main(String[] args) {
		JFrame frame = new GridLayoutFrame();
		frame.setVisible(true);
	}
}