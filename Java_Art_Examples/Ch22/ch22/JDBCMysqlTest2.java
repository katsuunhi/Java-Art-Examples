package ch22;

//Demo: the basic JDBC operations
import java.sql.*;

public class JDBCMysqlTest2 {

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

            System.out.println("dbURL:" + dbURL);
            System.out.println("Connection: " + connection);

            Statement stmt = connection.createStatement();

            stmt.executeUpdate("create database ProductDB");

			stmt.executeUpdate("use ProductDB");

			stmt.executeUpdate("CREATE TABLE Products(Code CHAR(4), Title VARCHAR(40), Price DECIMAL(10, 2))");

	        stmt.executeUpdate
		        ("INSERT INTO Products (Code, Title, Price) VALUES ('1101','JSP programming', 59)");

		    stmt.executeUpdate("INSERT INTO Products VALUES ('2200', 'Computer Color Printer', 1017.96)");

		    ResultSet rs = stmt.executeQuery("SELECT * FROM Products");
		    while (rs.next()) {
				String code = rs.getString("Code");
				String title = rs.getString("Title");
				double price = rs.getDouble("Price");
				System.out.println("Code: " + code + " Title: " + title + " Price: " + price + "\n");
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
