package ch23;

//DatagramSocket and DatagramPacket simple server application: convert client's entries to upper case
//and return the packet length

import java.io.*;
import java.net.*;

public class DatagramServerTest {
	public static void main(String[] args) {
		    System.out.println("Welcome! The server is running....");
		    String line = "Datagram packet from server: I love Java programming.\n";
			String promptString = line.toUpperCase() + "Enter quit to STOP";
			try {
				 DatagramSocket socket = new DatagramSocket(1688);
				 DatagramPacket receivePacket;
				 byte[] buf = new byte[256];

				 receivePacket = new DatagramPacket(buf, buf.length);
				 socket.receive(receivePacket);

				 buf = promptString.getBytes();


				InetAddress address = receivePacket.getAddress();
				int port = receivePacket.getPort();

				sending(socket, buf, buf.length, address, port);
				while (true) {
					 buf = new byte[256];   //clear buffer

					 receivePacket = new DatagramPacket(buf, buf.length);
					 socket.receive(receivePacket);

					 String receive = new String(receivePacket.getData());

					 buf = receive.toUpperCase().getBytes();

					 sending(socket, buf, buf.length, address, port);

					 buf = new byte[256];  //clear buffer
					 String wordCount = "(Converting from server and packet length: " + receive.trim().length() + ")";

					 receivePacket = new DatagramPacket(buf, buf.length);
					 socket.receive(receivePacket);
					 buf = wordCount.getBytes();

					 sending(socket, buf, buf.length, address, port);
			 	}
			 }
			 catch (IOException e) {
				 e.printStackTrace();
			 }
	 }
	 public static void sending(DatagramSocket socket, byte[] buf, int length, InetAddress address, int port) {
	 		DatagramPacket sendPacket = new DatagramPacket(buf, length, address, port);
	 		try {
	 			socket.send(sendPacket);
	 		}catch (IOException e) {
	 			e.printStackTrace();
	 		}
	}
}

