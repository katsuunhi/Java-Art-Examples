package ch23;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

public class SelectorServer {
  public static void main(String[] args) throws IOException {
    InetSocketAddress addr1 = new InetSocketAddress(1681);
	ServerSocketChannel sch1 = ServerSocketChannel.open();
	sch1.configureBlocking(false);
	sch1.socket().bind(addr1);

	InetSocketAddress addr2 = new InetSocketAddress(1682);
	ServerSocketChannel sch2 = ServerSocketChannel.open();
	sch2.configureBlocking(false);
	sch2.socket().bind(addr2);

	InetSocketAddress addr3 = new InetSocketAddress(1683);
	ServerSocketChannel sch3 = ServerSocketChannel.open();
	sch3.configureBlocking(false);
	sch3.socket().bind(addr3);

	Selector selector = Selector.open();
	sch1.register(selector, SelectionKey.OP_ACCEPT);
	sch2.register(selector, SelectionKey.OP_ACCEPT);
	sch3.register(selector, SelectionKey.OP_ACCEPT);

	while (selector.select() > 0) {
	    Set keys = selector.selectedKeys();
	    Iterator i = keys.iterator();
	    while (i.hasNext()) {
	      SelectionKey key = (SelectionKey)i.next();
	      ServerSocketChannel sch =
	        (ServerSocketChannel)key.channel();
	      SocketChannel ch = sch.accept();
	      System.out.println("Connected to: " + ch);
	      handleClient(ch);
	      i.remove();
	    }
	  }
  }
  private static void handleClient(SocketChannel ch) {
	  int port = ch.socket().getLocalPort();
	  System.out.println("Listen to client address: " + ch.socket().getInetAddress());
	  System.out.println("Port: " + port);


	  if (port == 1681)
		  writeClient(ch, "您好！这是从服务器发来的问候。您所用端口为： " + port + "\n");
	  else if (port == 1682)
		  writeClient(ch, "Hello, Server greeting to client two from " + port + "\n");
	  else if (port == 1683)
		  writeClient(ch, "您好！这是从服务器发来的问候。您所用端口为："
	  	 				+ "(Hello, greeting from Server to client three from:) " + port + "\n");
	  else
	  	 writeClient(ch, "您好！虽然您不属于3个直接用户，但我们还是向您致以问候。您的端口是：" + port + "\n");
   }

   private static void writeClient(SocketChannel client, String message) {
	  Charset charset = Charset.forName("UTF-8");
	  ByteBuffer buf = ByteBuffer.allocate(256);
	  try {
	  	buf = charset.encode(message);
	  	client.write(buf);
	  }
	  catch (Exception e) {
	  	e.printStackTrace();
	  }
  }
}