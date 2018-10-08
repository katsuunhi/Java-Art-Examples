package ch22;

//Demo: use of ResultSet to retrieve records
import java.sql.*;

public class ResultSetTest {

 public static void main (String args[])
  {
     Connection connection;
     int rows;
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
			String selectRecord = "SELECT * FROM Books";
			rs = stmt.executeQuery(selectRecord);
			rs.last();
				rows = rs.getRow();
						System.out.println("rows: " + rows);
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