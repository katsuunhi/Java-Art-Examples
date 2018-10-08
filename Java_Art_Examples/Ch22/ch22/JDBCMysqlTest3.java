package ch22;

//Demo: the basic JDBC operations
import java.sql.*;

public class JDBCMysqlTest3 {

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
            Statement stmt = connection.createStatement();
			String createTable = "CREATE TABLE Books (ISBN CHAR(13),Title VARCHAR(50),Price DECIMAL(6, 2),Inventory INT, Publisher VARCHAR(30))";
			String insertRecord1 = "INSERT INTO Books (ISBN, Title, Price, Publisher) VALUES ('9781890774555', 'Java Lover', 66, 10, 'ABC Press') ";
			String updateRecord1 = "UPDATE Books SET Price = 69.15 WHERE Price = 66";
			String deleteRecord1 = " DELETE FROM Books WHERE ISBN = '9781890774555'";
			stmt.executeUpdate(createTable);			//调用发送SQL指令方法;
			stmt.executeUpdate(insertRecord1);
			stmt.executeUpdate(updateRecord1);
			stmt.executeUpdate(deleteRecord1);

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