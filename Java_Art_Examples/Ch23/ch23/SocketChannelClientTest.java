package ch23;

//SocketChannel simple client application: connect to server to get current date and time

import java.nio.channels.*;
import java.nio.charset.*;
import java.nio.*;
import java.net.*;

public class SocketChannelClientTest {
	public static void main(String[] args) {
			try {
				 InetSocketAddress addr = new InetSocketAddress("localhost", 8000);
				 Charset charset = Charset.forName("US-ASCII");
			     SocketChannel channel = SocketChannel.open(addr);

				 ByteBuffer buf = ByteBuffer.allocate(256);
				 channel.read(buf);

				 buf.flip();

				 CharBuffer chBuffer = charset.decode(buf);		//将缓冲中的数据块解码为字符串
				 System.out.println("The current date and time from Server: " + chBuffer);						//打印数据块

				 channel.close();
			 }
			 catch (Exception e) {
			 	e.printStackTrace();
			 }
	 }
 }
