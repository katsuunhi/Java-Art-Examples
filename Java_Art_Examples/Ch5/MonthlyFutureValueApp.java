//Ӧ��do-while��Ƕ��ѭ��������Ͷ�ʻر��ʵ���ʾ����

import java.util.*;

public class MonthlyFutureValueApp {
	public static void main(String[] args) {

		String choice = "y";		//ѭ��������ʼ��

		double monthlyAmount,
			   monthlyInterestRate,
		       investReturn;

		int 	monthCount,
				monthInvested;	//Ͷ����

		Scanner sc = new Scanner(System.in);	//����Scanner����

		while (choice.equalsIgnoreCase("y")) {

			monthCount = 1;						 //��СͶ���ڼ�Ϊһ����
			investReturn = 0.0;					 //��ʼ��
			System.out.println("���������Ͷ������(����һ����)��");
			monthInvested = sc.nextInt();					//�õ�Ͷ������
			System.out.println("���������Ͷ�ʶ");
			monthlyAmount = sc.nextDouble();
			System.out.println("������»ر���(����С��)��");
			monthlyInterestRate = sc.nextDouble();


			do {			//ѭ����ʼ
				investReturn = (investReturn + monthlyAmount) *   		//����Ͷ�ʻر���
		  				 (1 + monthlyInterestRate);
				++monthCount;					 						//ѭ����������, ��������1
		  	} while (monthCount <= monthInvested)	;					//����ѭ������
			System.out.println("����Ͷ�ʻر�(��������)�� " + investReturn);

			System.out.println("����(y/n)? ");
			choice = sc.next();
		}		//whileѭ������
  	} 		//main()��������
} 			//MonthlyFutureValueApp����