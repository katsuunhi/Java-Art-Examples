package ch15;
//Example:  Use of JTextArea, JScrollPane and event handling
//Copy the content of the text area to output window of the JOptionPane

import javax.swing.*;
import java.awt.event.*;

class TextAreaPanel extends JPanel implements ActionListener{
	final int vScroll = JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
	          hScroll = JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS;
	private JTextArea textArea;
	private JScrollPane scroll;
	private JButton copyButton;
	public TextAreaPanel() {						//������
		textArea = new JTextArea("another example of text area. ", 2, 20);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		add(textArea);
		scroll = new JScrollPane(textArea, vScroll, hScroll);
		add(scroll);
		copyButton = new JButton("Copy >>");
		add(copyButton);
		copyButton.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {	//�����¼�����ӿڷ���
		Object source = e.getSource();				//�õ��¼�����Դ
			if (source == copyButton) {
				textArea.insert("Welcome to Text Area and Scroll Application. This is ", 0);
				textArea.append(" �����ı����ڵ�����һ�����ӡ�");
				JOptionPane.showMessageDialog(null, textArea.getText());
			}
	        else
	          System.exit(0);
	}
}