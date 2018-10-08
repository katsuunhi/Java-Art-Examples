//Demo: Exception chaining

import java.io.*;

public class ExceptionChainingTest{
   public static void main(String[] args) throws IOException, CustomIOException {
	   try{
		   try{ 
    		throw new IOException();
    	   }
		   catch(IOException e){
   	        throw new CustomIOException(e);
   	      	}
	   }
  	  
  	 	catch(CustomIOException e) {
  		  System.out.println("File cannot read...");
  		  System.out.println(e.getCause());
  	  }
   }
}

class CustomIOException extends Exception {
	public CustomIOException() {}
	public CustomIOException(Throwable cause) {		//cause代表上一个抛出的异常对象
		super(cause);								//记录这个对象的异常信息
	}
}
