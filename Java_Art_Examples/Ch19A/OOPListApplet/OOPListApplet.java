// Applet:  Use of Border, GridBagLayout, JList, JLabel, JTextField, JTextArea and event handling
// to show common use OOP terms.

import javax.swing.*;

public class OOPListApplet extends JApplet {
	public void init() {
		JPanel panel = new OOPListPanel2();		//创建控制板对象
		this.add(panel);							//将控制板加入或注册到框架
		}
}