package ch22;

//Demo: use of transaction
import java.sql.*;

public class TransactionTest1 {

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
			String updateRecord = "UPDATE Books SET Inventory = 10 WHERE ISBN = '9781890774555'";
			String selectRecord = "SELECT * FROM Books WHERE ISBN = '9781890774555'";
			connection.setAutoCommit(false);		//�ر��Զ�ִ��ģʽ
			stmt.executeUpdate(updateRecord);		//����ָ����������Ԫ
			rs = stmt.executeQuery(selectRecord);	//����ָ����������Ԫ
			connection.setAutoCommit(true);			//ִ��������������Ԫ��ָ��
			while (rs.next()) {
				System.out.println("ISNB: " + rs.getString(1));
				System.out.println("Book Title: " + rs.getString(2));
				System.out.println("Price: " + rs.getDouble(3));
				System.out.println("Inventory: " + rs.getInt(4));
				System.out.println("Publisher: " + rs.getString(5));
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