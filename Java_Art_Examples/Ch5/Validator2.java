//���ö��������try-catchģʽ��֤�����쳣
import java.util.Scanner;

public class Validator2 {
	public static double validateDouble(Scanner sc, String prompt) {
		boolean isValid = false;
		double data = 0.0;
		
		while(!isValid) {
			try {
		 		System.out.print(prompt);
				if (!sc.hasNextDouble()) 
					throw new NumberFormatException();
				else {
					data = sc.nextDouble();	
					isValid = true;
				}	 
			  }		//try����
			catch (NumberFormatException e) {
				System.out.println(e);
				System.out.println("\n�������ݴ��������븡����...");
				sc.nextLine();		//���ɨ����		
			 }						//catch����
			} //whileѭ������
			return data; 
		}	//validateDouble()��������
	
	//����validateInt()����
	public static int validateInt(Scanner sc, String prompt) {
		boolean isValid = false;
		int data = 0;
		
		 while(!isValid) {
		  try {
	 		System.out.print(prompt);
			if (!sc.hasNextInt()) 
				throw new NumberFormatException();
			else {
				data = sc.nextInt();
				isValid = true;
			}			 
		  }		//try����
		catch (NumberFormatException e) {
			System.out.println("\n�������ݴ�������������ֵ...");
			sc.nextLine();		//���ɨ����		
		 }						//catch����
		} 						//whileѭ������
		return data; 
	 }	//validateInt()��������	
}			//Validator2�����
