
import java.math.*;

public class BigDecimalTestApp {
	public static void main(String[] args) {

		BigDecimal bigNumber = new BigDecimal("89.1234567890123456789");
		BigDecimal bigRate = new BigDecimal(1000);
		BigDecimal bigResult = new BigDecimal(0.0);			//对象bigResult的值为0.0

		bigResult = bigNumber.multiply(bigRate);			//对bigNumber的值乘以1000，结果赋予bigResult
		System.out.println(bigResult.toString()); 			//或者System.out.println(bigResult);
															//显示结果：89123.4567890123456789
		double dData = bigNumber.doubleValue();				//以双精度数返回bigNumber的值
		System.out.println("dData: " + dData);				//结果： 89.12345678901235

		int iData = bigNumber.intValue();				//以双精度数返回bigNumber的值
		System.out.println("iData: " + iData);			//结果： 89
	}
}
