//���Բ�ͬ���Ҹ�ʽ������

import java.util.*;
import java.text.*;

public class TestCurrencyApp {
	public static void main(String[] args) {
		//ϵͳԤ��Ļ��Ҹ�ʽ-��Ԫ
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		String price = currency.format(1290.6051);
		System.out.println("price: " + price);
		
		//����ʹ����ʽ��������
		double total = 999999.999;
		price = NumberFormat.getCurrencyInstance().format(total);
		System.out.println("price: " + price);
		
		//�����й�����
		Locale locale = Locale.PRC;	//�����й���ʽ
		String money = NumberFormat.getCurrencyInstance(locale).format(12000003.45556);
		System.out.println("�й����Ҹ�ʽ�� " + money); 
		
		
/*
		    locale = Locale.CANADA;
		    string = NumberFormat.getCurrencyInstance(locale).format(123.45);
		    // $123.45
*/ 
	}
}

