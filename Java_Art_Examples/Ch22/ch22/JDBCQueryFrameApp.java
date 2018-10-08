package ch22;

//���ݿ�Ӧ��ʵ��

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class JDBCQueryFrame extends JFrame {
	 JPanel panel;
	 boolean update = true;
	 String query = "";
	 String createQuery = "CREATE TABLE ���ݱ��� (�ֶ��б�)";
	 String insertQuery = "INSERT INTO ���ݱ��� VALUES (�ֶ�ֵ�б�)";
	 String selectQuery = "SELECT �ֶ��б� FROM ���ݱ��� WHERE ѡ������";
	 String updateQuery = "UPDATE ���ݱ��� SET �ֶα��ʽ WHERE ѡ������";
	 String deleteQuery = "DELETE FROM ���ݱ��� WHERE ɾ������";
	 String dropQuery = "DROP TABLE ���ݱ���";

	 Connection connection;
	 Statement stmt = null ;
	 ResultSet rs = null;
	 JDBCQueryFrame() {
		 makeJDBCConnection();
		 panel = new ButtonPanel();
		 add(panel, BorderLayout.SOUTH);
    	 setDefaultCloseOperation(EXIT_ON_CLOSE);
	 }
	 private void makeJDBCConnection() {
		 try{
			 Class.forName("com.mysql.jdbc.Driver");
			 String dbURL = "jdbc:mysql://localhost:3306/ProductDB";
			 String username = "root";
			 String password = "";
			 connection = DriverManager.getConnection(dbURL, username, password);
			 stmt = connection.createStatement();
		  }
		 catch(ClassNotFoundException e){
			 JOptionPane.showMessageDialog(null, "�޷��ҵ����ݿ���������");
		 }
		 catch(SQLException e){
			 JOptionPane.showMessageDialog(null,"���ݿ����ӳ���: " + e.getMessage());
		 }

	 }
	class ButtonPanel extends JPanel implements ActionListener {
		JButton createButton, insertButton, selectButton, updateButton, deleteButton, dropButton, submitButton, exitButton;
		JTextArea area;
		FlowLayout flowLayout;
		ButtonPanel() {
			flowLayout = new FlowLayout(FlowLayout.CENTER);
			setLayout(flowLayout);
			setupGUI();
	  }
	  public void actionPerformed(ActionEvent e) {
		  Object source = e.getSource();
		  if (source == createButton) {
			  setUpdateComponents();
			  submitButton.setVisible(true);
			  update = true;
			  area.setText(createQuery);

		  }
		  else if(source == insertButton) {
			  setUpdateComponents();
			  submitButton.setVisible(true);
			  update = true;
			  area.setText(insertQuery);
		  }
		  else if(source == selectButton) {
			  setUpdateComponents();
			  submitButton.setVisible(true);
			  update = false;
			  area.setText(selectQuery);
		  }
		  else if(source == updateButton) {
			  setUpdateComponents();
			  update = true;
			  area.setText(updateQuery);
		  }

		  else if(source == deleteButton) {
			  setUpdateComponents();
			  update = true;
			  area.setText(deleteQuery);
		  }
		   else if(source == dropButton) {
			  setUpdateComponents();
			  update = true;
			  area.setText(dropQuery);
		  }
		  else if( source == submitButton) {
			  query = area.getText();
			  executeQuery();
			  resetComponents();
			  area.setText("");
			  if (update)
			  	JOptionPane.showMessageDialog(null, "����SQLָ���ѳɹ�ִ�У�\n" + query);
			  else {
				  area.setText("");
				  displayRecords();
			  }
			}
		   else if(source == exitButton) {
			   System.exit(0);
		   }
	  }
	  private void setupGUI() {
		    createButton = new JButton("�����±�");
			add(createButton);
			createButton.addActionListener(this);
			insertButton = new JButton("��Ӽ�¼");
			add(insertButton);
			insertButton.addActionListener(this);
			selectButton = new JButton("ѡ���¼");
			add(selectButton);
			selectButton.addActionListener(this);
			updateButton = new JButton("���¼�¼");
			add(updateButton);
			updateButton.addActionListener(this);
			deleteButton = new JButton("ɾ����¼");
			add(deleteButton);
			deleteButton.addActionListener(this);
			dropButton = new JButton("ɾ���б�");
			add(dropButton);
			dropButton.addActionListener(this);
			exitButton = new JButton("�˳�");
			add(exitButton);
			exitButton.addActionListener(this);

			submitButton = new JButton("����");
			add(submitButton);
			submitButton.addActionListener(this);
			submitButton.setVisible(false);
			area = new JTextArea(12, 60);
		  	area.setLineWrap(true);
		  	area.setWrapStyleWord(true);
		  	JScrollPane areaScroll = new JScrollPane(area);
		  	add(areaScroll);
		}
	  private void setUpdateComponents() {
		  createButton.setVisible(false);
		  insertButton.setVisible(false);
		  selectButton.setVisible(false);
		  updateButton.setVisible(false);
		  deleteButton.setVisible(false);
		  dropButton.setVisible(false);
		  exitButton.setVisible(false);
		  submitButton.setVisible(true);
	  }
	  private void resetComponents() {
		  submitButton.setVisible(false);
		  createButton.setVisible(true);
		  insertButton.setVisible(true);
		  selectButton.setVisible(true);
		  updateButton.setVisible(true);
		  deleteButton.setVisible(true);
		  dropButton.setVisible(true);
		  exitButton.setVisible(true);
	  }
	  private void executeQuery() {
		  try {
		  	if (update)
		  		stmt.executeUpdate(query);
		  	else
		    	rs = stmt.executeQuery(query);
		}
		catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "SQLָ�������ʵ����...");
		}
	  }
	  private void displayRecords() {
		String record = "";
		try {
			ResultSetMetaData metadata = rs.getMetaData();
			int col = metadata.getColumnCount();
			while (rs.next()) {
				for(int i=1; i <= col; i++)
				 	record += rs.getString(i) + "\t";
				area.append(record + "\n");
				record = "";
			}
			rs.close();
		}
		catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "SQLָ�������ʵ����...");
	    }
		catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "�޼�¼���ڡ���ʵ����...");
	    }
      }
  }
}
public class JDBCQueryFrameApp {
  public static void main(String args[]) {
  		JFrame frame = new JDBCQueryFrame();
  		frame.setTitle("���ݿ��ѯ");
    	frame.setSize(690, 280);
    	frame.setVisible(true);
  }
}