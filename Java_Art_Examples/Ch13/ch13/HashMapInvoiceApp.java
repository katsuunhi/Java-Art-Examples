package ch13;

public class HashMapInvoiceApp {
	public static void main(String[] args) {

		Invoice invoice = new Invoice();							//�����������ϵĶ���
		invoice.addOrder("1122", new Product("Java", 15, 89.69));		//����ӳ�䵥Ԫ
		invoice.addOrder("1133", new Product("JSPS", 12, 78.99));
		invoice.addOrder("1124", new Product("Java", 20, 89.69));

		System.out.println("Product info\n" + invoice.search("1133"));			//��key��ѯ���
		System.out.println("Get order info\n" + invoice.getOrderInfo("Java"));	//����Ʒ����ѯ���
		System.out.println("Invoice info\n" + invoice.getInvoiceTotal());			//�����ܽ��
	}
}	

