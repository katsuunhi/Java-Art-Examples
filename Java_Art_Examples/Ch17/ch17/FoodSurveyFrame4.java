package ch17;

//to take a survey of opinions on various foods.
import javax.swing.*;
import java.awt.*;

class FoodSurveyFrame4 extends JFrame {
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d = tk.getScreenSize();
	public FoodSurveyFrame4() {
		setTitle("�������ʳƷ����");
		setSize(530, 250);							//��400����220����
		//setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		centerWindow(this);						//�����Զ���������λ����ʾ��ܵķ���
		JPanel panel = new FoodSurveyPanel4();		//�������ư����
		this.add(panel);							//�����ư�����ע�ᵽ���
		}
	private void centerWindow(JFrame frame) {		//����Ļ����λ����ʾ��ܵ��Զ��巽��
		int centeredWidth = ((int)d.getWidth() - frame.getWidth())/2;	//�������Ŀ��
		int centeredHeight = ((int)d.getHeight() - frame.getHeight())/3;	//�������ĸ߶�
		setLocation(centeredWidth, centeredHeight);				//������ʾλ��
	}
}
