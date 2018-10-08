//����ר����Ƶ����try-catchģʽ��֤���鳤�������쳣
import java.util.*;

public class Validator4 {
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

	public static int arraySize(Scanner sc, String prompt) {
			boolean done = false;
			int count = 0;
			int size = 0;
			while (!done) {
	          try {
	             System.out.print(prompt );
	             size = sc.nextInt();  					//���ܲ��� InputMismatchException�쳣
	             if (size < 0) 							//negative array size
		           throw new NegativeArraySizeException();  //��֤���鳤��Ϊ�������������׳��쳣

	          	 System.out.println();
				 done = true;
	       	   }
	          catch (InputMismatchException e) {			//����InputMismatchException�쳣
				System.out.println("You must enter an integer for array size....");
				count++;								//���������1
				sc.nextLine();							//����ɨ����
				continue;								//����ѭ��
			  }
			  catch (NegativeArraySizeException e) {		//����NegativeArraySizeException�쳣
				System.out.println("You must enter an positive integer for array size....");
				count++;								//���������1
				sc.nextLine();							//���ɨ����
				continue;								//����ѭ��
			  }
			  finally { 	//count >= 3
				if (count >= 3) {
					System.out.println("You��ve entered 3 times wrong entries....");
					System.out.println("System default array size 100 has assigned to the element��");
					size = 100;
					break;
	 			}
			  }
		 	}
		   return size;
	 	}
}			//Validator4�����
