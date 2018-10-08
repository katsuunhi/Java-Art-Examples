package ch17;

//利用JFileChooser选择文件并且统计文件中的字数

import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

class FileChooserFrame extends JFrame {
  JMenuBar menuBar;
  JMenu fileMenu;
  JMenuItem openItem, saveItem, exitItem;
  JLabel statusLabel;
FileChooserFrame() {
 menuBar = new JMenuBar();
 fileMenu = new JMenu("文件");
 menuBar.add(fileMenu);
 openItem = new JMenuItem("打开");
 fileMenu.add(openItem);
 fileMenu.insertSeparator(1);
 exitItem = new JMenuItem("退出");
 fileMenu.add(exitItem);
 setJMenuBar(menuBar);
 statusLabel = new JLabel("将在这里显示选择的文件名和字数统计结果...");
 add(statusLabel);

 // Create a file chooser that opens up as an Open dialog
 openItem.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
     JFileChooser chooser = new JFileChooser();
     int wordsCount = 0;
     //chooser.setMultiSelectionEnabled(true);
     int option = chooser.showOpenDialog(null);
     if (option == JFileChooser.APPROVE_OPTION) {
       File file = chooser.getSelectedFile();
       wordsCount = countWordsInFile(file);
       statusLabel.setText("您所选的文件名: " + file.getName() + " 文件字数: " + wordsCount);
     }
     else {
       statusLabel.setText("您取消了选择.");
     }
   }
 });
 exitItem.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
	 System.exit(0);
	}
 });
 setDefaultCloseOperation(EXIT_ON_CLOSE);
 }
 int countWordsInFile(File file) {
         int numberOfWords = 0;
         String word = null;
         try {
             Scanner sc = new Scanner(file);
             while (sc.hasNext()) {
                 word = sc.next();
                 numberOfWords++;
             }
             sc.close();
         } catch (FileNotFoundException e) {
             JOptionPane.showMessageDialog(null, e);
         }
         return numberOfWords;
     }
}
public class FileChooserFrameApp {
	public static void main(String args[]) {
	 JFrame frame = new FileChooserFrame();
	 frame.setTitle("文件选择器以及字数统计程序");
	 frame.setSize(350, 200);
	 frame.setVisible(true);
	}
}
