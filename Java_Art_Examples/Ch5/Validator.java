//利用独立的类和静态方法验证输入数据的合法性
import java.util.Scanner;

public class Validator {
	public static double validateDouble(Scanner sc, String prompt) {
		boolean isValid = false;
		double data = 0.0;
		
		while(!isValid) {
			System.out.print(prompt);
			if (sc.hasNextDouble()) {
				data = sc.nextDouble();
				isValid = true;
			}
			else  //非法输入
				System.out.println("\n输入数据错误！请输入浮点数...");
			sc.nextLine();		//清除扫描器		
				
			} //while循环结束
			return data; 
		}	//validateDouble()方法结束
	
	//定义validateInt()方法
	public static int validateInt(Scanner sc, String prompt) {
		boolean isValid = false;
		int data = 0;
		
		 while(!isValid) {
		   
	 		System.out.print(prompt);
			if (sc.hasNextInt()) {
				data = sc.nextInt();
				isValid = true;
			 }		
			else {
				System.out.println("\n输入数据错误！请输入整数值...");
				sc.nextLine();		//清除扫描器		
		     }		 
		 } 						//while循环结束
		return data; 
	 }	//validateInt()方法结束
}			//Validator类结束
