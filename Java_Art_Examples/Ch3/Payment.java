//��Payment

public class Payment{		//������ Payment

	 private double	price,	//���������
					total;

	 private int quantity;

	 private final double INTEREST_RATE = 0.0875;	//������������ʼ��

	public void setPrice(double cost)  				//����setXxx() �� getXxx()
	 	{ price = cost; }

	public double getPrice()
		{ return price; }

	public double getTotal()
		{ return total; }

	public void setQuantity(int item)
		{ quantity = item; }

	public int getQuantity()
		{ return quantity; }

	public void bill()						//�����ܶ�
		{ total = quantity * price + quantity * price * INTEREST_RATE; }

 } // �� Payment����