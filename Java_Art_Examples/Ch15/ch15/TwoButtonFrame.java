package ch15;
//Demo: Two buttons in a frame
import javax.swing.*;
import java.awt.*;

class TwoButtonFrame extends JFrame {
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d = tk.getScreenSize();
	public TwoButtonFrame() {
		setTitle("Two Button Frame");
		setSize(300, 200);							//��300����200����
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		centerWindow(this);							//�����Զ���������λ����ʾ��ܵķ���
		JPanel panel = new TwoButtonPanel();	//�������ư����
		this.add(panel);							//�����ư�����ע�ᵽ���
		}
	private void centerWindow(JFrame frame) {		//����Ļ����λ����ʾ��ܵ��Զ��巽��
		int centeredWidth = ((int)d.getWidth() - frame.getWidth())/2;	//�������Ŀ��
		int centeredHeight = ((int)d.getHeight() - frame.getHeight())/2;	//�������ĸ߶�
		setLocation(centeredWidth, centeredHeight);				//������ʾλ��
	}
}