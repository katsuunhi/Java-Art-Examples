//continue语句演示计算倒数的程序

public class ContinueTestApp {
  public static void main(String[] args) {

    for(double i = 3; i >= -3; i--) {
	   if (i == 0)
	     continue;				//继续执行下一次循环
	   System.out.println(i + " 的倒数是 " + (1 / i));
	}
 }
}