package ch12;

import static ch12.SportCarType.*;  	//��̬����
import java.text.DecimalFormat;     	//��ʽ�����

class SportCar {

	SportCarType type;					//����ö������

	public SportCar (String choice) {  	//����������ѡ����ܳ����ͳ�ʼ��

		if (choice.equals("P"))
			type = PORSCHE;
		else if (choice.equals("F"))
		   type = FERRARI;
		else if(choice.equals("J"))
		   type = JAGUAR;
	   }
	public String toString() {			//����toString()�����ܳ���Ϣ
		DecimalFormat dollar = new DecimalFormat("#,##0.00");  //��ʽ�����

		String info = type.getMake() + "\n�۸�$" + dollar.format(type.getPrice());
		return info;
	}
}
