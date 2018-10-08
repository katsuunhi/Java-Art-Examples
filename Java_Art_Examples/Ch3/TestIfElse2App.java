//Demo of testing if-else with multiple statements

import java.util.Scanner;

public class TestIfElse2App {
  public static void main(String[] args) {

  double discountRate = 0.1;	//defult discoutRate
  int 	total = 150,            //defult total
  		bonus = 0;		//initial value as 0

  String answer;		//define a string

  Scanner  sc = new Scanner(System.in);	//create an object of Scanner

  System.out.println("Let's see the secondt example for if-else......\n");

  System.out.print("The total is >= " + total + ", enter y or n to confirm: ");
  answer = sc.nextLine();				//scan in the answer

  System.out.println();

  if (answer.equalsIgnoreCase("y"))		//if this is true, then do the following
    {
    	System.out.println("The answer is " + answer);
    	discountRate = 0.2;			//increase discountRate to 0.2
    	bonus += 10;				//bonus = bonus + 10
    }
  else		//total < 150
    {
      	System.out.println("The answer is " + answer); 	//display the answer
      	System.out.print("Please enter the total: ");	//ask for the total
      	total = sc.nextInt();				//scan in the total
      	discountRate = 0.15;				//increase to 0.15
      	bonus +=5;							//bonus = bonus + 5
    }   //end of if-else

  System.out.println("total is " + total);//display the result
  System.out.println("discount Rate is " + discountRate);
  System.out.println("bonus is " + bonus);
  System.out.println("Discount is " + total * discountRate);

  System.out.println("\nThank you for using this example.");
 }  	// end of the main()
}	//end of the TestIfElse2App