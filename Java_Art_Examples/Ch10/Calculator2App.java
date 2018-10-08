
//Calculator driver class to compute simple expressions

import javax.swing.*;

public class Calculator2App {
   public static void main( String args[] ) {
	   Calculator2 calculator = new Calculator2();	//��������
		String choice = "y";

		while (choice.equalsIgnoreCase("y")) {
			   try {								//����ת���쳣����
		   			calculator.requestInput();		//�����û�����
		   			calculator.parseExpression();		//�ֽ�ת�����ʽ
		   			JOptionPane.showMessageDialog(null, calculator);	//��ӡ���
				}
				catch (NumberFormatException e) {
					System.out.println("The expression is wrong...\nPlease try again.");
			  	}
			choice = JOptionPane.showInputDialog("Do you want to continue(y/n)? ");
		}
	}
}

