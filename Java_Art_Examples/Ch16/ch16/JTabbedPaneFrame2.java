package ch16;
//Applications of using JTabbedPane with password and two programs

import java.awt.*;
import javax.swing.*;

class JTabbedPaneFrame2 extends JFrame {
	private JTabbedPane tabbedPane;
	private PasswordPanel passwordPanel;
	private ProductCalculatorPanel productCalculatorPanel;
	private BookInfoPanel2 bookInfoPanel;
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension d = tk.getScreenSize();
	public JTabbedPaneFrame2() {
		super("JTabbedPane Applications");
		tabbedPane = new JTabbedPane();
		passwordPanel = new PasswordPanel();
		productCalculatorPanel = new ProductCalculatorPanel();
		bookInfoPanel = new BookInfoPanel2();
		tabbedPane.addTab("Products", productCalculatorPanel);
		tabbedPane.addTab("Books", bookInfoPanel);
		add(tabbedPane);
		setSize(550, 200);
		centerWindow(this);
	}
	private void centerWindow(JFrame frame) {		//����Ļ����λ����ʾ��ܵ��Զ��巽��
			int centeredWidth = ((int)d.getWidth() - frame.getWidth())/2;	//�������Ŀ��
			int centeredHeight = ((int)d.getHeight() - frame.getHeight())/2;	//�������ĸ߶�
			setLocation(centeredWidth, centeredHeight);				//������ʾλ��
	}
}