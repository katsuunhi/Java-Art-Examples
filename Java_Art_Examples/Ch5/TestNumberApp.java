//测试一般数值格式化程序

import java.text.*;

public class TestNumberApp {
	public static void main(String[] args) {
		//利用NumberFormat类的getNumberInstance()进行数字格式化
		double num = 6543.2154;
		String ns = "";
		NumberFormat number = NumberFormat.getNumberInstance();
		number.setMaximumFractionDigits(2);
		ns = number.format(num);
		System.out.println(ns);		//6,543.22
		
		//利用DecimalFormat类进行数值格式化
		//0 表示一位数值；或者显示0如果没有这位数
		NumberFormat formatter = new DecimalFormat("000,000");	//创建一个对象，并且规定数字格式
		String s = formatter.format(-1234.567);  	// 显示-001235。不进行四舍五入；不显示小数;在千位显示逗号
		System.out.println(s);

		//#表示任何位数，如果没有，则不显示
		formatter = new DecimalFormat("#");
		s = formatter.format(-1234.567);         // -1235
		System.out.println(s);
		
		s = formatter.format(0);                 // 0
		System.out.println(s);
		
		formatter = new DecimalFormat("#00");
		s = formatter.format(0);                 // 00
		System.out.println(s);

		//.表示小数点
	    formatter = new DecimalFormat(".00");
	    s = formatter.format(-.567);             // -.57
	    System.out.println(s);

	    formatter = new DecimalFormat("0.00");
	    s = formatter.format(-.567);             // -0.57
		System.out.println(s);

		formatter = new DecimalFormat("#.#");	//小数点后用#，只显示一位，并且四舍五入
	    s = formatter.format(-1234.1450567);    // -1234.15
	    System.out.println(s);
	}
}