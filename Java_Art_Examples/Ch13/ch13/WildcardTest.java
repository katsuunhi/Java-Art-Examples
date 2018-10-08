package ch13;
//demo: use of wildcard

import java.util.*;

public class WildcardTest {
	public static void main(String[] args) {
	
		List<?> bList;
		List<Integer> iList = new ArrayList<Integer>();
		iList.add(8);
		iList.add(88);

		bList = new ArrayList<Integer>(iList);

		Test.printList(bList);

		List<Double> dList = new ArrayList<Double>();
		dList.add(0.8);
		dList.add(0.08);

		bList = new ArrayList<Double>(dList);
		Test.printList(bList);
		
		ArrayList<String> arrayList = new ArrayList<String>();   	//无边界通配符<?>被String替换
		arrayList.add("abc");
		arrayList.add("xyz");
		Test.printList(arrayList);
  }
}