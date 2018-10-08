//Demo:  exception handling in array uses with modified finally

import java.util.*;

public class ArrayValidationTest2 {
  public static void main(String[] args) {

	  String choice = "y";
	  int count = 0;
	  int size = 0;
	  Scanner sc = new Scanner(System.in);
while (choice.equals("y")) {
          try {
             System.out.print("Please enter an integer for the size of array: " );

             size = sc.nextInt();  					//可能产生 InputMismatchException异常
             int[] intArray = new int[size];		//可能产生NegativeArraySizeException异常
			 System.out.println();

             ArrayDemo.fillArray(intArray);			//调用静态方法
			 Arrays.sort(intArray);					//数组排序
			 ArrayDemo.display(intArray);			//打印结果

          }
          catch (InputMismatchException e) {		//处理InputMismatchException异常
			System.out.println("You must enter an integer for array size....");
			count++;								//允许次数加1
			sc.nextLine();							//清理扫描器
			continue;								//继续循环
		  }
		  catch (NegativeArraySizeException e) {		//处理NegativeArraySizeException异常
			System.out.println("You must enter an positive integer for array size....");
			count++;								//允许次数加1
			sc.nextLine();							//清除扫描器
			continue;								//继续循环
		  }
		  finally {        							//cont >= 3
		  if (count >= 3) {
		  		System.out.println("You’ve entered 3 times wrong entries....");
		  		System.out.println("System default array size 100 has assigned to the element…");
		  		int[] intArray = new int[100];
		  		ArrayDemo.fillArray(intArray);			//调用静态方法
				Arrays.sort(intArray);					//数组排序
				ArrayDemo.display(intArray);			//打印结果
			 	break;
		  	}
		 }
		System.out.print("Continue? (y/n): ");
		choice = sc.next();
		count = 0;								//reset count
    	}
	}
}

