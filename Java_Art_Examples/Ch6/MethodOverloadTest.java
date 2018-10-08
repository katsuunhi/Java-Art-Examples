//Ӧ�÷������ص���ʾ����

import java.util.*;

import java.text.*;

public class MethodOverloadTest {

	//����ϵͳԤ��Ļ��Ҹ�ʽ
	public void printFormattedCurrency(double amount) {
		String out = NumberFormat.getCurrencyInstance().format(amount);
		System.out.println("ϵͳԤ����Ҹ�ʽ�� " + out);
	}

	//�����û�����Ļ��Ҹ�ʽ
	public void printFormattedCurrency(double amount, Locale locale) {
		String out = NumberFormat.getCurrencyInstance(locale).format(amount);
		System.out.println("�û����屾��" + locale + "��ʽ��" + out);
	}

	//�����û�����Ļ��Һ�С�����ʽ
	public void printFormattedCurrency(double amount, Locale locale, int decimal) {

		NumberFormat currency = NumberFormat.getCurrencyInstance(locale);
		currency.setMinimumFractionDigits(decimal);
		String out = currency.format(amount);
		System.out.println("�û����屾��" + locale + "��ʽ��"+ decimal + "λС���㣺" + out);
	}
}