package ch14;

class Shop {
	private static int numOfProduct = 0;

	public static void producing() {
		numOfProduct++;
		System.out.println("Number of products available: " + numOfProduct);
	}
	public static void consuming() {
		numOfProduct--;
		System.out.println("Number of products available: " + numOfProduct);
	}
}
