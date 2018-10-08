package ch12;

import javax.swing.*;			//引入JOptionPane的方法

public class SportCarApp {
 public static void main( String args[] ) {
	 
	 //得到用户选择
	 String car = JOptionPane.showInputDialog(null, "选择你要的跑车(P - Porsche, F - Ferrari, J - Jaguar): ");
	 
	 //创建对象
	 SportCar yourCar = new SportCar(car);
	 
	 //输出信息
	 JOptionPane.showMessageDialog(null, "你要的跑车信息：\n" + yourCar);
	}
}
