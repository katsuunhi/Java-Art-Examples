//Ӧ����;�̬������֤�������ݵ���ʾ����

import java.util.*;

public class ValidateDataWithClassApp {
	public static void main(String[] args) {
		double price,
			   total;

		int quantity;	
		
		Scanner sc = new Scanner(System.in);	//����Scanner����
		
		//����Validator�ľ�̬����
		price = Validator2.validateDouble(sc, "������۸�");
		quantity = Validator2.validateInt(sc, "������������");
		
		total = price * quantity;
		System.out.println("�ܽ�" + total);
  	} 		//main()��������
} 			//ValidateDataApp����