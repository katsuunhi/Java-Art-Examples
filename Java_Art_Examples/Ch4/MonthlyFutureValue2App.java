//Ӧ��for��Ƕ��ѭ��������Ͷ�ʻر��ʵ���ʾ����

import java.util.*;

public class MonthlyFutureValue2App {
	public static void main(String[] args) {

		String choice = "y";		//ѭ��������ʼ��

		double monthlyAmount,
			   monthlyInterestRate,
		       investReturn;

		int 	monthCount,
				monthInvested;	//Ͷ����

		Scanner sc = new Scanner(System.in);	//����Scanner����

		while (choice.equalsIgnoreCase("y")) {

			investReturn = 0.0;					 //��ʼ��
			System.out.println("���������Ͷ������(����һ����)��");
			monthInvested = sc.nextInt();					//�õ�Ͷ������
			System.out.println("���������Ͷ�ʶ");
			monthlyAmount = sc.nextDouble();
			System.out.println("������»ر���(����С��)��");
			monthlyInterestRate = sc.nextDouble();


			for(monthCount = 1; monthCount <= monthInvested; ++monthCount) {			//ѭ����ʼ
				investReturn = (investReturn + monthlyAmount) *   		//����Ͷ�ʻر���
		  				 (1 + monthlyInterestRate);

		  	} 					 										//forѭ������
			System.out.println("����Ͷ�ʻر�(��������)�� " + investReturn);

			System.out.println("����(y/n)? ");
			choice = sc.next();
		}	//whileѭ������
  	} 		//main()��������
} 			//MonthlyFutureValueApp����