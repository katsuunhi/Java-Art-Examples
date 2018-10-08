
//Calculator driver class to compute simple expressions

import javax.swing.*;

public class Calculator2App {
   public static void main( String args[] ) {
	   Calculator2 calculator = new Calculator2();	//创建对象
		String choice = "y";

		while (choice.equalsIgnoreCase("y")) {
			   try {								//处理转换异常错误
		   			calculator.requestInput();		//请求用户输入
		   			calculator.parseExpression();		//分解转换表达式
		   			JOptionPane.showMessageDialog(null, calculator);	//打印结果
				}
				catch (NumberFormatException e) {
					System.out.println("The expression is wrong...\nPlease try again.");
			  	}
			choice = JOptionPane.showInputDialog("Do you want to continue(y/n)? ");
		}
	}
}

