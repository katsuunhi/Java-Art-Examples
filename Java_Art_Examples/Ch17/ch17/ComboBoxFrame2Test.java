package ch17;

//Demo:  Test of JComboBox

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SelectPanel extends JPanel implements ActionListener {		//��д�������������б��JPanel��
		JComboBox myComboBox;					//����һ�������б�
	public SelectPanel() {						//������
		myComboBox = new JComboBox();			//����һ���������б�
		myComboBox.addItem("Pizza");			//�������б�������3��ѡ��
		myComboBox.addItem("Hamburger");
		myComboBox.addItem("KFC");
		myComboBox.insertItemAt("French Fries", 2);			//��KFCǰ�������ѡ����
		add(myComboBox);
		myComboBox.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == myComboBox) {				//��������б������¼�
			if (myComboBox.getSelectedItem() == "Pizza")				//���ѡ����Pizza
				JOptionPane.showMessageDialog(null, "You have selected Pizza.");
			else if (myComboBox.getSelectedItem() == "Hamburger")		//���ѡ����Hamburger
				JOptionPane.showMessageDialog(null, "You have selected Hamburger.");
			else if (myComboBox.getSelectedItem() == "French Fries")	//���ѡ����French Fries
				JOptionPane.showMessageDialog(null, "You have selected French Fries.");
			else													//���ѡ����KFC
				JOptionPane.showMessageDialog(null, "You have selected KFC.");
		}
	}
}
class ComboBoxFrame2 extends JFrame {
	public ComboBoxFrame2() {
		JPanel selectPanel = new SelectPanel();						//�������ư�
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
public class ComboBoxFrame2Test {
	public static void main(String[] args) {
		JFrame frame = new ComboBoxFrame2();
		frame.setVisible(true);
	}
}

