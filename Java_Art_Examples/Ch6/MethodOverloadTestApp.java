//测试MethodOverload类的驱动程序

import java.util.*;

public class MethodOverloadTestApp {
	public static void main(String[] args) {

 	MethodOverloadTest test = new MethodOverloadTest();	//创建对象

 	test.printFormattedCurrency(19.722345);				//调用一个参数的方法

 	test.printFormattedCurrency(19.722345, Locale.US);	//调用两个参数的方法

 	test.printFormattedCurrency(19.722345, Locale.FRANCE, 4);	//调用三个参数的方法


	}
}

