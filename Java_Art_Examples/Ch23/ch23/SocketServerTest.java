package ch23;

//Socket simple server application: convert client's entries to upper case

import java.io.*;
import java.net.*;
import java.util.*;

public class SocketServerTest {
	public static void main(String[] args) {
		    System.out.println("Welcome! The server is running....");
			try {
				 ServerSocket server = new ServerSocket(1688);
				 Socket fromClient = server.accept();
				 System.out.println("Connected to the client....");

				 InputStream inData = fromClient.getInputStream();
				 OutputStream outData = fromClient.getOutputStream();
				 PrintWriter toClient = new PrintWriter(outData, true);
				 toClient.println("Type quit to STOP");

				 Scanner data = new Scanner(inData);
				 while (data.hasNextLine()) {
					 String line = data.nextLine();
					 if (line.equalsIgnoreCase("quit")) {
						server.close();
						toClient.println("Bye!");
						break;
					 }
					 toClient.println(line.toUpperCase());
				 }
			 }
			 catch (IOException e) {
				 e.printStackTrace();
			 }

	 }
 }

