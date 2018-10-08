//测试不同货币格式化程序

import java.util.*;
import java.text.*;

public class TestCurrencyApp {
	public static void main(String[] args) {
		//系统预设的货币格式-美元
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		String price = currency.format(1290.6051);
		System.out.println("price: " + price);
		
		//或者使用链式方法调用
		double total = 999999.999;
		price = NumberFormat.getCurrencyInstance().format(total);
		System.out.println("price: " + price);
		
		//处理中国货币
		Locale locale = Locale.PRC;	//定义中国格式
		String money = NumberFormat.getCurrencyInstance(locale).format(12000003.45556);
		System.out.println("中国货币格式： " + money); 
		
		
/*
		    locale = Locale.CANADA;
		    string = NumberFormat.getCurrencyInstance(locale).format(123.45);
		    // $123.45
*/ 
	}
}

