//应用类和静态方法验证输入数据的演示程序

import java.util.*;

public class ValidateDataWithClassApp {
	public static void main(String[] args) {
		double price,
			   total;

		int quantity;	
		
		Scanner sc = new Scanner(System.in);	//建立Scanner对象
		
		//调用Validator的静态方法
		price = Validator2.validateDouble(sc, "请输入价格：");
		quantity = Validator2.validateInt(sc, "请输入数量：");
		
		total = price * quantity;
		System.out.println("总金额：" + total);
  	} 		//main()方法结束
} 			//ValidateDataApp结束