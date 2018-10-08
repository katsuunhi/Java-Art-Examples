package ch23;

//Multi-client supported server with DatagramSocket and DatagramPacket application:
//Assign no-duplicate phone number to any requsted client
import java.io.*;
import java.net.*;

public class MultiClientDatagramServer {
  public static void main(String[] args) throws IOException {
			DatagramSocket socket = new DatagramSocket(1688);
			DatagramPacket receivePacket;
			System.out.println("Welcome! The server is running....");
		    while(true) {
				byte[] buf = new byte[256];

				receivePacket = new DatagramPacket(buf, buf.length);
				socket.receive(receivePacket);

				//Socket fromClient = server.accept();
      		DatagramClientThread clientThread = new DatagramClientThread(socket, receivePacket, buf);
				clientThread.start();
			}
  }
}
class DatagramClientThread extends Thread {
	DatagramSocket socket;
	DatagramPacket receivePacket, sendPacket;
	byte[] buf = null;
  protected static int number = 1100;

  public DatagramClientThread(DatagramSocket socket, DatagramPacket receivePacket, byte[] buf) {
      this.socket = socket;
	  this.receivePacket = receivePacket;
      this.buf = buf;
      System.out.println("Connected to the client: " + this.getName());
  }
  public void run() {
		InetAddress address = receivePacket.getAddress();
		int port = receivePacket.getPort();
		String message = "Packet from Datagram Server: " + address + "\nTo Client: " + this.getName() + "\n"
						+ "Your assigned phone number: ";

		buf = (message + phoneNum()).getBytes();

		sending(socket, buf, buf.length, address, port);
		System.out.println("The client address: " + address);
  }
  private void sending(DatagramSocket socket, byte[] buf, int length, InetAddress address, int port) {
		 		DatagramPacket sendPacket = new DatagramPacket(buf, length, address, port);
		 		try {
		 			socket.send(sendPacket);
		 		}catch (IOException e) {
		 			e.printStackTrace();
		 		}
	}
	private String phoneNum() {
		String areaCode = "800 ";
		String prefix = "777 ";

		String phone = areaCode + prefix + number;
		number += 2;
		return phone;
	}
}