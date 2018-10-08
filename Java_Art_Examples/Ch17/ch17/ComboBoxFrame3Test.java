package ch17;
//Demo:  Test of JComboBox with ItemListener event handling

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SelectPanel2 extends JPanel implements ItemListener {		//��д�������������б��JPanel��
		JComboBox myComboBox;					//����һ�������б�
	public SelectPanel2() {						//������
		myComboBox = new JComboBox();			//����һ���������б�
		myComboBox.addItem("Pizza");			//�������б�������3��ѡ��
		myComboBox.addItem("Hamburger");
		myComboBox.addItem("KFC");
		myComboBox.insertItemAt("French Fries", 2);			//��KFCǰ�������ѡ����
		add(myComboBox);
		myComboBox.addItemListener(this);
	}
	public void itemStateChanged(ItemEvent e) {
		Object source = e.getSource();
		if (source == myComboBox) {				//��������б������¼�

			if (e.getItem() == "Pizza" && e.getStateChange() == ItemEvent.SELECTED)				//���ѡ����Pizza
				JOptionPane.showMessageDialog(null, "You have selected Pizza.");
			else if (e.getItem() == "Hamburger" && e.getStateChange() == ItemEvent.SELECTED)	//���ѡ����Hamburger
				JOptionPane.showMessageDialog(null, "You have selected Hamburger.");
			else if (e.getItem() == "French Fries" && e.getStateChange() == ItemEvent.SELECTED)	//���ѡ����French Fries
				JOptionPane.showMessageDialog(null, "You have selected French Fries.");
			else if (e.getItem() == "KFC" && e.getStateChange() == ItemEvent.SELECTED)														//���ѡ����KFC
				JOptionPane.showMessageDialog(null, "You have selected KFC.");
		}
	}
}
class ComboBoxFrame3 extends JFrame {
	public ComboBoxFrame3() {
		JPanel selectPanel = new SelectPanel2();						//�������ư�
		this.add(selectPanel);							//�����ư�����ע�ᵽ���
		setTitle("JComboBox Test");
		setSize(250,80);							//��250����80����
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		centerWindow(this);							//�����Զ���������λ����ʾ��ܵķ���
	}
	private void centerWindow(JFrame frame) {		//����Ļ����λ����ʾ��ܵ��Զ��巽��
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		int centeredWidth = ((int)d.getWidth() - frame.getWidth())/2;	//�������Ŀ��
		int centeredHeight = ((int)d.getHeight() - frame.getHeight())/2;	//�������ĸ߶�
		setLocation(centeredWidth, centeredHeight);				//������ʾλ��
	}
}
public class ComboBoxFrame3Test {
	public static void main(String[] args) {
		JFrame frame = new ComboBoxFrame3();
		frame.setVisible(true);
	}
}

