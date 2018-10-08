package ch22;

//数据库应用实例

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;

class JDBCProductFrame extends JFrame {
	 String columnNames[] = { "产品代码", "产品名称", "产品价格" };
	 String records[][];
	 String record[] = new String[3];
	 int rows = 0;
	 int row = 0;
	 JTable table;
	 DefaultTableModel model;
	 JScrollPane scrollPane;
	 JPanel panel;
	 Connection connection;
	 Statement stmt = null ;
	 ResultSet rs = null;

	 JDBCProductFrame() {
		 makeJDBCConnection();
		 getResult();
    	 buildRecordTable();
    	 model = new DefaultTableModel(records, columnNames);
		 table = new JTable(model);
		 scrollPane = new JScrollPane(table);

		 add(scrollPane, BorderLayout.CENTER);
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
	private void getResult() {
		try {
			rs = stmt.executeQuery("SELECT * FROM Products");
		}
		catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "SQL指令出错。查证后再试...");
		}

	}
	private void buildRecordTable() {
		try {
		    rs.last();
		    rows = rs.getRow();
		    records = new String[rows][3];
		    int row = 0;
		    rs.beforeFirst();
		    while (rs.next()) {
				records[row][0] = rs.getString(1);
				records[row][1] = rs.getString(2);
				records[row][2] = "" + rs.getDouble(3);
				row++;
			}
			rs.close();
		}
		catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "SQL指令出错。查证后再试...");
		}
	}
	class ButtonPanel extends JPanel implements ActionListener {
		JButton addButton, updateButton, deleteButton, submitButton, sendButton, returnButton, exitButton;
		JLabel codeLabel, titleLabel, priceLabel;
		JTextField codeField, titleField, priceField;
		FlowLayout flowLayout;
		String message = "您必须首先从表中选择一个记录...";
		ButtonPanel() {
			setupGUI();
	  	}
	  	public void actionPerformed(ActionEvent e) {
		  Object source = e.getSource();
		  if (source == addButton) {
			  setUpdateComponents();
			  submitButton.setVisible(true);
			  sendButton.setVisible(false);
		  }
		  else if(source == updateButton) {
			  sendButton.setVisible(true);
			  submitButton.setVisible(false);
			  setUpdateComponents();
			  setUpdateRecord();
			  model.removeRow(row);
		  }
		  else if(source == sendButton) {
			  updateRecord();
			  setLastRecord();
			  model.insertRow(row, record);
			  clearFields();
			  resetComponents();
		  }
		  else if(source == deleteButton) {
			   deleteRecord();
		  }
		  else if( source == submitButton) {
			  	String code = codeField.getText();
			  	String title = titleField.getText();
			  	double price = Double.parseDouble(priceField.getText());
			  	insertRecord(code, title, price);
			  	setLastRecord();
			    model.addRow(record);
			    clearFields();
			}
		   else if(source == returnButton) {
			   clearFields();
			   resetComponents();

			}
		   else if(source == exitButton) {
			   System.exit(0);
		   }
	  }
	  private void setupGUI() {
		  flowLayout = new FlowLayout(FlowLayout.CENTER);
			setLayout(flowLayout);
			addButton = new JButton("添加记录");
			add(addButton);
			addButton.addActionListener(this);
			updateButton = new JButton("更新记录");
			add(updateButton);
			updateButton.addActionListener(this);
			deleteButton = new JButton("删除记录");
			add(deleteButton);
			deleteButton.addActionListener(this);
			exitButton = new JButton("退出");
			add(exitButton);
			exitButton.addActionListener(this);
			codeLabel = new JLabel("产品代码: ");
			add(codeLabel);
			codeLabel.setVisible(false);
			codeField = new JTextField(4);
			add(codeField );
			codeField.setVisible(false);
			titleLabel = new JLabel("产品名称: ");
			add(titleLabel );
			titleLabel.setVisible(false);
			titleField = new JTextField(20);
			add(titleField);
			titleField.setVisible(false);
			priceLabel = new JLabel("产品价格: ");
			add(priceLabel);
			priceLabel.setVisible(false);
			priceField = new JTextField(6);
			add(priceField);
			priceField.setVisible(false);
			submitButton = new JButton("发送");
			add(submitButton);
			submitButton.addActionListener(this);
			sendButton = new JButton("提交更新");
			add(sendButton);
			sendButton.setVisible(false);
			sendButton.addActionListener(this);
			submitButton.setVisible(false);
			returnButton = new JButton("返回");
			add(returnButton);
			returnButton.addActionListener(this);
			returnButton.setVisible(false);
	  }
	  private void setUpdateComponents() {
		  codeLabel.setVisible(true);
		  titleLabel.setVisible(true);
		  priceLabel.setVisible(true);
		  codeField.setVisible(true);
		  titleField.setVisible(true);
		  priceField.setVisible(true);
		  addButton.setVisible(false);
		  updateButton.setVisible(false);
		  deleteButton.setVisible(false);
		  exitButton.setVisible(false);
		  returnButton.setVisible(true);
	  }
	  private void resetComponents() {
		  codeLabel.setVisible(false);
		  titleLabel.setVisible(false);
		  priceLabel.setVisible(false);
		  codeField.setVisible(false);
		  titleField.setVisible(false);
		  priceField.setVisible(false);
		  submitButton.setVisible(false);
		  addButton.setVisible(true);
		  updateButton.setVisible(true);
		  deleteButton.setVisible(true);
		  exitButton.setVisible(true);
		  returnButton.setVisible(false);
		  sendButton.setVisible(false);
	  }
	  private void clearFields() {
		  codeField.setText("");
		  titleField.setText("");
		  priceField.setText("");

	  }
	  private void insertRecord(String code, String title, double price) {
		  try {
		  		String insertSql = "INSERT INTO Products (Code, Title, Price) VALUES ( ?, ?, ?)";
				PreparedStatement ps = connection.prepareStatement(insertSql);
				ps.setString(1, code);
				ps.setString(2, title);
				ps.setDouble(3, price);
				ps.executeUpdate();
     		    ps.close();
		  }
		  catch (SQLException e) {
			  JOptionPane.showMessageDialog(null, "SQL指令出错。查证后再试...");
		  }
	  }
	  private void updateRecord() {
		  try {
				String updateSql = "UPDATE Products SET Code = ?, Title = ?, Price = ? WHERE Code = ?";
				PreparedStatement ps = connection.prepareStatement(updateSql);
				ps.setString(1, codeField.getText());
				ps.setString(2, titleField.getText());
				ps.setDouble(3, Double.parseDouble(priceField.getText()));
				ps.setString(4, codeField.getText());
				ps.executeUpdate();
				ps.close();
		  }
		  catch (SQLException e) {
			  JOptionPane.showMessageDialog(null, "SQL指令出错。查证后再试...");
		  }
	  }
	  private void setLastRecord() {
		  record[0] = codeField.getText();
		  record[1] = titleField.getText();
		  record[2] = priceField.getText();
	  }
	  private void setUpdateRecord() {
		  try {
		  	row = table.getSelectedRow();
		  	if (row == -1) {
			  throw new Exception(message);
		  	}
		  	else {

			  codeField.setText(records[row][0]);
			  titleField.setText(records[row][1]);
			  priceField.setText(records[row][2]);
		  	}
		}
		catch (Exception ex) {
			 JOptionPane.showMessageDialog(null, ex);
			 System.exit(1);
		}

	  }
	  private void deleteRecord() {
		  try {
			  	row = table.getSelectedRow();
			  	if (row != -1) {
			    	model.removeRow(row);
			    	getResult();
					buildRecordTable();
					String updateSql = "DELETE FROM Products WHERE Code = ?";
					PreparedStatement ps = connection.prepareStatement(updateSql);
					ps.setString(1, records[row][0]);
					ps.executeUpdate();
					ps.close();
				}
				else throw new Exception(message);
		  }
		  catch (SQLException e) {
			  JOptionPane.showMessageDialog(null, "SQL指令出错。查证后再试...");
		  }
		  catch (Exception ex) {
			  JOptionPane.showMessageDialog(null, "数据表不存在。查证后再试...");
		  }
	  }
  }

}
public class JDBCProductFrameApp {
  public static void main(String args[]) {
  		JFrame frame = new JDBCProductFrame();
  		frame.setTitle("产品数据表");
    	frame.setSize(690, 280);
    	frame.setResizable(false);
    	frame.setVisible(true);
  }
}
