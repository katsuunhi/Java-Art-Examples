package ch22;

//数据库应用实例

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class JDBCQueryFrame extends JFrame {
	 JPanel panel;
	 boolean update = true;
	 String query = "";
	 String createQuery = "CREATE TABLE 数据表名 (字段列表)";
	 String insertQuery = "INSERT INTO 数据表名 VALUES (字段值列表)";
	 String selectQuery = "SELECT 字段列表 FROM 数据表名 WHERE 选择条件";
	 String updateQuery = "UPDATE 数据表名 SET 字段表达式 WHERE 选择条件";
	 String deleteQuery = "DELETE FROM 数据表名 WHERE 删除条件";
	 String dropQuery = "DROP TABLE 数据表名";

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
			 JOptionPane.showMessageDialog(null, "无法找到数据库驱动程序。");
		 }
		 catch(SQLException e){
			 JOptionPane.showMessageDialog(null,"数据库连接出错: " + e.getMessage());
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
			  	JOptionPane.showMessageDialog(null, "如下SQL指令已成功执行：\n" + query);
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
		    createButton = new JButton("建立新表");
			add(createButton);
			createButton.addActionListener(this);
			insertButton = new JButton("添加记录");
			add(insertButton);
			insertButton.addActionListener(this);
			selectButton = new JButton("选择记录");
			add(selectButton);
			selectButton.addActionListener(this);
			updateButton = new JButton("更新记录");
			add(updateButton);
			updateButton.addActionListener(this);
			deleteButton = new JButton("删除记录");
			add(deleteButton);
			deleteButton.addActionListener(this);
			dropButton = new JButton("删除列表");
			add(dropButton);
			dropButton.addActionListener(this);
			exitButton = new JButton("退出");
			add(exitButton);
			exitButton.addActionListener(this);

			submitButton = new JButton("发送");
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
			JOptionPane.showMessageDialog(null, "SQL指令出错。核实再试...");
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
			JOptionPane.showMessageDialog(null, "SQL指令出错。核实再试...");
	    }
		catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "无记录存在。核实再试...");
	    }
      }
  }
}
public class JDBCQueryFrameApp {
  public static void main(String args[]) {
  		JFrame frame = new JDBCQueryFrame();
  		frame.setTitle("数据库查询");
    	frame.setSize(690, 280);
    	frame.setVisible(true);
  }
}