
//���� switch���ĳ���

import java.util.Scanner;	//ʹ��API��Scanner�� 		

public class SwitchTestApp {
  public static void main(String[] args) {

	 int dayOfWeek;					//������ʼ��
	 String day ="", choice = "y";

	 Scanner sc = new Scanner(System.in);

	 while (choice.equalsIgnoreCase("y")) {
		 System.out.print("Please enter a number (1 to 7): ");
		 dayOfWeek = sc.nextInt();
		 System.out.println();

	     switch(dayOfWeek) {	//����һ��2����
	 		case 2:
	 		case 3:
	 		case 4:
	 		case 5:
	 		case 6:		day = "������";
	 					break;
	 		case 1:
	 		case 7:		day = "��ĩ��Ϣ";
	 	}
	    System.out.println("��������" + day);

		System.out.print("������y/n��? ");
		choice = sc.next();

		System.out.println();
	} 	//whileѭ������
 }
}