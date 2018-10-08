package ch13;

//demo: use of sorting algorithm in Collections
import java.util.*;

public class SortTest {
	public static void main(String[] args) {

		List<Integer> intList = new ArrayList<Integer>();
		intList.add(89);
		intList.add(78);
		intList.add(88);

		Collections.sort(intList);

		System.out.println(intList);

		Collections.sort(intList, Collections.reverseOrder());
		System.out.println(intList);

		Collections.reverse(intList);
		System.out.println(intList);

		ArrayList<Double> doubleList = new ArrayList<Double>();

		doubleList.add(120.99);
		doubleList.add(87.03);
		doubleList.add(89.67);

		System.out.println("Before reverse: " + doubleList);

		Collections.reverse(doubleList);
		System.out.println("After reverse: \t" + doubleList);

		Collections.sort(doubleList);
		System.out.println("After sort: \t" + doubleList);

		Collections.sort(doubleList, Collections.reverseOrder());
		System.out.println(doubleList);

		Collections.reverse(doubleList);
		System.out.println(doubleList);
  }
}