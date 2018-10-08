//���Բ�ͬ�ٷֱȸ�ʽ������

import java.util.*;
import java.text.*;

public class TestPercentApp {
	public static void main(String[] args) {
		//ϵͳԤ��İٷֱȸ�ʽ
		NumberFormat percent = NumberFormat.getPercentInstance();
		String rate = percent.format(0.0756);
		System.out.println("ϵͳԤ���ʽ-rate: " + rate);
		
		rate = percent.format(0.0651);
		System.out.println("ϵͳԤ���ʽ percent of 0.0651: " + rate);
		
		rate = percent.format(0.0650);
		System.out.println("ϵͳԤ���ʽ percent of 0.0650: " + rate);
		
		//����ʹ����ʽ��������
		double interest = 0.065;
		rate = NumberFormat.getPercentInstance().format(interest);
		System.out.println("��ʽ��������-rate: " + rate);
		
		rate = NumberFormat.getPercentInstance().format(0.065001);
		System.out.println("rate3: " + rate);
		rate = NumberFormat.getPercentInstance().format(0.075);
		System.out.println("rate4: " + rate);
		
		NumberFormat percent2 = NumberFormat.getPercentInstance();
		percent2.setMinimumFractionDigits(4);		//���ٱ���4λС��
		String rate3 = percent2.format(.0650);
		String rate4 = percent2.format(0.075);
		System.out.println("rate3 = " + rate3 + "\trate4 = " + rate4);
		
		//������ٷֱȸ�ʽ
		NumberFormat percent3 = NumberFormat.getPercentInstance(Locale.ITALY);
		percent3.setMaximumFractionDigits(4);		//���ٱ���4λС��
		String rate2 = percent3.format(0.07551008);
		System.out.println("������ٷֱȸ�ʽ: " + rate2);	
	}
}
