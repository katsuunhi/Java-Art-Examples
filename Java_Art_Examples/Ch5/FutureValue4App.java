//���쳣��������֤�û��������ݺ͸�ʽ�������Ͷ�ʻر���������

import java.util.*;
import java.text.*;

public class FutureValue4App {
public static void main(String[] args) {

		String choice = "y",		//ѭ��������ʼ��
			   userName;
		double monthlyInvestment,
		       yearlyReturnRate;
		int    investYears;
		final int minYear = 1,
				  maxYears = 150;
		//�������ݸ�ʽ��
		String 	rateStr = "",
				investStr = "",
				futureValueStr = "";
		
		
	Scanner sc = new Scanner(System.in);	
	FutureValue3 futureValue = new FutureValue3();  //����FutureValue3����
	
	while(choice.equalsIgnoreCase("y")) {

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
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		investStr = currency.format(futureValue.getMonthlyInvest());
		futureValueStr = currency.format(futureValue.getFutureValue());
		
		//�ٷֱȸ�ʽ�������ٱ���С������λ
		NumberFormat percent = NumberFormat.getPercentInstance();
		percent.setMinimumFractionDigits(2);			
		rateStr = percent.format(futureValue.getYealyRate()/100);
		
		System.out.println("����������" + futureValue.getName());
		System.out.println("������Ͷ�ʶ�Ϊ��" + investStr);
		System.out.println("������ر���Ϊ��" + rateStr);
		System.out.println("����Ͷ����Ϊ��" + futureValue.getYears());
		System.out.println("����Ͷ�ʻر�Ϊ��" + futureValueStr);
		System.out.println("����?(y/n): ");

		choice = sc.next();	//�Ƿ������
		sc.nextLine();		//
 	} //whileѭ���������ɨ����

 	System.out.println("��ӭʹ�ü���Ͷ�ʻر������ټ���"); 
  } //main()��������
} //������FutureValue3App����