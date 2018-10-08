//break语句在双循环中的演示程序

public class BreakTestApp {
  public static void main(String[] args) {

    int result, num = 1;
	for (int count = 1; count <= 4; count++) {
	  System.out.println("外循环: " + count);

	  while ( true ) {
		result = count * num;
		System.out.print("\t\t内循环: " + result);

		if (num % 3 == 0) {
			System.out.println();
			break;				//终止内循环并从下一次外循环开始
		}	
		num++;
	 }
   }
 }
}