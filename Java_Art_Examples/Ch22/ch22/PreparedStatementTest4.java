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
					code = JOptionPane.showInputDialog("请打入要查询的纪录编号: ");
					ps.setString(1, code);		//指定的记录
					rs = ps.executeQuery();		//执行预备指令
					rs.next();					//指向这个记录
					String record = rs.getString(1) + " " + rs.getString(2) + " " + rs.getDouble(3);		//产生记录
					JOptionPane.showMessageDialog(null, record);					//显示记录
					choice = JOptionPane.showInputDialog("是否继续？(y/n): "); ;
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