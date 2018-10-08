package ch13;

import java.util.*;
import java.text.NumberFormat;

class Invoice { 
	private HashMap<String, Product> orderMap;					//申明HashMap集合
	private Collection<Product> orderList;							//申明Collection集合

	NumberFormat currency = NumberFormat.getCurrencyInstance();	//货币输出格式

	public Invoice() {											//构造器定义HashMap集合
		orderMap = new HashMap<String, Product>();
	}
	public void addOrder(String code, Product product) {				//增添映射单元
		orderMap.put(code, product);
	}
	public String search(String code) {								//按照key查询产品订购信息
		String message = null;
		Product product = orderMap.get(code);
		double total = product.getQuantity() * product.getPrice();		//统计

		message = "Product: " + product.getName()
				  + "\nQuantity: " + product.getQuantity()
				  + "\nPrice: " + currency.format(product.getPrice())
				  + "\nTotal: " + currency.format(total) + "\n";
		return message;											//返回查询信息
	}
	public String getOrderInfo(String name) {					//查询指定产品订购信息
		orderList = orderMap.values();							//以Collection集合返回所有value

		int totalQuantity = 0;
		double totalAmount = 0.0;
		String message;
		for(Product order : orderList) {						//遍历value元素
			if (name.equals( order.getName()))
				totalQuantity += order.getQuantity();
				totalAmount += order.getPrice();
			}

		totalAmount *= totalQuantity;
		message = "Product name: " + name + "\nTotal quantity: " + totalQuantity
				  + "\nTotalAmount: " + currency.format(totalAmount) + "\n";
		return message;										//返回指定产品的统计信息
		}
	public String getInvoiceTotal() {						//统计订购总金额
		orderList = orderMap.values();
		double total = 0.0;
		for(Product order : orderList)
	 		total += order.getPrice()*order.getQuantity();
	    return "Grand Total: " + currency.format(total) + "\n";				//返回总金额
	 }
}

