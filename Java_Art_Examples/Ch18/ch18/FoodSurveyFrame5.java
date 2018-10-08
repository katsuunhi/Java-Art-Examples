package ch18;

//Application:  Use of JPopupMenu, JMenu, L&F, GridBagLayout, JLabel, JCheckBox, JRadioButton, JTextArea and event handling
//to take a survey of opinions on various foods.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class FoodSurveyFrame5 extends JFrame implements ActionListener {
private Border loweredBorder, raisedBorder;
private final String metalClassName = "javax.swing.plaf.metal.MetalLookAndFeel",
						motifClassName = "com.sun.java.swing.plaf.motif.MotifLookAndFeel",
						windowsClassName = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
private GridBagConstraints c;
private JPanel menuPanel, selectPanel, buttonPanel, lafPanel;
private int pizzaLikeCount, hamburgerLikeCount, kfcLikeCount;
private int pizzaDislikeCount, hamburgerDislikeCount, kfcDislikeCount;

private JMenuBar menuBar;
private JMenu selectMenu, likeMenu, dislikeMenu, displayMenu, aboutMenu;
private JMenuItem pizzaItem, hamburgerItem, kfcItem, metalItem, motifItem, winItem, contactItem, copyrightItem;
private JMenuItem dPizzaItem, dHamburgerItem, dKfcItem, exitItem;

private JCheckBox pizzaBox, hamburgerBox, kfcBox;
private JRadioButton likeRadioButton, dislikeRadioButton;
private JRadioButton metalRadioButton, motifRadioButton, windowRadioButton;
private ButtonGroup buttonGroup, buttonGroup2;
private JButton addButton,
				   exitButton;
private JTextArea displayTextArea;
private JPopupMenu popupMenu;
private JMenuItem loweredPopupItem, raisedPopupItem, exitPopupItem;

