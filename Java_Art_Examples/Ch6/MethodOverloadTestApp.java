//����MethodOverload�����������

import java.util.*;

public class MethodOverloadTestApp {
	public static void main(String[] args) {

 	MethodOverloadTest test = new MethodOverloadTest();	//��������

 	test.printFormattedCurrency(19.722345);				//����һ�������ķ���

 	test.printFormattedCurrency(19.722345, Locale.US);	//�������������ķ���

 	test.printFormattedCurrency(19.722345, Locale.FRANCE, 4);	//�������������ķ���


	}
}

