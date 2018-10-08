//����һ����ֵ��ʽ������

import java.text.*;

public class TestNumberApp {
	public static void main(String[] args) {
		//����NumberFormat���getNumberInstance()�������ָ�ʽ��
		double num = 6543.2154;
		String ns = "";
		NumberFormat number = NumberFormat.getNumberInstance();
		number.setMaximumFractionDigits(2);
		ns = number.format(num);
		System.out.println(ns);		//6,543.22
		
		//����DecimalFormat�������ֵ��ʽ��
		//0 ��ʾһλ��ֵ��������ʾ0���û����λ��
		NumberFormat formatter = new DecimalFormat("000,000");	//����һ�����󣬲��ҹ涨���ָ�ʽ
		String s = formatter.format(-1234.567);  	// ��ʾ-001235���������������룻����ʾС��;��ǧλ��ʾ����
		System.out.println(s);

		//#��ʾ�κ�λ�������û�У�����ʾ
		formatter = new DecimalFormat("#");
		s = formatter.format(-1234.567);         // -1235
		System.out.println(s);
		
		s = formatter.format(0);                 // 0
		System.out.println(s);
		
		formatter = new DecimalFormat("#00");
		s = formatter.format(0);                 // 00
		System.out.println(s);

		//.��ʾС����
	    formatter = new DecimalFormat(".00");
	    s = formatter.format(-.567);             // -.57
	    System.out.println(s);

	    formatter = new DecimalFormat("0.00");
	    s = formatter.format(-.567);             // -0.57
		System.out.println(s);

		formatter = new DecimalFormat("#.#");	//С�������#��ֻ��ʾһλ��������������
	    s = formatter.format(-1234.1450567);    // -1234.15
	    System.out.println(s);
	}
}