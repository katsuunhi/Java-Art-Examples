package ch13;

//demo: driver for Items sorting using NumberComparator

import java.util.*;

public class ItemsSortTest {
   public static void main( String args[] ) {

		List<Items> list = new LinkedList<Items>();			//创建Items类型集合

		Items myItem = new Items(100, "software");				//创建三个Item对象
		Items hisItem = new Items(10, "hardware");
		Items herItem = new Items(15, "midlleware");

		list.add(myItem);									//增添元素
		list.add(hisItem);
		list.add(herItem);

		Collections.sort(list, new NumberComparator());		//调用sort()

		System.out.println(list);
   }
}

