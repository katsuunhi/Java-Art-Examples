//���Բ�ͬ���Ҹ�ʽ������

import java.util.*;
import java.text.*;

public class TestCurrencyApp {
	public static void main(String[] args) {
		//ϵͳԤ��Ļ��Ҹ�ʽ
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		String price = currency.format(1290.6051);
		System.out.println("ϵͳԤ���ʽ-price: " + price);
		
		//����ʹ����ʽ��������
		double total = 999999.999;
		price = NumberFormat.getCurrencyInstance().format(total);
		System.out.println("��ʽ��������-price: " + price);
		
		//����ָ���й����Ҹ�ʽ-�й�
		Locale locale = Locale.PRC;	//�����й���ʽ
		String money = NumberFormat.getCurrencyInstance(locale).format(12000003.45556);
		System.out.println("ָ���й����Ҹ�ʽ�� " + money); 
		
		//����ָ���й����Ҹ�ʽ-��Ԫ
		String dollars = NumberFormat.getCurrencyInstance(Locale.US).format(12000003.45556);
		System.out.println("��Ԫ��ʽ�� " + dollars); 
		
		String frances= NumberFormat.getCurrencyInstance(Locale.FRANCE).format(1234.454);
		System.out.println("���ɸ�ʽ�� " + frances ); 
/*
		locale = Locale.CANADA;
		System.out.println("Canada�� " + NumberFormat.getCurrencyInstance(locale).format(123.45));
		// $123.45
*/ 
	}
}
