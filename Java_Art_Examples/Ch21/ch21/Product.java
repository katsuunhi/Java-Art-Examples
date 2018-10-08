package ch21;

//Product class

import java.io.*;

class Product implements Serializable {
	private String ID;
	private String title;
	double price;

	Product(String ID, String title, double price) {
		this.ID = ID;
		this.title = title;
		this.price = price;
	}
	String getID() {
	    return ID;
	}
	String getTitle() {
		return title;
	}
	double getPrice() {
		return price;
	}
}