//Demo:  assert statement


import java.io.*;

public class AssertTest{
   public static void main(String[] args) {


	double total = 219.98;
/*
	if (total <= 0.0 || total >= 200.0)	 {	//超出合法值范围
			System.out.println("total: " + total + " is out of the range.");
		System.out.println("at AssertTest.main(AssertTest.java:10) ");
		System.exit(0);
	}

*/

	assert (total > 0.0 && total < 200.0) : "total: " + total + " – is out of the range.";


/*
	int age = 17;
	assert age > 18 : "Age must be greater than 18.";
*/

   }
}
