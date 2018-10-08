package ch16;
//Example:  Use of JLabel, JCheckBox, JRadioButton, JTextArea and event handling
//to take a survey of opinions on various foods.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FoodSurveyPanel extends JPanel implements ActionListener {
private int pizzaLikeCount, humbuggerLikeCount, kfcLikeCount;
private int pizzaDislikeCount, humbuggerDislikeCount, kfcDislikeCount;
private JLabel selectLabel;
private JCheckBox pizzaBox, humbuggerBox, kfcBox;
private JRadioButton likeRadioButton,
						dislikeRadioButton;
private ButtonGroup buttonGroup;
private JButton addButton;
private JTextArea displayTextArea;
public FoodSurveyPanel() {
	  pizzaLikeCount = humbuggerLikeCount = kfcLikeCount = 0;
	  pizzaDislikeCount = humbuggerDislikeCount = kfcDislikeCount = 0;
   createGUIComponents();
}
private void createGUIComponents() {
	  selectLabel = new JLabel("ѡ����ϲ����ϲ����ʳƷ: ");
	  add(selectLabel);
   pizzaBox = new JCheckBox("Ƥ����");
   add(pizzaBox);
   humbuggerBox = new JCheckBox("������");
   add(humbuggerBox);
   kfcBox = new JCheckBox("�ϵ»�");
   add(kfcBox);
   likeRadioButton = new JRadioButton("ϲ��", true);
   dislikeRadioButton = new JRadioButton("��ϲ��");
   add(likeRadioButton);
   add(dislikeRadioButton);
   buttonGroup = new ButtonGroup();
   buttonGroup.add(likeRadioButton);
   buttonGroup.add(dislikeRadioButton);
   addButton = new JButton("�ύ");
   add(addButton);
   addButton.addActionListener(this);
   setupTextArea();
   displayTextArea.setVisible(false);
}
public void actionPerformed(ActionEvent e) {
	  Object source = e.getSource();				//�õ��¼�����Դ
		if (source == addButton) {
       if (pizzaBox.isSelected()) {
			if (likeRadioButton.isSelected())
         	pizzaLikeCount++;
         else
         	pizzaDislikeCount++;
		  }
       if (humbuggerBox.isSelected()) {
         if (likeRadioButton.isSelected())
			    humbuggerLikeCount++;
		    else
         	humbuggerDislikeCount++;
		  }
       if (kfcBox.isSelected()) {
			if (likeRadioButton.isSelected())
         	kfcLikeCount++;
         else
         	kfcDislikeCount++;
       }
	  	  updateTextArea();
	   }
}
private void setupTextArea() {
	  displayTextArea = new JTextArea();
	  displayTextArea.setBounds(16, 55, 315, 93);
	  displayTextArea.setEditable( false );
	  add(displayTextArea);
}
private void updateTextArea() {
	  String info = "ʳƷ����\tϲ��\t��ϲ��\n"
	               + "Ƥ����\t" + pizzaLikeCount + "\t" + pizzaDislikeCount + "\n"
	               + "������\t" + humbuggerLikeCount + "\t" + humbuggerDislikeCount + "\n"
	               + "�ϵ»�\t" + kfcLikeCount + "\t" + kfcDislikeCount;
	  displayTextArea.setText(info);
	  displayTextArea.setVisible(true);
}
}