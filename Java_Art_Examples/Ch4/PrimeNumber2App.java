//��ѭ�������ô��б�ǩ��continue��������������ʾ����
 
public class PrimeNumber2App {
  public static void main(String[] args) {
	int n = 2;
	outerLoop:				//continue���ı�ǩ
	while ( n <= 20) {
		for (int x = 2; x <= n -1; x++) {
			if (n % x == 0) {			//��������
				n++;					//����while ѭ������	
				continue outerLoop;		//������һ����ѭ�� 
			}		
		}		//��ѭ������
		System.out.print(n + "\t");	//��ӡ����
		n++;
	}	//��ѭ������
  }
}
