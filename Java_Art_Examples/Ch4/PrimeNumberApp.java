//��ѭ��������break��������������ʾ����

public class PrimeNumberApp {
    public static void main(String[] args){
      int n, x;

      for (n = 2;n <= 20; n++ ){
        for (x = 2; x < n;x++ ){
          if(n % x == 0)			//��������
            break;					//��ֹ��ѭ����������ѭ��
        }
        if(n == x)			//������
          System.out.print(n + "\t");
      }
    }
}