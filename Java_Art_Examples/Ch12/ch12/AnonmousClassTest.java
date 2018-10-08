package ch12;

//匿名类演示程序

public class AnonmousClassTest {
	   public static void main( String args[] ) {

		    System.out.println(new Object() {		//匿名类
								   public String toString() {
									   return "toString() in Object class will return the address of " +
									           super.toString();
								   }
							   });
		}
	}
