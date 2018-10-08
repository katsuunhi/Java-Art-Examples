//Ӧ�ù��������ء���̬���ݺ;�̬�����Լ������Ľ����Ͷ�ʻر���������

import java.util.*;

public class FutureValueApp {
public static void main(String[] args) {

		String choice = "y",		//ѭ��������ʼ��
			   userName;
		double monthlyInvestment,
		       yearlyReturnRate;
		int    investYears;
		final int minYear = 1,
				  maxYears = 150;

	Scanner sc = new Scanner(System.in);

	//���ù��������ش�����ͬ���û����������䷽��
	FutureValue noNameFutureValue = new FutureValue();
		noNameFutureValue.futureValueCompute();
	FutureValue noInvestFutureValue = new FutureValue("John");
		noInvestFutureValue.futureValueCompute();
	FutureValue noRateFutureValue = new FutureValue("Wang", 1000);
		noRateFutureValue.futureValueCompute();
	FutureValue noYearsFutureValue = new FutureValue("Liu", 2000, 9.85);
		noYearsFutureValue.futureValueCompute();
	FutureValue myFutureValue = new FutureValue("Gao", 1590, 10.28, 25);
		myFutureValue.futureValueCompute();

	//���þ�̬���������ʽ����Ϣ
	System.out.println(FutureValue.getFormattedMessage(noNameFutureValue));
	System.out.println(FutureValue.getFormattedMessage(noInvestFutureValue));
	System.out.println(FutureValue.getFormattedMessage(noRateFutureValue));
	System.out.println(FutureValue.getFormattedMessage(noYearsFutureValue));
	System.out.println(FutureValue.getFormattedMessage(myFutureValue));


	while(choice.equalsIgnoreCase("y")) {

		FutureValue futureValue = new FutureValue();

		System.out.print("�������û�����");
		userName = sc.next();
		futureValue.setName(userName);				//�����û���
		sc.nextLine();

		monthlyInvestment = Validator3.validateDouble(sc, "��������Ͷ�ʶ");
		futureValue.setMonthlyInvest(monthlyInvestment);		//������Ͷ�ʶ�

		yearlyReturnRate = Validator3.validateDouble(sc, "��������ر��ʣ��ٷ�������");
		futureValue.setYearlyRate(yearlyReturnRate);			//������Ͷ����

		investYears = Validator3.validateInt(sc, "������Ͷ���꣺", minYear, maxYears);
		futureValue.setYears(investYears);				//����Ͷ����

		futureValue.futureValueCompute();

		//������ʾ��ʽ��
		System.out.println(FutureValue.getFormattedMessage(futureValue));

		System.out.println("����?(y/n): ");
		choice = sc.next();	//�Ƿ������
		sc.nextLine();		//
 	} //whileѭ���������ɨ����

 	System.out.println("�������� " + FutureValue.getCount() + "�û�.\n\n" ); //���þ�̬����

 	System.out.println("��ӭʹ�ü���Ͷ�ʻر������ټ���");
  } //main()��������
} //������FutureValueApp����