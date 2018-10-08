package ch23;

//Simple ServerSocketChannel server to reposnse the current date and time to the clients
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;

public class SocketChannelServer {
  public static void main(String[] args)  {
	  try {
		    Charset charset = Charset.forName("US-ASCII");
    		ServerSocketChannel server = ServerSocketChannel.open();
    		server.socket().bind(new java.net.InetSocketAddress(8000));
    		System.out.println("Welcome! The SocketChannel server is running...");
    		for (;;) { 		// This server runs forever
      			SocketChannel client = server.accept();
      			ByteBuffer buf = ByteBuffer.allocate(256);
      			String response = new java.util.Date().toString() + "\n";

				buf = charset.encode(response);
				client.write(buf);
      			client.close();
    		}
  		}  		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

