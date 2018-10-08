package ch15;

//Example:  Use of JLabel, JTextField,JButton and event handling to calculate product total

import javax.swing.*;
import java.awt.*;

class ProductCalculatorFrame extends JFrame {
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d = tk.getScreenSize();
	public ProductCalculatorFrame() {
		setTitle("Product Calculator");
		setSize(280, 200);							//��300����200����
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		centerWindow(this);						//�����Զ���������λ����ʾ��ܵķ���
		JPanel panel = new ProductCalculatorPanel();		//�������ư����
		this.add(panel);							//�����ư�����ע�ᵽ���
		}
	private void centerWindow(JFrame frame) {		//����Ļ����λ����ʾ��ܵ��Զ��巽��
		int centeredWidth = ((int)d.getWidth() - frame.getWidth())/2;	//�������Ŀ��
		int centeredHeight = ((int)d.getHeight() - frame.getHeight())/2;	//�������ĸ߶�
		setLocation(centeredWidth, centeredHeight);				//������ʾλ��
	}
}