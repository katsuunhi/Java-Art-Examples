//利用独立的类和try-catch模式验证输入异常
import java.util.Scanner;

public class Validator2 {
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
}			//Validator2类结束
