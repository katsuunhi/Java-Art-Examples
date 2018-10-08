package ch13;

public class HashMapInvoiceApp {
	public static void main(String[] args) {

		Invoice invoice = new Invoice();							//创建包含集合的对象
		invoice.addOrder("1122", new Product("Java", 15, 89.69));		//增添映射单元
		invoice.addOrder("1133", new Product("JSPS", 12, 78.99));
		invoice.addOrder("1124", new Product("Java", 20, 89.69));

		System.out.println("Product info\n" + invoice.search("1133"));			//按key查询结果
		System.out.println("Get order info\n" + invoice.getOrderInfo("Java"));	//按产品名查询结果
		System.out.println("Invoice info\n" + invoice.getInvoiceTotal());			//订购总金额
	}
}	

