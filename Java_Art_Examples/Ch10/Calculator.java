//Calculator class for simple expression computing
import javax.swing.JOptionPane;

public class Calculator {
		private String expression;
		private char operator;
		private double operandValue,
			        currentTotal;
        public Calculator() {			//�����������ݳ�ʼ��
			expression = null;
			operator = ' ';
			operandValue = 0.0;
        	currentTotal = 0.0;
        }
        public void requestInput() {  	//�õ��û�����ļ�����ʽ�ַ���
        	expression = JOptionPane.showInputDialog("Please enter your expression: ");
		}
		public void parseExpression() {	//�ֽ�����ַ�����Ϊ�������Ͳ�����
			//char[] operators = new char[1];
			String[] expressions = expression.split(" ");	//����split()�����ÿո���зֽ�
		     		currentTotal = Double.parseDouble(expressions[0]); //��һ��������
		     		for(int i = 1; i < expressions.length; i += 2) {		//���εõ�����������Ͳ�����
		       			//operators = expressions[i].toCharArray();	//���ַ�����õ�������
		       			operator = expressions[i].charAt(0);		//ת�����ַ��Ա�ʹ��switch-case
		       			operandValue = Double.parseDouble(expressions[i+1]); //�õ���һ��������
						compute();			//���ü���
					}
		}
		public void compute() {		//��������
			switch (operator) {
				case '+':  currentTotal += operandValue;
					   	   break;
				case '-':  currentTotal -= operandValue;
				   	       break;
				case '*':  currentTotal *= operandValue;
					       break;
				case '/':  currentTotal /= operandValue;
				           break;
				default:   System.out.println("wrong operator...");	//�������������֮��
						   break;
				}
		}
		public String toString() {		//���ر��ʽ����������Ϣ
		 	return expression + "\nThe total after the calculation: " + currentTotal;
		}
}
