package ch22;

//Demo: use of prepared statement
import java.sql.*;

public class PreparedStatementTest1 {

 public static void main (String args[]) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:3306/ProductDB";
            String username = "root";
            String password = "";
            Connection con = DriverManager.getConnection(
                dbURL, username, password);

			String selectSql = "UPDATE Products SET Price = ? WHERE Code = ?";
			PreparedStatement ps = con.prepareStatement(selectSql);	//编译预备指令
			ps.setDouble(1, 1209.88);								//1代表第一个问号
			ps.setString(2, "2210 ");								//2代表第二个问号
			ps.executeUpdate();										//执行预备指令


     		ps.close();
        }
        catch(ClassNotFoundException e){
            System.out.println("Database driver not found.");
        }
        catch (SQLException e) {e.printStackTrace();}
    }
}