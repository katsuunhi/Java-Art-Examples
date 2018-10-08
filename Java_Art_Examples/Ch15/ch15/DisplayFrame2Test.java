package ch15;

//Demo:  creating text fields

import javax.swing.*;
import java.awt.*;

class DisplayPanel2 extends JPanel {				//��д������ʾ�ı��ֶε�JPanel����
	private JTextField productField, quantityField, totalField;
	public DisplayPanel2() {						//������
		setLayout(new FlowLayout(FlowLayout.RIGHT));	//���Ҷ���
		productField = new JTextField(18);				//������ʾ18���ַ������ı��ֶ�
		add(productField);								//ע�ᵽ���ư�
		quantityField = new JTextField(15);				//������ʾ10���ַ������ı��ֶ�
		add(quantityField);								//ע�ᵽ���ư�
		totalField = new JTextField("$0.00", 10);				//������Ԥ����ʾ���ݵ��ı��ֶ�
		totalField.setEditable(false);						//����Ϊ���ݲ��ɱ༭�����������ʾ
		add(totalField);								//ע�ᵽ���ư�

	}
}
class DisplayFrame2 extends JFrame {
	public DisplayFrame2() {
		setTitle("Display Frame");
		setSize(220,160);							
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		centerWindow(this);							//�����Զ���������λ����ʾ��ܵķ���
		JPanel panel = new DisplayPanel2();			//�������ư����
		this.add(panel);							//�����ư�����ע�ᵽ���
		}
	private void centerWindow(JFrame frame) {		//����Ļ����λ����ʾ��ܵ��Զ��巽��
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		int centeredWidth = ((int)d.getWidth() - frame.getWidth())/2;	//�������Ŀ��
		int centeredHeight = ((int)d.getHeight() - frame.getHeight())/2;	//�������ĸ߶�
		setLocation(centeredWidth, centeredHeight);				//������ʾλ��
	}
}
public class DisplayFrame2Test {
	public static void main(String[] args) {
		JFrame frame = new DisplayFrame2();
		frame.setVisible(true);
	}
}