//投资回报驱动程序

import javax.swing.JOptionPane;

public class FutureValue2App {
public static void main(String[] args) {

		String choice = "y",		//循环变量初始化
			   str,
			   userName;
	FutureValue2 futureValue = new FutureValue2();  //创建FutureValue2对象
	while(choice.equalsIgnoreCase("y")) {

		userName = JOptionPane.showInputDialog("Welcome to future value application!\n\n"
					 + "please enter your name: ");

		futureValue.setName(userName);				//建立用户名


		str = JOptionPane.showInputDialog("enter your monthly invest: ");
		futureValue.setMonthlyInvest(Double.parseDouble(str));		//建立月投资额

		str = JOptionPane.showInputDialog("enter yearly return rate: ");
		futureValue.setYearlyRate(Double.parseDouble(str));			//建立年投资率

		str = JOptionPane.showInputDialog("enter number of years: ");
		futureValue.setYears(Integer.parseInt(str));				//建立投资年

		futureValue.futureValueCompute();

		JOptionPane.showMessageDialog(null, "Your future return is: "
									  + futureValue.getFutureValue());

		choice = JOptionPane.showInputDialog("continue? (y/n): ");	//是否继续？
 	} //while循环结束

 	JOptionPane.showMessageDialog(null, "Thank you for using future value application.");
  } //main()方法结束
} //驱动类FutureValue2App结束