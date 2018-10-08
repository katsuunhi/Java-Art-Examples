package ch16;

//Demo:  Test of the TextArea border

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

class BorderFrame extends JFrame {
	private JTextArea textArea;
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d = tk.getScreenSize();
	public BorderFrame() {
 		textArea = new JTextArea("This is a demo...", 5, 20);

		Border selectBorder = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
		selectBorder = BorderFactory.createTitledBorder(selectBorder, "enter your story");
		textArea.setBorder(selectBorder);

		add(textArea);

		setTitle("TextArea Border");
		setSize(260, 140);							//宽260，高140像素
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		}
	private void centerWindow(JFrame frame) {		//按屏幕中心位置显示框架的自定义方法
		int centeredWidth = ((int)d.getWidth() - frame.getWidth())/2;	//计算中心宽度
		int centeredHeight = ((int)d.getHeight() - frame.getHeight())/2;	//计算中心高度
		setLocation(centeredWidth, centeredHeight);				//设置显示位置
	}
}
public class BorderFrameTest {
	public static void main(String[] args) {
		JFrame frame = new BorderFrame();
		frame.setVisible(true);
	}
}

