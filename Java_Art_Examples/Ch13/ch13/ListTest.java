package ch13;

//demo: use of ArrayList, LinkedList, and Iterator

import java.util.*;

public class ListTest {
	public static void main(String[] args) {
		ArrayList noSafeList = new ArrayList();		//创建具有10个元素空间的无类型安全保证的ArrayList
		ArrayList<String> nameList = new ArrayList<String>();	  //具有10字符串元素空间的nameList
		ArrayList<Double> priceList = new ArrayList<Double>(80);  //具有80个双精度类型元素的priceList
		ArrayList<Product2> productList = new ArrayList<Product2>();//具有10个Product元素空间的productList
		ArrayList<String> list = new ArrayList<String>(nameList);	  //list包含有所有nameList的元素。

		noSafeList.add(10);
		noSafeList.add("Java");
		nameList.add("Lee");
		nameList.add("Smith");

		priceList.add(129.65);			//自动装箱，再增添双精度包装类对象元素
		priceList.add(0, 89.76);		//自动装箱，再将其增添为第1个位置上的元素

		productList.add(new Product2("1011", "software", 59.85));


		System.out.println(priceList.contains(129.65));

		System.out.println(nameList.get(1));
		System.out.println(nameList.indexOf("Lee"));

		ArrayList<String> list2 = new ArrayList<String>(nameList);	  //list2包含有所有nameList的元素。
		System.out.println(list2.isEmpty());				//运行结果：false


		list2.remove(1);
		list2.set(0, "范义");
		System.out.println("Size of list2 = " + list2.size());
		System.out.println("Size of nameList = " + nameList.size());

		System.out.println("nameList contains = " + nameList.contains("Lee"));
		System.out.println("list contains = " + list.contains("Lee"));
		System.out.println("nameList size = " + nameList.size());
		System.out.println("list size = " + list.size());

		Object[] doubleArray = priceList.toArray();			//返回priceList的数组结构
		System.out.println(doubleArray[0]);					//运行结果：89.76
		System.out.println(priceList);						//或：System.out.println(pricelist.toString());

		System.out.println("productList = " + productList.toString());	//或：System.out.println(productList);


		//13.2.2中的例子
		LinkedList<String> linkedList = new LinkedList<String>(nameList);

		linkedList.addFirst("姜文明");
		linkedList.addLast("Duke");
		System.out.println("linkedList = " + linkedList);

		//Object obj = linkedList.getFirst();		//obj = "姜文明"
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
