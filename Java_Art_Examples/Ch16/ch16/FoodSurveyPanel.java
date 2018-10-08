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
	  selectLabel = new JLabel("选择您喜欢或不喜欢的食品: ");
	  add(selectLabel);
   pizzaBox = new JCheckBox("皮萨饼");
   add(pizzaBox);
   humbuggerBox = new JCheckBox("汉堡包");
   add(humbuggerBox);
   kfcBox = new JCheckBox("肯德基");
   add(kfcBox);
   likeRadioButton = new JRadioButton("喜欢", true);
   dislikeRadioButton = new JRadioButton("不喜欢");
   add(likeRadioButton);
   add(dislikeRadioButton);
   buttonGroup = new ButtonGroup();
   buttonGroup.add(likeRadioButton);
   buttonGroup.add(dislikeRadioButton);
   addButton = new JButton("提交");
   add(addButton);
   addButton.addActionListener(this);
   setupTextArea();
   displayTextArea.setVisible(false);
}
public void actionPerformed(ActionEvent e) {
	  Object source = e.getSource();				//得到事件发生源
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
	  String info = "食品名称\t喜欢\t不喜欢\n"
	               + "皮萨饼\t" + pizzaLikeCount + "\t" + pizzaDislikeCount + "\n"
	               + "汉堡包\t" + humbuggerLikeCount + "\t" + humbuggerDislikeCount + "\n"
	               + "肯德基\t" + kfcLikeCount + "\t" + kfcDislikeCount;
	  displayTextArea.setText(info);
	  displayTextArea.setVisible(true);
}
}