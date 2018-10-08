package ch16;
//Demo:  Use of FlowLayout

import java.awt.*;
import javax.swing.*;

class TwoButtonsPanel extends JPanel {
   public TwoButtonsPanel() {
   	FlowLayout flowLayout = new FlowLayout(FlowLayout.RIGHT);//����������Ҷ������̲��ֹ���
   	setLayout(flowLayout);									 //��������ֹ���ע�ᵽ���ư�
   	add(new JButton("Button One"));							 //����������ʾ��ť
   	add(new JButton("Button Two"));
   }
}
class TwoButtonsFrame extends JFrame {
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d = tk.getScreenSize();
	public TwoButtonsFrame() {
		setTitle("Use of FlowLayout");
		setSize(300, 120);							//��400����220����
		//setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		centerWindow(this);						//�����Զ���������λ����ʾ��ܵķ���
		JPanel panel = new TwoButtonsPanel();		//�������ư����
		this.add(panel);							//�����ư�����ע�ᵽ���
		}
	private void centerWindow(JFrame frame) {		//����Ļ����λ����ʾ��ܵ��Զ��巽��
		int centeredWidth = ((int)d.getWidth() - frame.getWidth())/2;	//�������Ŀ��
		int centeredHeight = ((int)d.getHeight() - frame.getHeight())/3;	//�������ĸ߶�
		setLocation(centeredWidth, centeredHeight);				//������ʾλ��
	}
}
public class TwoButtonsFrameTest {
	public static void main(String[] args) {
		JFrame frame = new TwoButtonsFrame();
		frame.setVisible(true);
	}
}
