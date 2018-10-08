//应用构造器重载、静态数据和静态方法以及其它改进后的投资回报驱动程序

import java.util.*;

public class FutureValueApp {
public static void main(String[] args) {

		String choice = "y",		//循环变量初始化
			   userName;
		double monthlyInvestment,
		       yearlyReturnRate;
		int    investYears;
		final int minYear = 1,
				  maxYears = 150;

	Scanner sc = new Scanner(System.in);

	//利用构造器重载创建不同的用户，并调用其方法
	FutureValue noNameFutureValue = new FutureValue();
		noNameFutureValue.futureValueCompute();
	FutureValue noInvestFutureValue = new FutureValue("John");
		noInvestFutureValue.futureValueCompute();
	FutureValue noRateFutureValue = new FutureValue("Wang", 1000);
		noRateFutureValue.futureValueCompute();
	FutureValue noYearsFutureValue = new FutureValue("Liu", 2000, 9.85);
		noYearsFutureValue.futureValueCompute();
	FutureValue myFutureValue = new FutureValue("Gao", 1590, 10.28, 25);
		myFutureValue.futureValueCompute();

	//调用静态方法输出格式化信息
	System.out.println(FutureValue.getFormattedMessage(noNameFutureValue));
	System.out.println(FutureValue.getFormattedMessage(noInvestFutureValue));
	System.out.println(FutureValue.getFormattedMessage(noRateFutureValue));
	System.out.println(FutureValue.getFormattedMessage(noYearsFutureValue));
	System.out.println(FutureValue.getFormattedMessage(myFutureValue));


	while(choice.equalsIgnoreCase("y")) {

		FutureValue futureValue = new FutureValue();

		System.out.print("请输入用户名：");
		userName = sc.next();
		futureValue.setName(userName);				//建立用户名
		sc.nextLine();

		monthlyInvestment = Validator3.validateDouble(sc, "请输入月投资额：");
		futureValue.setMonthlyInvest(monthlyInvestment);		//建立月投资额

		yearlyReturnRate = Validator3.validateDouble(sc, "请输入年回报率（百分数）：");
		futureValue.setYearlyRate(yearlyReturnRate);			//建立年投资率

		investYears = Validator3.validateInt(sc, "请输入投资年：", minYear, maxYears);
		futureValue.setYears(investYears);				//建立投资年

		futureValue.futureValueCompute();

		//货币显示格式化
		System.out.println(FutureValue.getFormattedMessage(futureValue));

		System.out.println("继续?(y/n): ");
		choice = sc.next();	//是否继续？
		sc.nextLine();		//
 	} //while循环结束清除扫描器

 	System.out.println("共创建了 " + FutureValue.getCount() + "用户.\n\n" ); //调用静态方法

 	System.out.println("欢迎使用计算投资回报程序，再见！");
  } //main()方法结束
} //驱动类FutureValueApp结束