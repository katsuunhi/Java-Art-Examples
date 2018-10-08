//测试不同货币格式化程序

import java.util.*;
import java.text.*;

public class TestCurrencyApp {
	public static void main(String[] args) {
		//系统预设的货币格式
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		String price = currency.format(1290.6051);
		System.out.println("系统预设格式-price: " + price);
		
		//或者使用链式方法调用
		double total = 999999.999;
		price = NumberFormat.getCurrencyInstance().format(total);
		System.out.println("链式方法调用-price: " + price);
		
		//处理指定中国货币格式-中国
		Locale locale = Locale.PRC;	//定义中国格式
		String money = NumberFormat.getCurrencyInstance(locale).format(12000003.45556);
		System.out.println("指定中国货币格式： " + money); 
		
		//处理指定中国货币格式-美元
		String dollars = NumberFormat.getCurrencyInstance(Locale.US).format(12000003.45556);
		System.out.println("美元格式： " + dollars); 
		
		String frances= NumberFormat.getCurrencyInstance(Locale.FRANCE).format(1234.454);
		System.out.println("法郎格式： " + frances ); 
/*
		locale = Locale.CANADA;
		System.out.println("Canada： " + NumberFormat.getCurrencyInstance(locale).format(123.45));
		// $123.45
*/ 
	}
}
