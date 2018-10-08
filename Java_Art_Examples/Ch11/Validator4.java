//利用专门设计的类和try-catch模式验证数组长度输入异常
import java.util.*;

public class Validator4 {
	public static double validateDouble(Scanner sc, String prompt) {
		boolean isValid = false;
		double data = 0.0;

		while(!isValid) {
			try {
		 		System.out.print(prompt);
				if (!sc.hasNextDouble())
					throw new NumberFormatException();
				else {
					data = sc.nextDouble();
					isValid = true;
				}
			  }		//try结束
			catch (NumberFormatException e) {
				System.out.println(e);
				System.out.println("\n输入数据错误！请输入浮点数...");
				sc.nextLine();		//清除扫描器
			 }						//catch结束
			} //while循环结束
			return data;
		}	//validateDouble()方法结束

	//定义validateInt()方法
	public static int validateInt(Scanner sc, String prompt) {
		boolean isValid = false;
		int data = 0;

		 while(!isValid) {
		  try {
	 		System.out.print(prompt);
			if (!sc.hasNextInt())
				throw new NumberFormatException();
			else {
				data = sc.nextInt();
				isValid = true;
			}
		  }		//try结束
		catch (NumberFormatException e) {
			System.out.println("\n输入数据错误！请输入整数值...");
			sc.nextLine();		//清除扫描器
		 }						//catch结束
		} 						//while循环结束
		return data;
	 }	//validateInt()方法结束

	public static int arraySize(Scanner sc, String prompt) {
			boolean done = false;
			int count = 0;
			int size = 0;
			while (!done) {
	          try {
	             System.out.print(prompt );
	             size = sc.nextInt();  					//可能产生 InputMismatchException异常
	             if (size < 0) 							//negative array size
		           throw new NegativeArraySizeException();  //保证数组长度为正整数；否则抛出异常

	          	 System.out.println();
				 done = true;
	       	   }
	          catch (InputMismatchException e) {			//处理InputMismatchException异常
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
			  finally { 	//count >= 3
				if (count >= 3) {
					System.out.println("You’ve entered 3 times wrong entries....");
					System.out.println("System default array size 100 has assigned to the element…");
					size = 100;
					break;
	 			}
			  }
		 	}
		   return size;
	 	}
}			//Validator4类结束
