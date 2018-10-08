package ch22;

//Demo: use of prepared statement
import java.sql.*;

public class PreparedStatementTest2 {

 public static void main (String args[]) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:3306/ProductDB";
            String username = "root";
            String password = "";
            Connection con = DriverManager.getConnection(
                dbURL, username, password);

			String insertSql = "INSERT INTO Products (Code, Title, Price) VALUES ( ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(insertSql);							//����Ԥ��ָ��;
			ps.setString(1, "1110");														//1�����һ���ʺ�
			ps.setString(2, "Java EE Programming");										//2����ڶ����ʺ�
			ps.setDouble(3, 77.02);														//3����������ʺ�
			ps.executeUpdate();																//ִ��Ԥ��ָ��;

     		ps.close();
        }
        catch(ClassNotFoundException e){
            System.out.println("Database driver not found.");
        }  //catch
        catch (SQLException e) {e.printStackTrace();}
    }
}