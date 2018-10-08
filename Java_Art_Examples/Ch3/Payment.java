//类Payment

public class Payment{		//定义类 Payment

	 private double	price,	//建立类变量
					total;

	 private int quantity;

	 private final double INTEREST_RATE = 0.0875;	//建立常量并初始化

	public void setPrice(double cost)  				//方法setXxx() 和 getXxx()
	 	{ price = cost; }

	public double getPrice()
		{ return price; }

	public double getTotal()
		{ return total; }

	public void setQuantity(int item)
		{ quantity = item; }

	public int getQuantity()
		{ return quantity; }

	public void bill()						//计算总额
		{ total = quantity * price + quantity * price * INTEREST_RATE; }

 } // 类 Payment结束