//在循环中利用带有标签的continue语句查找素数的演示程序
 
public class PrimeNumber2App {
  public static void main(String[] args) {
	int n = 2;
	outerLoop:				//continue语句的标签
	while ( n <= 20) {
		for (int x = 2; x <= n -1; x++) {
			if (n % x == 0) {			//不是素数
				n++;					//更新while 循环变量	
				continue outerLoop;		//继续下一次外循环 
			}		
		}		//内循环结束
		System.out.print(n + "\t");	//打印素数
		n++;
	}	//外循环结束
  }
}
