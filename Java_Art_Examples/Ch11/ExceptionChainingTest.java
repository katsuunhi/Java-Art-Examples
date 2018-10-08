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
	public CustomIOException(Throwable cause) {		//cause������һ���׳����쳣����
		super(cause);								//��¼���������쳣��Ϣ
	}
}
