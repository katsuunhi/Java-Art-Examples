//���ö�������;�̬������֤�������ݵĺϷ���
import java.util.Scanner;

public class Validator {
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
				System.out.println("\n�������ݴ��������븡����...");
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
			else {
				System.out.println("\n�������ݴ�������������ֵ...");
				sc.nextLine();		//���ɨ����		
		     }		 
		 } 						//whileѭ������
		return data; 
	 }	//validateInt()��������
}			//Validator�����
