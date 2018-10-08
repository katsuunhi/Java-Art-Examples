package ch23;

//Demo: Use of URL and URLConnection.
import java.net.*;
import java.io.*;
import java.util.Date;
class URLConnectionTest {
	public static void main(String args[]) throws Exception {
		URL http = new URL("http://bbs.tsinghua.edu.cn/");
		System.out.println("Authority: " + http.getAuthority());
		System.out.println("Content: " + http.getContent());
		System.out.println("File: " + http.getFile());
		System.out.println("Host: " + http.getHost());
		System.out.println("Protocol: " + http.getProtocol());

		URLConnection connect = http.openConnection();
		System.out.println("Date: " + new Date(connect.getDate()));
		System.out.println("Content-Type: " + connect.getContentType());
		System.out.println("Last-Modified: " +
							new Date(connect.getLastModified()));

		long length = connect.getContentLength();
		System.out.println("Content-Length: " + length);
		System.out.println("Header: " + connect.getHeaderField(3));

		if (length > 0) {
			System.out.println("=== Content of the Web Page===");
			BufferedReader input = new BufferedReader(
			                                new InputStreamReader(
			                                	connect.getInputStream()));
			String line;
			while ((line = input.readLine()) != null)
				System.out.println(line);
        	input.close();


		} else {
			System.out.println("No Content Available");
		}
	}
}