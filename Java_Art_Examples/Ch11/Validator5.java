//���ö��������try-catchģʽ��֤�����쳣
import java.util.*;

public class Validator5 {
	public static double doubleData(Scanner sc, String prompt) {
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
		}	//doubleData()��������

	//����intData()����
	public static int intData(Scanner sc, String prompt) {
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
	 }	//intData()��������

	//����validateLetter()����
	public static String letter(Scanner sc, String prompt) {
		boolean isValid = false;
		String data = "";

		 while(!isValid) {
		  try {
	 		System.out.print(prompt);
			data = sc.nextLine();
			if (data.matches("\\s"))	//û�������������ո�
				throw new NullPointerException();
			else if (data.matches("[a-zA-Z]"))		//���÷�����֤�Ƿ���ĸ
					isValid = true;
			else 				//�Ƿ��û�������
				throw new Exception();
		  }		//try����
		catch (NullPointerException e) {
			System.out.println("\nû���������ݣ�������һ��Ӣ����ĸ...");
		 }						//catch����
		catch (Exception e) {
			System.out.println("\n�������������һ��Ӣ����ĸ...");
		 }						//catch����
		} 						//whileѭ������
		return data;
	 }	//letter()��������

	public static int intWithRange(Scanner sc, String prompt, int min, int max) {
			boolean done = false;
			int count = 0;
			int data = 0;
			while (!done) {
	          try {
	             System.out.print(prompt );
	             data = sc.nextInt();  					//���ܲ��� InputMismatchException�쳣
	             if (data < min) 							//negative array size
	               throw new IntegerOutOfRangeException("Data out of minimum "+ min + " range exception.");
	             if (data > max)
					throw new IntegerOutOfRangeException("Data out of maximum "+ max + " range exception.");
	          	 System.out.println();
				 done = true;
	       	   }
	          catch (InputMismatchException e) {			//����InputMismatchException�쳣
				System.out.println("You must enter an integer....");
				count++;								//���������1
				sc.nextLine();							//����ɨ����

				//throw e;
				continue;								//����ѭ��
			  }
			  catch (IntegerOutOfRangeException e) {		//����IntegerOutOfRangeException�쳣
				System.out.println(e);
				//throw e;

				count++;								//���������1
				sc.nextLine();							//���ɨ����
				continue;								//����ѭ��
			  }
		 	}
		   return data;
	 	}

	public static int positiveAge(Scanner sc, String prompt) {
		boolean isValid = false;
		int age = 0;

		 while(!isValid) {
		  try {
	 		System.out.print(prompt);					//may be InputMismatchException
			age = sc.nextInt();
			if (age <= 0)								//age < 0 exception
				throw new NegativeAgeException();
		  }		//try����
		catch (InputMismatchException e) {
			System.out.println("\n�����������������...");
		 }						//catch����
		catch (NegativeAgeException e) {
			System.out.println("\n�����������������������...");
		 }						//catch����
		} 						//whileѭ������
		return age;
	 }	//validateLetter()��������

}			//Validator5�����

class IntegerOutOfRangeException extends Throwable {   //���� extends Exception
	public IntegerOutOfRangeException() {}

	public IntegerOutOfRangeException(String message) {
		super(message);
	}
}

class NegativeAgeException extends Exception {			//����extends Throwable
	public NegativeAgeException()  {}
	public NegativeAgeException(String message) {
		super(message);
	}
}
