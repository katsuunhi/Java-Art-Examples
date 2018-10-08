//���ö��������try-catchģʽ��֤������Χ���ڵ������쳣
import java.util.Scanner;

public class Validator3 {
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
					if (inRange(data))			//����ȷ��Χ
						isValid = true;
					else 
						throw new Exception();
				}			 
			  }		//try����
			catch (NumberFormatException e) {
				System.out.println("\n�������ݴ��������븡����...");
				sc.nextLine();		//���ɨ����		
			 }						//catch����
			catch (Exception e) {
				System.out.println("\n�������ݴ�������������...");
				sc.nextLine();		//���ɨ����		
			 }						//catch����
			} //whileѭ������
			return data; 
		}	//validateDouble()��������
	
	//����validateInt()����
	public static int validateInt(Scanner sc, String prompt, int min, int max) {
		boolean isValid = false;
		int data = 0;
		
		 while(!isValid) {
		  try {
	 		System.out.print(prompt);
			if (!sc.hasNextInt()) 
				throw new NumberFormatException();
			else {
				data = sc.nextInt();
				if (data < min) 				//������С��Χ
					throw new Exception();		//�׳��쳣
				else if (data > max) 			//�������Χ
					throw new Exception();		//�׳��쳣
				isValid = true;
			}			 
		  }		//try����
		catch (NumberFormatException e) {
			System.out.println("\n�������ݴ�������������ֵ...");
			sc.nextLine();		//���ɨ����		
		 }						//catch����
		catch (Exception e) {
			System.out.println("\n�������ݳ�����Χ������������ȷ��ֵ...");
			sc.nextLine();		//���ɨ����		
		 }						//catch����
		} 						//whileѭ������
		return data; 
	 }	//validateInt()��������
	
	private static boolean inRange(double num) {
		if (num >=0.0)
			return true;
		else
			return false;
	}
	
}			//Validator3�����
