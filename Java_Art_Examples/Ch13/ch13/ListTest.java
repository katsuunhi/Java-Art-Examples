package ch13;

//demo: use of ArrayList, LinkedList, and Iterator

import java.util.*;

public class ListTest {
	public static void main(String[] args) {
		ArrayList noSafeList = new ArrayList();		//��������10��Ԫ�ؿռ�������Ͱ�ȫ��֤��ArrayList
		ArrayList<String> nameList = new ArrayList<String>();	  //����10�ַ���Ԫ�ؿռ��nameList
		ArrayList<Double> priceList = new ArrayList<Double>(80);  //����80��˫��������Ԫ�ص�priceList
		ArrayList<Product2> productList = new ArrayList<Product2>();//����10��ProductԪ�ؿռ��productList
		ArrayList<String> list = new ArrayList<String>(nameList);	  //list����������nameList��Ԫ�ء�

		noSafeList.add(10);
		noSafeList.add("Java");
		nameList.add("Lee");
		nameList.add("Smith");

		priceList.add(129.65);			//�Զ�װ�䣬������˫���Ȱ�װ�����Ԫ��
		priceList.add(0, 89.76);		//�Զ�װ�䣬�ٽ�������Ϊ��1��λ���ϵ�Ԫ��

		productList.add(new Product2("1011", "software", 59.85));


		System.out.println(priceList.contains(129.65));

		System.out.println(nameList.get(1));
		System.out.println(nameList.indexOf("Lee"));

		ArrayList<String> list2 = new ArrayList<String>(nameList);	  //list2����������nameList��Ԫ�ء�
		System.out.println(list2.isEmpty());				//���н����false


		list2.remove(1);
		list2.set(0, "����");
		System.out.println("Size of list2 = " + list2.size());
		System.out.println("Size of nameList = " + nameList.size());

		System.out.println("nameList contains = " + nameList.contains("Lee"));
		System.out.println("list contains = " + list.contains("Lee"));
		System.out.println("nameList size = " + nameList.size());
		System.out.println("list size = " + list.size());

		Object[] doubleArray = priceList.toArray();			//����priceList������ṹ
		System.out.println(doubleArray[0]);					//���н����89.76
		System.out.println(priceList);						//��System.out.println(pricelist.toString());

		System.out.println("productList = " + productList.toString());	//��System.out.println(productList);


		//13.2.2�е�����
		LinkedList<String> linkedList = new LinkedList<String>(nameList);

		linkedList.addFirst("������");
		linkedList.addLast("Duke");
		System.out.println("linkedList = " + linkedList);

		//Object obj = linkedList.getFirst();		//obj = "������"
		System.out.println("Last index of \"Lee\" = " + linkedList.lastIndexOf("Lee"));


		Iterator<String> iterator = linkedList.iterator();

		int i = 1;
		while (iterator.hasNext()) {
			System.out.println(i + "th element: " + iterator.next());
			i++;
		}

		for(Iterator it = linkedList.iterator(); it.hasNext();)
			System.out.println(it.next());
  }

}

class Product2 {
	String code;
	String type;
	double price;

	public Product2(String code, String type, double price) {
		this.code = code;
		this.type = type;
		this.price = price;
	}

}
