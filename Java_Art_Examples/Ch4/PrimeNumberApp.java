//在循环中利用break语句查找素数的演示程序

public class PrimeNumberApp {
    public static void main(String[] args){
      int n, x;

      for (n = 2;n <= 20; n++ ){
        for (x = 2; x < n;x++ ){
          if(n % x == 0)			//不是素数
            break;					//终止内循环，继续外循环
        }
        if(n == x)			//是素数
          System.out.print(n + "\t");
      }
    }
}