public class ArrayDemo {								//
	public static void fillArray(int[] array) {
		for(int i = 0; i  < array.length; i++)
		  array[i] = (int) (Math.random() * 100);
	  }
	public static void display(int[] array) {
		for(int element : array)
			 System.out.print(element + "\t");
			 System.out.println();
	}
  }