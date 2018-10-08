package ch13;

//demo: driver for Items sorting using NumberComparator

import java.util.*;

public class ItemsSortTest {
   public static void main( String args[] ) {

		List<Items> list = new LinkedList<Items>();			//����Items���ͼ���

		Items myItem = new Items(100, "software");				//��������Item����
		Items hisItem = new Items(10, "hardware");
		Items herItem = new Items(15, "midlleware");

		list.add(myItem);									//����Ԫ��
		list.add(hisItem);
		list.add(herItem);

		Collections.sort(list, new NumberComparator());		//����sort()

		System.out.println(list);
   }
}

