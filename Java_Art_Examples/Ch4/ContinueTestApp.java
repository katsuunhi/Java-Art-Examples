//continue�����ʾ���㵹���ĳ���

public class ContinueTestApp {
  public static void main(String[] args) {

    for(double i = 3; i >= -3; i--) {
	   if (i == 0)
	     continue;				//����ִ����һ��ѭ��
	   System.out.println(i + " �ĵ����� " + (1 / i));
	}
 }
}