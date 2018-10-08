package ch22;

//Demo: use of transaction
import java.sql.*;

public class TransactionTest2 {

 public static void main (String args[])
  {
     Connection connection;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:3306/ProductDB";
            String username = "root";
            String password = "";
            connection = DriverManager.getConnection(
                dbURL, username, password);

            System.out.println("connection is succeeded...");

			Statement stmt = connection.createStatement();
			ResultSet rs = null;
			PreparedStatement ps = null;
			String updateRecord = "UPDATE Books SET Inventory = ? WHERE ISBN = '9781890774555'";
			String selectRecord = "SELECT * FROM Books WHERE ISBN = '9781890774555'";
			connection.setAutoCommit(false);						//关闭自动执行模式
			ps = connection.prepareStatement(updateRecord);			//发送指令至事务处理单元
			ps.setInt(1, 100);										//设置Inventory为100
			ps.executeUpdate();										//发送以上预备指令
			rs = stmt.executeQuery(selectRecord);					//发送指令至事务处理单元
			connection.setAutoCommit(true);							//执行所有在事务处理单元的指令

			while (rs.next()) {
				System.out.println("ISNB: " + rs.getString(1));
				System.out.println("书名: " + rs.getString(2));
				System.out.println("价格: " + rs.getDouble(3));
				System.out.println("存货数: " + rs.getInt(4));
				System.out.println("出版社: " + rs.getString(5));
			}
     		stmt.close();
        }
        catch(ClassNotFoundException e){
            System.out.println("Database driver not found.");
        }
        catch(SQLException e){
            System.out.println("Error opening the db connection: " + e.getMessage());
		}

    }
}