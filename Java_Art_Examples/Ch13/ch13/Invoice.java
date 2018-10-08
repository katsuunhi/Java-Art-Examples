package ch13;

import java.util.*;
import java.text.NumberFormat;

class Invoice { 
	private HashMap<String, Product> orderMap;					//����HashMap����
	private Collection<Product> orderList;							//����Collection����

	NumberFormat currency = NumberFormat.getCurrencyInstance();	//���������ʽ

	public Invoice() {											//����������HashMap����
		orderMap = new HashMap<String, Product>();
	}
	public void addOrder(String code, Product product) {				//����ӳ�䵥Ԫ
		orderMap.put(code, product);
	}
	public String search(String code) {								//����key��ѯ��Ʒ������Ϣ
		String message = null;
		Product product = orderMap.get(code);
		double total = product.getQuantity() * product.getPrice();		//ͳ��

		message = "Product: " + product.getName()
				  + "\nQuantity: " + product.getQuantity()
				  + "\nPrice: " + currency.format(product.getPrice())
				  + "\nTotal: " + currency.format(total) + "\n";
		return message;											//���ز�ѯ��Ϣ
	}
	public String getOrderInfo(String name) {					//��ѯָ����Ʒ������Ϣ
		orderList = orderMap.values();							//��Collection���Ϸ�������value

		int totalQuantity = 0;
		double totalAmount = 0.0;
		String message;
		for(Product order : orderList) {						//����valueԪ��
			if (name.equals( order.getName()))
				totalQuantity += order.getQuantity();
				totalAmount += order.getPrice();
			}

		totalAmount *= totalQuantity;
		message = "Product name: " + name + "\nTotal quantity: " + totalQuantity
				  + "\nTotalAmount: " + currency.format(totalAmount) + "\n";
		return message;										//����ָ����Ʒ��ͳ����Ϣ
		}
	public String getInvoiceTotal() {						//ͳ�ƶ����ܽ��
		orderList = orderMap.values();
		double total = 0.0;
		for(Product order : orderList)
	 		total += order.getPrice()*order.getQuantity();
	    return "Grand Total: " + currency.format(total) + "\n";				//�����ܽ��
	 }
}

