package ch23;

//Multiple clients with DatagramSocket and DatagramPacket application: connect to server to get assigned phone number

import java.io.*;
import java.net.*;

public class MultiDatagramClient {
	public static void main(String[] args) {
		try {
			DatagramSocket socket = new DatagramSocket();

			byte[] buf = new byte[256];
			InetAddress address = InetAddress.getByName("127.0.0.1");

			sending(socket, buf, buf.length, address, 1688);

	      	String received = receiving(socket, buf, buf.length);
        	System.out.println(received);

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

