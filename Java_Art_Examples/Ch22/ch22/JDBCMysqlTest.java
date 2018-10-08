package ch22;

//Demo:  JDBC MySQL connection test

import java.sql.*;

public class JDBCMysqlTest {
 public static void main (String args[])
  {   
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:3306";
            Connection connection = DriverManager.getConnection(
                dbURL, "root", "");

            System.out.println("connection is succeeded...");

            System.out.println("dbURL:" + dbURL);
            System.out.println("Connection: " + connection);
        }
        catch(ClassNotFoundException e){
            System.out.println("Database driver not found.");
        }  //catch
        catch(SQLException e){
            System.out.println("Error opening the db connection: "
                               + e.getMessage());
	    }
    }
}