//break�����˫ѭ���е���ʾ����

public class BreakTestApp {
  public static void main(String[] args) {

    int result, num = 1;
	for (int count = 1; count <= 4; count++) {
	  System.out.println("��ѭ��: " + count);

	  while ( true ) {
		result = count * num;
		System.out.print("\t\t��ѭ��: " + result);

		if (num % 3 == 0) {
			System.out.println();
			break;				//��ֹ��ѭ��������һ����ѭ����ʼ
		}	
		num++;
	 }
   }
 }
}