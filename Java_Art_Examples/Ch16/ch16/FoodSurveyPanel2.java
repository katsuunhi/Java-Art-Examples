package ch16;

//Application:  Use of GridBagLayout, JLabel, JCheckBox, JRadioButton, JTextArea and event handling
//to take a survey of opinions on various foods.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class FoodSurveyPanel2 extends JPanel implements ActionListener {
private Border loweredBorder;
private GridBagConstraints c;
private int pizzaLikeCount, humbuggerLikeCount, kfcLikeCount;
private int pizzaDislikeCount, humbuggerDislikeCount, kfcDislikeCount;
private JLabel selectLabel;
private JCheckBox pizzaBox, humbuggerBox, kfcBox;
private JRadioButton likeRadioButton,
						dislikeRadioButton;
private ButtonGroup buttonGroup;
private JButton addButton,
				   exitButton;
private JTextArea displayTextArea;
public FoodSurveyPanel2() {
	  pizzaLikeCount = humbuggerLikeCount = kfcLikeCount = 0;
	  pizzaDislikeCount = humbuggerDislikeCount = kfcDislikeCount = 0;
	  loweredBorder = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
   createGUIComponents();
}
private void createGUIComponents() {
	  setLayout(new GridBagLayout());
	  c = new GridBagConstraints();

	  JPanel selectPanel = new JPanel();
	  selectPanel.setBorder(BorderFactory.createTitledBorder(loweredBorder, "选择您喜欢或不喜欢的食品: "));
	  selectPanel.setLayout(new GridLayout(2, 3));
   pizzaBox = new JCheckBox("皮萨饼");
   selectPanel.add(pizzaBox);

   humbuggerBox = new JCheckBox("汉堡包");
   selectPanel.add(humbuggerBox);

   kfcBox = new JCheckBox("肯德鸡");
   selectPanel.add(kfcBox);

   likeRadioButton = new JRadioButton("喜欢", true);
   dislikeRadioButton = new JRadioButton("不喜欢");
   selectPanel.add(likeRadioButton);
   selectPanel.add(dislikeRadioButton);
   buttonGroup = new ButtonGroup();
   buttonGroup.add(likeRadioButton);
   buttonGroup.add(dislikeRadioButton);
   c = setupConstraints(0, 0, 3, 2, GridBagConstraints.WEST);
   add(selectPanel, c);



	  JPanel buttonPanel = new JPanel();
	  buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
   addButton = new JButton("提交");
   buttonPanel.add(addButton);
   addButton.addActionListener(this);
   exitButton = new JButton("退出");
   buttonPanel.add(exitButton);
   exitButton.addActionListener(this);

   c = setupConstraints(0, 3, 2, 1, GridBagConstraints.WEST);
   add(buttonPanel, c);

   setupTextArea();
   c = setupConstraints(3, 0, 3, 5, GridBagConstraints.WEST);
	  add(displayTextArea, c);
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
	   else if(source == exitButton)
	     System.exit(0);
}
private void setupTextArea() {
	  displayTextArea = new JTextArea(5, 20);
	  displayTextArea.setEditable( false );
}
private void updateTextArea() {
	  String info = "食品名称\t喜欢\t不喜欢\n"
	               + "皮萨饼\t" + pizzaLikeCount + "\t" + pizzaDislikeCount + "\n"
	               + "汉堡包\t" + humbuggerLikeCount + "\t" + humbuggerDislikeCount + "\n"
	               + "肯德基\t" + kfcLikeCount + "\t" + kfcDislikeCount;
	  displayTextArea.setText(info);
	  displayTextArea.setVisible(true);
}
private GridBagConstraints setupConstraints(int gridx, int gridy, int gridwidth, int gridheight, int anchor) {
	  GridBagConstraints c = new GridBagConstraints();
	  c.gridx = gridx;
	  c.gridy = gridy;
	  c.insets = new Insets(5, 5, 5, 5);
	  c.ipadx = c.ipady = 0;
	  c.gridwidth = gridwidth;
	  c.gridheight = gridheight;
	  c.anchor = anchor;
	  return c;
}
}