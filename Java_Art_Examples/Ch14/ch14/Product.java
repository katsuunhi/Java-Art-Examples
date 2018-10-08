package ch14;

import java.text.*;

class Product {
	private int productID;
	private double price;
	public Product(int productNumber) {
		productID = productNumber;
		price = Math.random() * 100 + 5;		
	}
	public String toString() {
		String amount = NumberFormat.getCurrencyInstance().format(price);
		return "Product ID: " + productID + "\tPrice: " + amount;
	}
}
