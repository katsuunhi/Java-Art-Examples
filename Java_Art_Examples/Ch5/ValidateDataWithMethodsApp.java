//应用方法验证输入数据的演示程序

import java.util.*;

public class ValidateDataWithMethodsApp {
	public static void main(String[] args) {
		double price,
			   total;

		int 	quantity;	
		
		Scanner sc = new Scanner(System.in);	//建立Scanner对象
		
		price = validateDouble(sc, "请输入价格：");
		quantity = validateInt(sc, "请输入数量：");
		
		total = price * quantity;
		System.out.println("总金额：" + total);
  	} 		//main()方法结束
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
				System.out.println("\n输入数据错误！请输入正确值...");
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
			else  //非法输入
				System.out.println("\n输入数据错误！请输入正确值...");
			sc.nextLine();		//清除扫描器		
				
			} //while循环结束
			return data; 
		}	//validateInt()方法结束
} 			//ValidateDataApp结束