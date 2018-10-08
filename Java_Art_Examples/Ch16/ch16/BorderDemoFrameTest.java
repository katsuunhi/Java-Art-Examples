package ch16;

//Demo:  Test of the borders

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

class BorderDemoFrame extends JFrame {
	private JPanel borderDemoPanel, buttonPanel;
	private JRadioButton likeRadioButton,
		   			     dislikeRadioButton,
		   				 dontKnowRadioButton;
	private ButtonGroup buttonGroup;
	private JButton addButton, exitButton;
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d = tk.getScreenSize();
	public BorderDemoFrame() {
		setLayout(new BorderLayout());					//创建框架的围界布局

		borderDemoPanel = new JPanel();
		borderDemoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		likeRadioButton = new JRadioButton("喜欢", true);
		dislikeRadioButton = new JRadioButton("不喜欢");
		dontKnowRadioButton = new JRadioButton("不知道");
		borderDemoPanel.add(likeRadioButton);
		borderDemoPanel.add(dislikeRadioButton);
		borderDemoPanel.add(dontKnowRadioButton);
		buttonGroup = new ButtonGroup();
		buttonGroup.add(likeRadioButton);
		buttonGroup.add(dislikeRadioButton);
		buttonGroup.add(dontKnowRadioButton);

		Border selectBorder = BorderFactory.createBevelBorder(BevelBorder.RAISED);
		selectBorder = BorderFactory.createTitledBorder(selectBorder, "请选择您的爱好:");
		borderDemoPanel.setBorder(selectBorder);

		add(borderDemoPanel, BorderLayout.NORTH);			//将按钮控制板按围界布局注册到框架

		buttonPanel = new JPanel();
		borderDemoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		addButton = new JButton("提交");
		buttonPanel.add(addButton);
		exitButton = new JButton("退出");
        buttonPanel.add(exitButton);
        add(buttonPanel, BorderLayout.SOUTH);

		setTitle("Demo of Border");
		setSize(220, 140);							//宽220，高140像素
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		}
}
public class BorderDemoFrameTest {
	public static void main(String[] args) {
		JFrame frame = new BorderDemoFrame();
		frame.setVisible(true);
	}
}

