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
			connection.setAutoCommit(false);						//�ر��Զ�ִ��ģʽ
			ps = connection.prepareStatement(updateRecord);			//����ָ����������Ԫ
			ps.setInt(1, 100);										//����InventoryΪ100
			ps.executeUpdate();										//��������Ԥ��ָ��
			rs = stmt.executeQuery(selectRecord);					//����ָ����������Ԫ
			connection.setAutoCommit(true);							//ִ��������������Ԫ��ָ��

			while (rs.next()) {
				System.out.println("ISNB: " + rs.getString(1));
				System.out.println("����: " + rs.getString(2));
				System.out.println("�۸�: " + rs.getDouble(3));
				System.out.println("�����: " + rs.getInt(4));
				System.out.println("������: " + rs.getString(5));
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