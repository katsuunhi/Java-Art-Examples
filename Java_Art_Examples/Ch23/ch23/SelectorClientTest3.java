package ch23;

//Selector client application: Client 2 connects to server and get customized response

import java.nio.channels.*;
import java.nio.charset.*;
import java.nio.*;
import java.net.*;

public class SelectorClientTest3 {
	public static void main(String[] args) {
			try {
				 InetSocketAddress addr = new InetSocketAddress("localhost", 1683);
				 Charset charset = Charset.forName("UTF-8");

			     SocketChannel channel = SocketChannel.open(addr);

			     System.out.println("address: " + addr);

				 ByteBuffer buf = ByteBuffer.allocate(256);
				 channel.read(buf);

				 buf.flip();

				 CharBuffer chBuffer = charset.decode(buf);		//�������е����ݿ����Ϊ�ַ���
				 System.out.println(chBuffer);						//��ӡ���ݿ�

				 channel.close();
			 }
			 catch (Exception e) {
			 	e.printStackTrace();
			 }
	 }
 }


