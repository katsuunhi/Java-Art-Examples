//Calculator class for simple expression computing
import javax.swing.JOptionPane;

public class Calculator {
		private String expression;
		private char operator;
		private double operandValue,
			        currentTotal;
        public Calculator() {			//构造器对数据初始化
			expression = null;
			operator = ' ';
			operandValue = 0.0;
        	currentTotal = 0.0;
        }
        public void requestInput() {  	//得到用户输入的计算表达式字符串
        	expression = JOptionPane.showInputDialog("Please enter your expression: ");
		}
		public void parseExpression() {	//分解这个字符串成为操作数和操作符
			//char[] operators = new char[1];
			String[] expressions = expression.split(" ");	//调用split()方法用空格进行分解
		     		currentTotal = Double.parseDouble(expressions[0]); //第一个操作数
		     		for(int i = 1; i < expressions.length; i += 2) {		//依次得到其余操作符和操作数
		       			//operators = expressions[i].toCharArray();	//以字符数组得到操作符
		       			operator = expressions[i].charAt(0);		//转换成字符以便使用switch-case
		       			operandValue = Double.parseDouble(expressions[i+1]); //得到下一个操作数
						compute();			//调用计算
					}
		}
		public void compute() {		//进行运算
			switch (operator) {
				case '+':  currentTotal += operandValue;
					   	   break;
				case '-':  currentTotal -= operandValue;
				   	       break;
				case '*':  currentTotal *= operandValue;
					       break;
				case '/':  currentTotal /= operandValue;
				           break;
				default:   System.out.println("wrong operator...");	//不在运算操作符之内
						   break;
				}
		}
		public String toString() {		//返回表达式和运算结果信息
		 	return expression + "\nThe total after the calculation: " + currentTotal;
		}
}
