package ch23;

//Multiple-client Socket server application: convert client's entries to upper case

import java.io.*;
import java.net.*;
import java.util.*;

public class MultiClientSocketServer {
	public static void main(String[] args) {
			try {
				 System.out.println("Welcome! The multiple-client server is running....");
				 ServerSocket server = new ServerSocket(1688);
				 while (true) {
				 	Socket fromClient = server.accept();
				 	ClientThread clientThread = new ClientThread(fromClient);
				 	clientThread.start();
				  }
		    }
			catch (IOException e) {
			 	e.printStackTrace();
		 	}
	 }
 }

class ClientThread extends Thread {
	Socket client;
	InputStream inData;
	OutputStream outData;
	PrintWriter toClient;
	Scanner data;
	public ClientThread(Socket fromClient) {
		try {
			client = fromClient;
			inData = fromClient.getInputStream();
			outData = fromClient.getOutputStream();
			toClient = new PrintWriter(outData, true);
			toClient.println("Type quit to STOP");
		}
		catch (IOException e) {
		 	e.printStackTrace();
		}
	}

	public void run() {
		 data = new Scanner(inData);
		 System.out.println("Connected to the client: " + this.getName());
		 System.out.println("The client address: " + client.getInetAddress());
		 while (data.hasNextLine()) {
			 String line = data.nextLine();
			 if (line.equalsIgnoreCase("quit")) {
				toClient.println("Bye!");
				try {
					client.close();
					inData.close();
					outData.close();
					System.out.println("Clinet: " + this.getName() + " closed");
					break;
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			 }
			 toClient.println(line.toUpperCase());
		 }
	}
 }

