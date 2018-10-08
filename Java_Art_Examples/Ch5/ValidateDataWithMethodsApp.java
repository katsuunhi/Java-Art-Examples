//Ӧ�÷�����֤�������ݵ���ʾ����

import java.util.*;

public class ValidateDataWithMethodsApp {
	public static void main(String[] args) {
		double price,
			   total;

		int 	quantity;	
		
		Scanner sc = new Scanner(System.in);	//����Scanner����
		
		price = validateDouble(sc, "������۸�");
		quantity = validateInt(sc, "������������");
		
		total = price * quantity;
		System.out.println("�ܽ�" + total);
  	} 		//main()��������
	public static double validateDouble(Scanner sc, String prompt) {
		boolean isValid = false;
		double data = 0.0;
		
		while(!isValid) {
			System.out.print(prompt);
			if (sc.hasNextDouble()) {
				data = sc.nextDouble();
				isValid = true;
			}
			else  //�Ƿ�����
				System.out.println("\n�������ݴ�����������ȷֵ...");
			sc.nextLine();		//���ɨ����		
				
			} //whileѭ������
			return data; 
		}	//validateDouble()��������
	
	//����validateInt()����
	public static int validateInt(Scanner sc, String prompt) {
		boolean isValid = false;
		int data = 0;
		
		while(!isValid) {
	 		System.out.print(prompt);
			if (sc.hasNextInt()) {
				data = sc.nextInt();
				isValid = true;
			}
			else  //�Ƿ�����
				System.out.println("\n�������ݴ�����������ȷֵ...");
			sc.nextLine();		//���ɨ����		
				
			} //whileѭ������
			return data; 
		}	//validateInt()��������
} 			//ValidateDataApp����