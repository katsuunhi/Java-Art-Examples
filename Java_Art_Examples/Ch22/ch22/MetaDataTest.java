package ch22;

//Demo: use of MetaData
import java.sql.*;

public class MetaDataTest {

 public static void main (String args[]) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:3306/ProductDB";
            String username = "root";
            String password = "";


			Connection con = DriverManager.getConnection(dbURL, username, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Products");
			ResultSetMetaData metaData = rs.getMetaData();				//�õ���װ��Products��Ԫ���ݶ���
																		//��ȡԪ���ݵĲ���
			System.out.println("��¼����: " + metaData.getColumnCount());
			System.out.println("Title��¼�������ʾ���� : " + metaData.getColumnDisplaySize(2));
			System.out.println("Code��¼������: " + metaData.getColumnLabel(1));
			System.out.println("Code��¼����: " + metaData.getColumnName(1));
			System.out.println("Price��¼��Java����: " + metaData.getColumnTypeName(3));
			System.out.println("Price��¼�����������ֽ���: " + metaData.getPrecision(3));
			System.out.println("���ݱ���: " + metaData.getTableName(2));
			rs.close();
        }
        catch(ClassNotFoundException e){
            System.out.println("Database driver not found.");
        }   
        catch (SQLException e) {e.printStackTrace();}
    }
}