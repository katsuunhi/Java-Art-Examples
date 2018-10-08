package ch23;

//Multiple-tier Socket server application with database connection

import java.io.*;
import java.net.*;
import java.util.*;
import java.sql.*;

public class MultiTierSocketServer {
	public static void main(String[] args) {
			try {
				 System.out.println("Welcome! The multiple-tier client-server is running....");
				 ServerSocket server = new ServerSocket(1688);
				 while (true) {
				 	Socket fromClient = server.accept();
				 	MultiTierClientThread clientThread = new MultiTierClientThread(fromClient);
				 	clientThread.start();
				  }
		    }
			catch (IOException e) {
			 	e.printStackTrace();
		 	}
	 }
 }

class MultiTierClientThread extends Thread {
	Socket client;
	InputStream inData;
	OutputStream outData;
	PrintWriter toClient;
	Scanner data;
	Connection connection;
	ResultSet rs;

	public MultiTierClientThread(Socket fromClient) {
		try {
			client = fromClient;
			inData = fromClient.getInputStream();
			outData = fromClient.getOutputStream();
			toClient = new PrintWriter(outData, true);
			connectDatabase();
		}
		catch (IOException e) {
		 	e.printStackTrace();
		}
	}
	public void run() {
			 String requestedDb = "";
			 String requestedPrice = "";
			 String response = "";
			 data = new Scanner(inData);
			 System.out.println("The client address: " + client.getInetAddress());
			 if (data.hasNextLine()) {
			   requestedDb = data.nextLine();
			   requestedPrice = data.nextLine();
		   	 }
			 if (!requestedDb.equals("") || !requestedPrice.equals("")) {
				String query = buildQuery(requestedDb);
				double price = buildPrice(requestedPrice);
				 rs = getResult(query, price);
				 if (requestedDb.equals("Products"))
				 	 response = buildProductsDbResponse();
				 else response = buildBooksDbResponse();

				 toClient.println(response);
				 toClient.close();
			 }
		 }

	private void connectDatabase() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String dbURL = "jdbc:mysql://localhost:3306/ProductDB";
			String username = "root";
			String password = "";
			connection = DriverManager.getConnection(
				dbURL, username, password);

			System.out.println("Database connection is succeeded...");

			System.out.println("dbURL:" + dbURL);
			System.out.println("Connection: " + connection);
		}
		catch(ClassNotFoundException e){
			System.out.println("Database driver not found.");
        }
        catch(SQLException e){
		    System.out.println("Error opening the db connection: " + e.getMessage());
		}
	}
	private String buildQuery(String requestedDb) {
		String query = "";
		if (requestedDb.equals("Products"))
			query = "SELECT * FROM Products WHERE price >= ?";
		else if (requestedDb.equals("Books"))
			query = "SELECT * FROM Books WHERE price >= ?";

	    return query;
	}
	private double buildPrice(String requestedPrice) {
		double price = 0.0;
		if (requestedPrice.equals("1"))
			price = 100.00;
		return price;
	}
	private ResultSet getResult(String query, double price) {
		try {
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setDouble(1, price);
			rs = ps.executeQuery();
		}
		catch (SQLException e) {e.printStackTrace();}

		return rs;
	}
	private String buildProductsDbResponse() {
		String result = "";
		try {
			while (rs.next()) {
				String code = rs.getString("Code");
				String title = rs.getString("Title");
				double price = rs.getDouble("Price");
				result += "Code: " + code + " Title: " + title + " Price: " + price + "\n";
			}
		}
		catch (SQLException e) {e.printStackTrace();}

		return result;
	}
	private String buildBooksDbResponse() {
			String result = "";
			try {
				while (rs.next()) {
					String code = rs.getString("ISBN");
					String title = rs.getString("Title");
					double price = rs.getDouble("Price");
					int inventory = rs.getInt("Inventory");
					String publisher = rs.getString("Publisher");
					result += "ISBN: " + code + " Title: " + title + " Price: " + price
								+ "  Inventory: " + inventory + "  Publisher: " + publisher + "\n";
				}
			}
			catch (SQLException e) {e.printStackTrace();}

			return result;
	}

 }