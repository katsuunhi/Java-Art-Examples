//Demo:  exception handling in array uses with specially designed validation class

import java.util.*;

public class ArrayValidationTest3 {
  public static void main(String[] args) {

	  String choice = "y";
	  int max = 1000;
	  int size = 0;

	  Scanner sc = new Scanner(System.in);

	while (choice.equals("y")) {
          size = Validator4.arraySize(sc, "Please enter an integer for the size of array: ");
          int[] intArray = new int[size];		//size已经被验证

           ArrayDemo.fillArray(intArray);
		   Arrays.sort(intArray);
		   ArrayDemo.display(intArray);

	       System.out.print("Continue? (y/n): ");
		   choice = sc.next();
		//count = 0;								//reset count
     }
  }
}