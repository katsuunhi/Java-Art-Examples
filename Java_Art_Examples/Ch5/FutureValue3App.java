//���쳣��������֤�û��������ݵ�Ͷ�ʻر���������

import java.util.*;

public class FutureValue3App {
public static void main(String[] args) {

		String choice = "y",		//ѭ��������ʼ��
			   userName;
		double monthlyInvestment,
		       yearlyReturnRate;
		int    investYears;
		final int minYear = 1,
				  maxYears = 150;
		
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
		
		System.out.println("����Ͷ�ʻر�Ϊ��" + futureValue.getFutureValue());
		System.out.println("����?(y/n): ");

		choice = sc.next();	//�Ƿ������
		sc.nextLine();		//
 	} //whileѭ���������ɨ����

 	System.out.println("��ӭʹ�ü���Ͷ�ʻر������ټ���"); 
  } //main()��������
} //������FutureValue3App����