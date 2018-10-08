//利用独立的类和try-catch模式验证输入异常
import java.util.*;

public class Validator5 {
	public static double doubleData(Scanner sc, String prompt) {
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
		}	//doubleData()方法结束

	//定义intData()方法
	public static int intData(Scanner sc, String prompt) {
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
	 }	//intData()方法结束

	//定义validateLetter()方法
	public static String letter(Scanner sc, String prompt) {
		boolean isValid = false;
		String data = "";

		 while(!isValid) {
		  try {
	 		System.out.print(prompt);
			data = sc.nextLine();
			if (data.matches("\\s"))	//没有输入或者输入空格
				throw new NullPointerException();
			else if (data.matches("[a-zA-Z]"))		//调用方法验证是否字母
					isValid = true;
			else 				//非法用户名输入
				throw new Exception();
		  }		//try结束
		catch (NullPointerException e) {
			System.out.println("\n没有输入数据！请输入一个英文字母...");
		 }						//catch结束
		catch (Exception e) {
			System.out.println("\n输入错误！请输入一个英文字母...");
		 }						//catch结束
		} 						//while循环结束
		return data;
	 }	//letter()方法结束

	public static int intWithRange(Scanner sc, String prompt, int min, int max) {
			boolean done = false;
			int count = 0;
			int data = 0;
			while (!done) {
	          try {
	             System.out.print(prompt );
	             data = sc.nextInt();  					//可能产生 InputMismatchException异常
	             if (data < min) 							//negative array size
	               throw new IntegerOutOfRangeException("Data out of minimum "+ min + " range exception.");
	             if (data > max)
					throw new IntegerOutOfRangeException("Data out of maximum "+ max + " range exception.");
	          	 System.out.println();
				 done = true;
	       	   }
	          catch (InputMismatchException e) {			//处理InputMismatchException异常
				System.out.println("You must enter an integer....");
				count++;								//允许次数加1
				sc.nextLine();							//清理扫描器

				//throw e;
				continue;								//继续循环
			  }
			  catch (IntegerOutOfRangeException e) {		//处理IntegerOutOfRangeException异常
				System.out.println(e);
				//throw e;

				count++;								//允许次数加1
				sc.nextLine();							//清除扫描器
				continue;								//继续循环
			  }
		 	}
		   return data;
	 	}

	public static int positiveAge(Scanner sc, String prompt) {
		boolean isValid = false;
		int age = 0;

		 while(!isValid) {
		  try {
	 		System.out.print(prompt);					//may be InputMismatchException
			age = sc.nextInt();
			if (age <= 0)								//age < 0 exception
				throw new NegativeAgeException();
		  }		//try结束
		catch (InputMismatchException e) {
			System.out.println("\n输入错误！请输入年龄...");
		 }						//catch结束
		catch (NegativeAgeException e) {
			System.out.println("\n年龄输入错误！请输入正整数...");
		 }						//catch结束
		} 						//while循环结束
		return age;
	 }	//validateLetter()方法结束

}			//Validator5类结束

class IntegerOutOfRangeException extends Throwable {   //或者 extends Exception
	public IntegerOutOfRangeException() {}

	public IntegerOutOfRangeException(String message) {
		super(message);
	}
}

class NegativeAgeException extends Exception {			//或者extends Throwable
	public NegativeAgeException()  {}
	public NegativeAgeException(String message) {
		super(message);
	}
}
