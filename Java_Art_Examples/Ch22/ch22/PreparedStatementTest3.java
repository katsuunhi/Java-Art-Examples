package ch22;

//Demo: use of prepared statement
import java.sql.*;
import java.util.*;

public class PreparedStatementTest3 {

 public static void main (String args[]) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:3306/ProductDB";
            String username = "root";
            String password = "";
            double price = 0;
            String choice = "y";

            Scanner sc = new Scanner(System.in);

            Connection con = DriverManager.getConnection(
                dbURL, username, password);

			String deleteSql = "DELETE FROM Products WHERE Price = ?";
			PreparedStatement ps = con.prepareStatement(deleteSql);
				while (true) {
					System.out.println("Please enter the price you want that record to be deleted: ");
					price = sc.nextDouble();
					ps.setDouble(1, price);		//删除由price指定的记录
					ps.executeUpdate();			//执行预备指令
					System.out.println("Do you want to continue? (y/n): ");
					choice = sc.next();
					if (choice.equalsIgnoreCase("n"))
						break;
					else
					 sc.nextLine();
			}

     		ps.close();
        }
        catch(ClassNotFoundException e){
            System.out.println("Database driver not found.");
        }
        catch (SQLException e) {e.printStackTrace();}
    }
}