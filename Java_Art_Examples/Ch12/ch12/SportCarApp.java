package ch12;

import javax.swing.*;			//����JOptionPane�ķ���

public class SportCarApp {
 public static void main( String args[] ) {
	 
	 //�õ��û�ѡ��
	 String car = JOptionPane.showInputDialog(null, "ѡ����Ҫ���ܳ�(P - Porsche, F - Ferrari, J - Jaguar): ");
	 
	 //��������
	 SportCar yourCar = new SportCar(car);
	 
	 //�����Ϣ
	 JOptionPane.showMessageDialog(null, "��Ҫ���ܳ���Ϣ��\n" + yourCar);
	}
}
