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
			ResultSetMetaData metaData = rs.getMetaData();				//得到封装有Products的元数据对象
																		//提取元数据的操作
			System.out.println("记录域数: " + metaData.getColumnCount());
			System.out.println("Title记录域最大显示长度 : " + metaData.getColumnDisplaySize(2));
			System.out.println("Code记录域标记名: " + metaData.getColumnLabel(1));
			System.out.println("Code记录域名: " + metaData.getColumnName(1));
			System.out.println("Price记录域Java类型: " + metaData.getColumnTypeName(3));
			System.out.println("Price记录域数据类型字节数: " + metaData.getPrecision(3));
			System.out.println("数据表名: " + metaData.getTableName(2));
			rs.close();
        }
        catch(ClassNotFoundException e){
            System.out.println("Database driver not found.");
        }   
        catch (SQLException e) {e.printStackTrace();}
    }
}