
//测试 switch语句的程序

import java.util.Scanner;	//使用API的Scanner类 		

public class SwitchTestApp {
  public static void main(String[] args) {

	 int dayOfWeek;					//变量初始化
	 String day ="", choice = "y";

	 Scanner sc = new Scanner(System.in);

	 while (choice.equalsIgnoreCase("y")) {
		 System.out.print("Please enter a number (1 to 7): ");
		 dayOfWeek = sc.nextInt();
		 System.out.println();

	     switch(dayOfWeek) {	//星期一从2算起
	 		case 2:
	 		case 3:
	 		case 4:
	 		case 5:
	 		case 6:		day = "工作日";
	 					break;
	 		case 1:
	 		case 7:		day = "周末休息";
	 	}
	    System.out.println("您现在在" + day);

		System.out.print("继续（y/n）? ");
		choice = sc.next();

		System.out.println();
	} 	//while循环结束
 }
}