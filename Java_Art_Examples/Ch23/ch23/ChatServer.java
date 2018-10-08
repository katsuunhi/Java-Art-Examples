package ch23;

//Client-server Chat application: Server side code

import java.io.*;
import java.net.*;
import java.util.Vector;
import java.util.Enumeration;

public class ChatServer {
	private static final int port = 1688;
	private boolean connected = true;
	private Vector<DataOutputStream> clients=new Vector<DataOutputStream>();
	public static void main(String args[]) {
		new ChatServer().server();
	}
	void server() {
		ServerSocket serverSock = null;
		try {
			InetAddress serverAddr=InetAddress.getByName(null);
			System.out.println("Welcome to Chat Server.  The server is running...");
			System.out.println("Waiting for " + serverAddr.getHostName() + " on port "+ port);
			serverSock=new ServerSocket(port, 50);  //max chatroom size is 50
		}
		catch(IOException e) {
			System.out.println(e.getMessage()+": Failed");
		}
		while(connected) {
			try {
				Socket socket=serverSock.accept();
				System.out.println("Accept "+socket.getInetAddress().getHostName());
				DataOutputStream remoteOut= new DataOutputStream(socket.getOutputStream());
				clients.addElement(remoteOut);
				new ServerHelper(socket,remoteOut,this).start();
			}
			catch(IOException e) {
				System.out.println(e.getMessage()+": Failed");
			}
		}
	}
	synchronized Vector getClients() {
		return clients;
	}
	synchronized void removeFromClients(DataOutputStream remoteOut) {
		clients.removeElement(remoteOut);
	}
}
class ServerHelper extends Thread {
	private Socket sock;
	private DataOutputStream remoteOut;
	private ChatServer server;
	private boolean connected = true;
	private DataInputStream remoteIn;
	ServerHelper(Socket sock,DataOutputStream remoteOut,ChatServer server) throws IOException {
		this.sock=sock;
		this.remoteOut=remoteOut;
		this.server=server;
		remoteIn=new DataInputStream(sock.getInputStream());
	}
	public synchronized void run() {
		String s;
		try {
			while(connected) {
				s = remoteIn.readUTF();
				broadcast(s);
			}
		}
		catch(IOException e) {
			System.out.println(e.getMessage()+"connection failed");
		}
	}
	private void broadcast(String s) {
		Vector clients=server.getClients();
		DataOutputStream dataOut=null;
		for(Enumeration e=clients.elements(); e.hasMoreElements(); ) {

			dataOut=(DataOutputStream)(e.nextElement());
			if(!dataOut.equals(remoteOut)) {
				try {
					dataOut.writeUTF(s);
				}
				catch(IOException x) {
					System.out.println(x.getMessage()+"Failed");
					server.removeFromClients(dataOut);
				}
			}
		}
	}
}
