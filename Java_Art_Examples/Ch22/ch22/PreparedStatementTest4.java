package ch22;

//Demo: use of prepared statement
import java.sql.*;
import javax.swing.*;

public class PreparedStatementTest4 {

 public static void main (String args[]) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:3306/ProductDB";
            String username = "root";
            String password = "";
            String code = "";
            String choice = "y";

			ResultSet rs = null;
			Connection con = DriverManager.getConnection(dbURL, username, password);
			String deleteSql = "SELECT * FROM Products WHERE Code = ?";
			PreparedStatement ps = con.prepareStatement(deleteSql);
				while (true) {
					code = JOptionPane.showInputDialog("�����Ҫ��ѯ�ļ�¼���: ");
					ps.setString(1, code);		//ָ���ļ�¼
					rs = ps.executeQuery();		//ִ��Ԥ��ָ��
					rs.next();					//ָ�������¼
					String record = rs.getString(1) + " " + rs.getString(2) + " " + rs.getDouble(3);		//������¼
					JOptionPane.showMessageDialog(null, record);					//��ʾ��¼
					choice = JOptionPane.showInputDialog("�Ƿ������(y/n): "); ;
					if (choice.equalsIgnoreCase("n"))
						break;
				}
			ps.close();
		}

        catch(ClassNotFoundException e){
            System.out.println("Database driver not found.");
        }
        catch (SQLException e) {e.printStackTrace();}
    }
}