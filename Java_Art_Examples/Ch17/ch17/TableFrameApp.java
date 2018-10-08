package ch17;

//Use of JTable with change of the size.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class TableFrame extends JFrame {
	String rowData[][] = {
			{ "1", "one", "一", "un", "I" },
	        { "2", "two", "二", "deux", "II" },
	        { "3", "three", "三", "trois", "III" },
	        { "4", "four", "四", "quatre", "IV" },
	        { "5", "five", "五", "cinq", "V" },
	        { "6", "six", "六", "treiza", "VI" },
	        { "7", "seven", "七", "sept", "VII" },
	        { "8", "eight", "八", "huit", "VIII" },
	        { "9", "nine", "九", "neur", "IX" },
        	{ "10", "ten", "十", "dix", "X" } };
	 String columnNames[] = { "数字", "英", "中", "法", "罗马" };
	 String modes[] = { "改变所有列的大小", "复原"};
	 int modeKey[] =  { JTable.AUTO_RESIZE_ALL_COLUMNS, JTable.AUTO_RESIZE_OFF};
	 JTable table;
	 JScrollPane scrollPane;
	 JComboBox resizeModeComboBox;
	 ItemListener itemListener;
	 int defaultMode = 1;

	 TableFrame() {
		 table = new JTable(rowData, columnNames);
		 scrollPane = new JScrollPane(table);
		 resizeModeComboBox = new JComboBox(modes);
		 table.setAutoResizeMode(modeKey[defaultMode]);
		 resizeModeComboBox.setSelectedIndex(defaultMode);

		 add(resizeModeComboBox, BorderLayout.NORTH);
		 add(scrollPane, BorderLayout.CENTER);

		 itemListener = new ItemListener() {
		   public void itemStateChanged(ItemEvent e) {
			 JComboBox source = (JComboBox) e.getSource();
			 int index = source.getSelectedIndex();
			 table.setAutoResizeMode(modeKey[index]);
		   }
		 };
    	 resizeModeComboBox.addItemListener(itemListener);
    	 setDefaultCloseOperation(EXIT_ON_CLOSE);
	 }
}

public class TableFrameApp {
  public static void main(String args[]) {
  		JFrame frame = new TableFrame();
  		frame.setTitle("表格应用演示程序");
    	frame.setSize(600, 300);
    	frame.setVisible(true);
  }
}
