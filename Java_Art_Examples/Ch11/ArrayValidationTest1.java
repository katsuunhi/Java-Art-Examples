//Demo:  exception handling in array uses

import java.util.*;

public class ArrayValidationTest1 {
  public static void main(String[] args) {

	  String choice = "y";
	  int count = 0;
	  int size = 0;

	  Scanner sc = new Scanner(System.in);

while (choice.equals("y")) {
          try {
             System.out.print("Please enter an integer for the size of array: " );

             size = sc.nextInt();  					//���ܲ��� InputMismatchException�쳣
             int[] intArray = new int[size];		//���ܲ���NegativeArraySizeException�쳣
			 System.out.println();

             ArrayDemo.fillArray(intArray);			//���þ�̬����
			 Arrays.sort(intArray);					//��������
			 ArrayDemo.display(intArray);			//��ӡ���
          }
          catch (InputMismatchException e) {		//����InputMismatchException�쳣
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
				System.out.println("The application is terminated now due to 3 times wrong entries....");
				System.out.println("Review your entries and try run the program again. Bye!");
		    	break;							//���ߣ�System.exit(0);  �ն�ѭ����ֹͣ��������
 			}
		  }

		System.out.print("Continue? (y/n): ");
		choice = sc.next();
    	}
	}
}
