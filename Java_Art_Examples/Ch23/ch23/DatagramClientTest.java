package ch23;

//DatagramSocket and DatagramPacket simple client application: connect to server to convert entries to upper case
//and return the packet length

import java.io.*;
import java.net.*;
import java.util.*;

public class DatagramClientTest {
	public static void main(String[] args) {
		try {
			DatagramSocket socket = new DatagramSocket();

			byte[] buf = new byte[256];
			InetAddress address = InetAddress.getByName("127.0.0.1");

			sending(socket, buf, buf.length, address, 1688);

	      	String received = receiving(socket, buf, buf.length);
      	System.out.println(received);

			Scanner sc = new Scanner(System.in);

			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				if (!line.trim().equals("quit")) {
					 buf = new byte[256];

					buf = line.getBytes();
					sending(socket, buf, buf.length, address, 1688);

					received = receiving(socket, buf, buf.length);

					System.out.println(received);

					buf = new byte[256];

					sending(socket, buf, buf.length, address, 1688);

					received = receiving(socket, buf, buf.length);
					System.out.println(received);
				}
				else break;

			}
			socket.close();
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
	public static String receiving(DatagramSocket socket, byte[] buf, int length) {
		DatagramPacket receivePacket = new DatagramPacket(buf, length);
		String received = null;
		try {
			socket.receive(receivePacket);
			received = new String(receivePacket.getData(), 0, receivePacket.getLength());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return received;
	}
}
