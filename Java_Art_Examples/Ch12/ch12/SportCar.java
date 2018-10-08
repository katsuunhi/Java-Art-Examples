package ch12;

import static ch12.SportCarType.*;  	//静态引入
import java.text.DecimalFormat;     	//格式化输出

class SportCar {

	SportCarType type;					//定义枚举类型

	public SportCar (String choice) {  	//构造器根据选择对跑车类型初始化

		if (choice.equals("P"))
			type = PORSCHE;
		else if (choice.equals("F"))
		   type = FERRARI;
		else if(choice.equals("J"))
		   type = JAGUAR;
	   }
	public String toString() {			//覆盖toString()返回跑车信息
		DecimalFormat dollar = new DecimalFormat("#,##0.00");  //格式化输出

		String info = type.getMake() + "\n价格：$" + dollar.format(type.getPrice());
		return info;
	}
}
