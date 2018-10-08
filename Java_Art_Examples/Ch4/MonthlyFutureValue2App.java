//应用for和嵌套循环计算月投资回报率的演示程序

import java.util.*;

public class MonthlyFutureValue2App {
	public static void main(String[] args) {

		String choice = "y";		//循环变量初始化

		double monthlyAmount,
			   monthlyInterestRate,
		       investReturn;

		int 	monthCount,
				monthInvested;	//投资月

		Scanner sc = new Scanner(System.in);	//建立Scanner对象

		while (choice.equalsIgnoreCase("y")) {

			investReturn = 0.0;					 //初始化
			System.out.println("请打入您的投资月数(至少一个月)：");
			monthInvested = sc.nextInt();					//得到投资月数
			System.out.println("请打入您月投资额：");
			monthlyAmount = sc.nextDouble();
			System.out.println("请打入月回报率(打入小数)：");
			monthlyInterestRate = sc.nextDouble();


			for(monthCount = 1; monthCount <= monthInvested; ++monthCount) {			//循环开始
				investReturn = (investReturn + monthlyAmount) *   		//计算投资回报。
		  				 (1 + monthlyInterestRate);

		  	} 					 										//for循环结束
			System.out.println("您的投资回报(含本和利)是 " + investReturn);

			System.out.println("继续(y/n)? ");
			choice = sc.next();
		}	//while循环结束
  	} 		//main()方法结束
} 			//MonthlyFutureValueApp结束