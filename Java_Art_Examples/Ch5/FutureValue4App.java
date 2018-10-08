//有异常处理功能验证用户输入数据和格式化输出的投资回报驱动程序

import java.util.*;
import java.text.*;

public class FutureValue4App {
public static void main(String[] args) {

		String choice = "y",		//循环变量初始化
			   userName;
		double monthlyInvestment,
		       yearlyReturnRate;
		int    investYears;
		final int minYear = 1,
				  maxYears = 150;
		//用来数据格式化
		String 	rateStr = "",
				investStr = "",
				futureValueStr = "";
		
		
	Scanner sc = new Scanner(System.in);	
	FutureValue3 futureValue = new FutureValue3();  //创建FutureValue3对象
	
	while(choice.equalsIgnoreCase("y")) {

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
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		investStr = currency.format(futureValue.getMonthlyInvest());
		futureValueStr = currency.format(futureValue.getFutureValue());
		
		//百分比格式化，至少保留小数点两位
		NumberFormat percent = NumberFormat.getPercentInstance();
		percent.setMinimumFractionDigits(2);			
		rateStr = percent.format(futureValue.getYealyRate()/100);
		
		System.out.println("您的姓名：" + futureValue.getName());
		System.out.println("您的月投资额为：" + investStr);
		System.out.println("您的年回报率为：" + rateStr);
		System.out.println("您的投资年为：" + futureValue.getYears());
		System.out.println("您的投资回报为：" + futureValueStr);
		System.out.println("继续?(y/n): ");

		choice = sc.next();	//是否继续？
		sc.nextLine();		//
 	} //while循环结束清除扫描器

 	System.out.println("欢迎使用计算投资回报程序，再见！"); 
  } //main()方法结束
} //驱动类FutureValue3App结束