//Ͷ�ʻر���������

import javax.swing.JOptionPane;

public class FutureValue2App {
public static void main(String[] args) {

		String choice = "y",		//ѭ��������ʼ��
			   str,
			   userName;
	FutureValue2 futureValue = new FutureValue2();  //����FutureValue2����
	while(choice.equalsIgnoreCase("y")) {

		userName = JOptionPane.showInputDialog("Welcome to future value application!\n\n"
					 + "please enter your name: ");

		futureValue.setName(userName);				//�����û���


		str = JOptionPane.showInputDialog("enter your monthly invest: ");
		futureValue.setMonthlyInvest(Double.parseDouble(str));		//������Ͷ�ʶ�

		str = JOptionPane.showInputDialog("enter yearly return rate: ");
		futureValue.setYearlyRate(Double.parseDouble(str));			//������Ͷ����

		str = JOptionPane.showInputDialog("enter number of years: ");
		futureValue.setYears(Integer.parseInt(str));				//����Ͷ����

		futureValue.futureValueCompute();

		JOptionPane.showMessageDialog(null, "Your future return is: "
									  + futureValue.getFutureValue());

		choice = JOptionPane.showInputDialog("continue? (y/n): ");	//�Ƿ������
 	} //whileѭ������

 	JOptionPane.showMessageDialog(null, "Thank you for using future value application.");
  } //main()��������
} //������FutureValue2App����