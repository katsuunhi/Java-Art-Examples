package ch12;

//��������ʾ����

public class AnonmousClassTest {
	   public static void main( String args[] ) {

		    System.out.println(new Object() {		//������
								   public String toString() {
									   return "toString() in Object class will return the address of " +
									           super.toString();
								   }
							   });
		}
	}
