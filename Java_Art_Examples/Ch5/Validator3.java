//利用独立的类和try-catch模式验证包括范围在内的输入异常
import java.util.Scanner;

public class Validator3 {
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
					if (inRange(data))			//在正确范围
						isValid = true;
					else 
						throw new Exception();
				}			 
			  }		//try结束
			catch (NumberFormatException e) {
				System.out.println("\n输入数据错误！请输入浮点数...");
				sc.nextLine();		//清除扫描器		
			 }						//catch结束
			catch (Exception e) {
				System.out.println("\n输入数据错误！请输入正数...");
				sc.nextLine();		//清除扫描器		
			 }						//catch结束
			} //while循环结束
			return data; 
		}	//validateDouble()方法结束
	
	//定义validateInt()方法
	public static int validateInt(Scanner sc, String prompt, int min, int max) {
		boolean isValid = false;
		int data = 0;
		
		 while(!isValid) {
		  try {
	 		System.out.print(prompt);
			if (!sc.hasNextInt()) 
				throw new NumberFormatException();
			else {
				data = sc.nextInt();
				if (data < min) 				//超出最小范围
					throw new Exception();		//抛出异常
				else if (data > max) 			//超出最大范围
					throw new Exception();		//抛出异常
				isValid = true;
			}			 
		  }		//try结束
		catch (NumberFormatException e) {
			System.out.println("\n输入数据错误！请输入整数值...");
			sc.nextLine();		//清除扫描器		
		 }						//catch结束
		catch (Exception e) {
			System.out.println("\n输入数据超出范围错误！请输入正确数值...");
			sc.nextLine();		//清除扫描器		
		 }						//catch结束
		} 						//while循环结束
		return data; 
	 }	//validateInt()方法结束
	
	private static boolean inRange(double num) {
		if (num >=0.0)
			return true;
		else
			return false;
	}
	
}			//Validator3类结束
