//类 Payment的驱动程序或称驱动类

import javax.swing.JOptionPane;

public class PaymentApp {
	public static void main(String[] args) {

		Payment payment = new Payment(); //创建类Payment的对象

		String str;		//定义一个字符串

		str = JOptionPane.showInputDialog("请输入单价: "); //得到输入

		payment.setPrice(Double.parseDouble(str)); //转换成双精度数值

		str = JOptionPane.showInputDialog("请输入数量: "); //得到输入

		payment.setQuantity(Integer.parseInt(str));  //转换成整数并调用方法

		payment.bill();	//调用计算方法

		//显示结果
		JOptionPane.showMessageDialog(null, "总金额是 " + payment.getTotal());
	} //main()方法结束
} //驱动类PaymentApp结束