public FoodSurveyFrame5() {
	  pizzaLikeCount = hamburgerLikeCount = kfcLikeCount = 0;
	  pizzaDislikeCount = hamburgerDislikeCount = kfcDislikeCount = 0;
	  loweredBorder = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
	  raisedBorder = BorderFactory.createBevelBorder(BevelBorder.RAISED);

   createGUIComponents();
}
private void createGUIComponents() {
	  setLayout(new GridBagLayout());
	  c = new GridBagConstraints();

	  menuPanel = new JPanel();
	  menuPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
	  menuBar = new JMenuBar();
	  selectMenu = new JMenu("选择 (S)");
	  selectMenu.setMnemonic('S');
	  menuBar.add(selectMenu);
	  likeMenu = new JMenu("喜欢的食品 (L)");
	  likeMenu.setMnemonic('L');
	  selectMenu.add(likeMenu);
	  selectMenu.insertSeparator(1);

	  pizzaItem = new JMenuItem("喜欢皮萨饼");
	  pizzaItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.ALT_MASK));
	  likeMenu.add(pizzaItem);
	  pizzaItem.addActionListener(this);
	  hamburgerItem = new JMenuItem("喜欢汉堡");
	  hamburgerItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.ALT_MASK));
	  likeMenu.add(hamburgerItem);
	  hamburgerItem.addActionListener(this);
	  kfcItem = new JMenuItem("喜欢肯德鸡");
	  kfcItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, KeyEvent.ALT_MASK));
	  likeMenu.add(kfcItem);
	  kfcItem.addActionListener(this);

	  dislikeMenu = new JMenu("不喜欢的食品 (D)");
	  dislikeMenu.setMnemonic('D');
	  selectMenu.add(dislikeMenu);
	  dPizzaItem = new JMenuItem("不喜欢皮萨");
	  dPizzaItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_MASK));
	  dPizzaItem.addActionListener(this);
	  dislikeMenu.add(dPizzaItem);
	  dHamburgerItem = new JMenuItem("不喜欢汉堡");
	  dHamburgerItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.CTRL_MASK));
	  dHamburgerItem.addActionListener(this);
	  dislikeMenu.add(dHamburgerItem);
	  dKfcItem = new JMenuItem("不喜欢肯德鸡");
	  dKfcItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, KeyEvent.CTRL_MASK));
	  dislikeMenu.add(dKfcItem);
	  dKfcItem.addActionListener(this);

	  exitItem = new JMenuItem("退出 (X)");
	  exitItem.setMnemonic('X');
	  selectMenu.add(exitItem);
	  selectMenu.insertSeparator(3);
	  exitItem.addActionListener(this);


	  displayMenu = new JMenu("显示 (D)");
	  menuBar.add(displayMenu);
	  menuPanel.add(menuBar);
	  metalItem = new JMenuItem("金属显示风格");
	  metalItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, KeyEvent.CTRL_MASK));
	  displayMenu.add(metalItem);
	  metalItem.addActionListener(this);
	  motifItem = new JMenuItem("Linux显示风格");
	  motifItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, KeyEvent.CTRL_MASK));
	  displayMenu.add(motifItem);
	  motifItem.addActionListener(this);
	  winItem = new JMenuItem("窗口显示风格");
	  winItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_MASK));
	  displayMenu.add(winItem);
	  winItem.addActionListener(this);

	  aboutMenu = new JMenu("联系作者 (C)");
	  aboutMenu.setMnemonic('C');
	  menuBar.add(aboutMenu);
	  aboutMenu.addActionListener(this);
	  contactItem = new JMenuItem("联系地址");
	  contactItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_MASK));
	  aboutMenu.add(contactItem);
	  contactItem.addActionListener(this);
	  copyrightItem = new JMenuItem("拷贝权");
	  copyrightItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_MASK));
	  aboutMenu.add(copyrightItem);
	  copyrightItem.addActionListener(this);

	  c = setupConstraints(0, 0, 6, 1, GridBagConstraints.WEST);
	  add(menuPanel);

	  selectPanel = new JPanel();
	  selectPanel.setBorder(BorderFactory.createTitledBorder(loweredBorder, "选择您喜欢或不喜欢的食品: "));
	  selectPanel.setLayout(new GridLayout(2, 3));
	  pizzaBox = new JCheckBox("皮萨饼");
	  selectPanel.add(pizzaBox);
	  hamburgerBox = new JCheckBox("汉堡包");
	  selectPanel.add(hamburgerBox);
	  kfcBox = new JCheckBox("肯德鸡");
	  selectPanel.add(kfcBox);
	  likeRadioButton = new JRadioButton("喜欢", true);
	  dislikeRadioButton = new JRadioButton("不喜欢");
	  selectPanel.add(likeRadioButton);
	  selectPanel.add(dislikeRadioButton);
	  buttonGroup = new ButtonGroup();
	  buttonGroup.add(likeRadioButton);
	  buttonGroup.add(dislikeRadioButton);
	  c = setupConstraints(0, 1, 3, 2, GridBagConstraints.WEST);
   add(selectPanel, c);

	  buttonPanel = new JPanel();
	  buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
   addButton = new JButton("提交");
   buttonPanel.add(addButton);
   addButton.addActionListener(this);
   exitButton = new JButton("退出");
   buttonPanel.add(exitButton);
   exitButton.addActionListener(this);

   c = setupConstraints(0, 5, 2, 1, GridBagConstraints.WEST);
   add(buttonPanel, c);

	  lafPanel = new JPanel();
	  lafPanel.setBorder(BorderFactory.createTitledBorder(raisedBorder, "选择您喜欢的形式风格: "));
	  lafPanel.setLayout(new GridLayout(1, 3));
	  metalRadioButton = new JRadioButton("金属", true);
	  motifRadioButton = new JRadioButton("Linux");
	  windowRadioButton = new JRadioButton("窗口");
	  lafPanel.add(metalRadioButton);
	  lafPanel.add(motifRadioButton);
	  lafPanel.add(windowRadioButton);
	  metalRadioButton.addActionListener(this);
	  motifRadioButton.addActionListener(this);
	  windowRadioButton.addActionListener(this);
	  buttonGroup2 = new ButtonGroup();
	  buttonGroup2.add(metalRadioButton);
	  buttonGroup2.add(motifRadioButton);
	  buttonGroup2.add(windowRadioButton);

	  c = setupConstraints(3, 1, 3, 1, GridBagConstraints.WEST);
	  add(lafPanel, c);

   setupTextArea();
   c = setupConstraints(3, 2, 3, 4, GridBagConstraints.WEST);
	  add(displayTextArea, c);
   displayTextArea.setVisible(false);

		popupMenu = new JPopupMenu();
     loweredPopupItem = new JMenuItem("Lowered Popup");
     popupMenu.add(loweredPopupItem);
     loweredPopupItem.addActionListener(this);
     raisedPopupItem = new JMenuItem("Raised Popup");
     popupMenu.add(raisedPopupItem);
     raisedPopupItem.addActionListener(this);
     popupMenu.addSeparator();
     exitPopupItem = new JMenuItem("Exit");
		popupMenu.add(exitPopupItem);
     exitPopupItem.addActionListener(this);

     addMouseListener(new MouseAdapter(){				//创建并注册匿名内部类鼠标事件处理
         public void mouseReleased(MouseEvent e){
             if (e.isPopupTrigger())
                popupMenu.show(e.getComponent(), e.getX(), e.getY());
          }
 });
}
public void actionPerformed(ActionEvent e) {
	  Object source = e.getSource();				//得到事件发生源
	    if(source == exitButton || source == exitItem || source == exitPopupItem)
	     System.exit(0);
		else if (source == addButton) {
       if (pizzaBox.isSelected()) {
			if (likeRadioButton.isSelected())
         	pizzaLikeCount++;
         else
         	pizzaDislikeCount++;
		  }
       if (hamburgerBox.isSelected()) {
         if (likeRadioButton.isSelected())
			    hamburgerLikeCount++;
		    else
         	hamburgerDislikeCount++;
		  }
       if (kfcBox.isSelected()) {
			if (likeRadioButton.isSelected())
         	kfcLikeCount++;
         else
         	kfcDislikeCount++;
       }
	  	  updateTextArea();
	   }
	   else if (source == loweredPopupItem) {
		  popupMenu.setBorder(new BevelBorder(BevelBorder.LOWERED));
	   }
	   else if (source == raisedPopupItem) {
	   		  popupMenu.setBorder(new BevelBorder(BevelBorder.RAISED));
	   }
	   else if (source == contactItem)
	   	  JOptionPane.showMessageDialog(null, "ygao@ohlone.edu");
	   else if (source == copyrightItem)
	     JOptionPane.showMessageDialog(null, "All programs are copyrighted.");
	   else { if (source == pizzaItem)
		     	pizzaLikeCount++;
	   		  else if (source == hamburgerItem)
		   		hamburgerLikeCount++;
	   		  else if (source == kfcItem)
	       		kfcLikeCount++;
	   		  else if (source == dPizzaItem)
	      		pizzaDislikeCount++;
	   		  else if (source == dHamburgerItem)
	       		hamburgerDislikeCount++;
	   		  else if (source == dKfcItem)
	       		kfcDislikeCount++;
	   		  updateTextArea();
	   }
	   try {
			   if (source == metalRadioButton || source == metalItem) {
				   UIManager.setLookAndFeel(metalClassName);
			   }
			   if (source == motifRadioButton || source == motifItem) {
				   UIManager.setLookAndFeel(motifClassName);
			   }
			   if (source == windowRadioButton || source == winItem) {
				   UIManager.setLookAndFeel(windowsClassName);
			   }
			SwingUtilities.updateComponentTreeUI(this);
	   	}
	   	catch (Exception ex) {
			System.out.println(ex);
		}
}
private void setupTextArea() {
	  displayTextArea = new JTextArea(4, 20);
	  displayTextArea.setEditable( false );
}
private void updateTextArea() {
	  String info = "食品名称\t喜欢\t不喜欢\n"
	               + " 皮萨饼 \t" + pizzaLikeCount + "\t" + pizzaDislikeCount + "\n"
	               + " 汉堡包 \t" + hamburgerLikeCount + "\t" + hamburgerDislikeCount + "\n"
	               + " 肯德基 \t" + kfcLikeCount + "\t" + kfcDislikeCount;
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
class PopupHandler extends MouseAdapter {
	        public void mouseReleased(MouseEvent e) {
	            if (e.isPopupTrigger())
	                popupMenu.show(e.getComponent(), e.getX(), e.getY());
	        }
 }

}