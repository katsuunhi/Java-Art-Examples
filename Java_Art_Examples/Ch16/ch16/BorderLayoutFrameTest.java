package ch16;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

class BorderLayoutFrame extends JFrame {
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d = tk.getScreenSize();
	public BorderLayoutFrame() {
		setTitle("Five Buttons in BorderLayout");
		setSize(350, 200);							//��350����200����
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		centerWindow(this);							//�����Զ���������λ����ʾ��ܵķ���
		JPanel panel = new BorderLayoutPanel();	//�������ư����
		this.add(panel);							//�����ư�����ע�ᵽ���
		}
	private void centerWindow(JFrame frame) {		//����Ļ����λ����ʾ��ܵ��Զ��巽��
		int centeredWidth = ((int)d.getWidth() - frame.getWidth())/2;	//�������Ŀ��
		int centeredHeight = ((int)d.getHeight() - frame.getHeight())/2;	//�������ĸ߶�
		setLocation(centeredWidth, centeredHeight);				//������ʾλ��
	}
}
class BorderLayoutFrameTest {
	public static void main(String[] args) {
		JFrame frame = new BorderLayoutFrame();
		frame.setVisible(true);
	}
}