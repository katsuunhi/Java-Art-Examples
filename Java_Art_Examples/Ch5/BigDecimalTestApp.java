
import java.math.*;

public class BigDecimalTestApp {
	public static void main(String[] args) {

		BigDecimal bigNumber = new BigDecimal("89.1234567890123456789");
		BigDecimal bigRate = new BigDecimal(1000);
		BigDecimal bigResult = new BigDecimal(0.0);			//����bigResult��ֵΪ0.0

		bigResult = bigNumber.multiply(bigRate);			//��bigNumber��ֵ����1000���������bigResult
		System.out.println(bigResult.toString()); 			//����System.out.println(bigResult);
															//��ʾ�����89123.4567890123456789
		double dData = bigNumber.doubleValue();				//��˫����������bigNumber��ֵ
		System.out.println("dData: " + dData);				//����� 89.12345678901235

		int iData = bigNumber.intValue();				//��˫����������bigNumber��ֵ
		System.out.println("iData: " + iData);			//����� 89
	}
}
