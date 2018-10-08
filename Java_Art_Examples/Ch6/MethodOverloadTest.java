//应用方法重载的演示程序

import java.util.*;

import java.text.*;

public class MethodOverloadTest {

	//利用系统预设的货币格式
	public void printFormattedCurrency(double amount) {
		String out = NumberFormat.getCurrencyInstance().format(amount);
		System.out.println("系统预设货币格式： " + out);
	}

	//利用用户定义的货币格式
	public void printFormattedCurrency(double amount, Locale locale) {
		String out = NumberFormat.getCurrencyInstance(locale).format(amount);
		System.out.println("用户定义本地" + locale + "格式：" + out);
	}

	//利用用户定义的货币和小数点格式
	public void printFormattedCurrency(double amount, Locale locale, int decimal) {

		NumberFormat currency = NumberFormat.getCurrencyInstance(locale);
		currency.setMinimumFractionDigits(decimal);
		String out = currency.format(amount);
		System.out.println("用户定义本地" + locale + "格式和"+ decimal + "位小数点：" + out);
	}
}