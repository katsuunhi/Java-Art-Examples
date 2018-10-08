
import java.util.*;

public class WildcardTest {
	public static void main(String[] args) {

	Collection<String> arrayList = new ArrayList<String>();
		arrayList.add("abc");
		arrayList.add("xyz");

		Collection<Integer> linkedList = new LinkedList<Integer>();
		linkedList.add(10);
		linkedList.add(20);

	Tester.printCollection(arrayList);

	Tester.printCollection(linkedList);


	 Tester<?> tester = new Tester<Float>(2.3f);



	 Integer intObj = 10;
	 Double doubleObj = 2.66;

	 Object obj = tester.take("xyz");
	 		obj = tester.take(intObj);
	 		obj = tester.take(doubleObj);
	 		obj = tester.take(new Tester<String>("test"));


//Collection<?> arrayList = new ArrayList<String>();

//	arrayList.add((Object)intObj);
  }

}

class Tester<T> {
	private T n;

	public Tester(T n) {
		 this.n = n;
	 }

	  static void printCollection(Collection<?> c) {
		 for(Object obj : c)
		 	System.out.println("obj = " + obj);

	}
	public Object take(Object obj) {
		System.out.println("n = " + n);
		System.out.println("obj = " + obj);
		return obj;
	}
}

