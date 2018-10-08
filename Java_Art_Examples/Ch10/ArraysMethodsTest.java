//Test methods in Arrays class

import java.util.Arrays;

public class ArraysMethodsTest {
   public static void main( String args[] ) {

		//10.4.1 ��3  
	   String[] names1 = {"C", "C++", "Java" };
	   String[] names2 = {"c", "C++", "Java"};
	   if(Arrays.equals(names1, names2))
	   	System.out.println("They are equal");
	   else
	   	System.out.println("They are not equal");

	   	//10.4.1 ��4
	    Object[] objects1 = {new Double(10.20), new Integer(20)}; 
		Object[] objects2 = {new Double(10.20), new Integer(20)}; 
		if (Arrays.equals(objects1, objects2))
			System.out.println("They are equal");
		else
			System.out.println("They are not equal");
		
		//10.4.2 ��1
		int[] scores = {2, 4, 0, 1, 10, 9, 5, 3, 8};
		Arrays.sort(scores);
		for(int score : scores)
		  System.out.print(score + "   ");
		System.out.println();
		
		//10.4.2 ��2
		String[] javas = {"Java SE", "JSP", "Java EE", "Java ME", "Servlets", "Applets", "Java"}; 
		Arrays.sort(javas);		//
		int index = Arrays.binarySearch(javas, "Java");
		for(String java : javas)
		  System.out.print(java + "   ");

		System.out.println("\n" + "index of java = " + index);

		//10.4.2 ��3
		Double[][] doubles = { {new Double(2.98), new Double(19.23), new Double(0.09)}, {new Double(1.02),
		 						 new Double(20.34), new Double (2.09), new Double(8.201), new Double(0.01)}};

		Arrays.sort(doubles[0]);		//sort the first row of doubles

		Arrays.sort(doubles[1]);		//sort the second row of doubles
		for (Double[] row : doubles) {
			for(Double col : row)
				System.out.print(col + "   ");
			System.out.println();
			}
		System.out.println("index of 2.09 = " + Arrays.binarySearch(doubles[1], 2.09));
		System.out.println("index of 2.98001 = " + Arrays.binarySearch(doubles[0], 2.98001));
		
		//10.4.3 ��1
		double[] grades = {98, 78, 89, 82, 100, 67};
		double[] copyGrades = Arrays.copyOf(grades, grades.length);	//��grades���Ƶ�copyGrades
		
		for(Object copyGrade : copyGrades)
			 System.out.print(copyGrade + "  ");
		System.out.println("\n");
		
		//10.4.3 ��2
		double[] copySomes = Arrays.copyOfRange(grades, 3, grades.length-1);
		for(Object copySome : copySomes)
			 System.out.print(copySome + "  ");
		System.out.println("\n");
		
		//10.4.3 ��3
		copyGrades = new double[grades.length];	//����һ����ͬ���ͺͳ��ȵ�����
		System.arraycopy(grades, 0, copyGrades, 0, grades.length);
		for(Object copyGrade : copyGrades)
			 System.out.print(copyGrade + "  ");
		System.out.println("\n");
		
		//10.4.3 ��4
		Object[] sourceObjects = {new Circle(5.26), new Circle(19.20)};	
		Object[] targetObjects = new Object[sourceObjects.length];
		
		//sourceObjects[2].setRadius();
		System.arraycopy(sourceObjects, 0, targetObjects, 0, sourceObjects.length);

		Circle circle = (Circle) targetObjects[1];	//����ת����cricle����
		circle.computeArea();
		for(Object targetObject : targetObjects)
		 System.out.print(targetObject + "  ");
		System.out.println("\n");
		
		for(Object object : sourceObjects)
			System.out.print(object + "  ");
		System.out.println("\n");

		Integer integer = new Integer(2000);
		sourceObjects[0] = integer;

		for(Object object : sourceObjects)
			System.out.print(object + "  ");
		System.out.println("\n");

		for(Object targetObject : targetObjects)
				 System.out.print(targetObject + "  ");
		System.out.println("\n");

		targetObjects = Arrays.copyOf(sourceObjects, sourceObjects.length);
		
		circle = (Circle) targetObjects[1];	//����ת����cricle����
		circle.setRadius(1);
		circle.computeArea();

		for(Object targetObject : targetObjects)
		 System.out.print(targetObject + "  ");
		System.out.println("\n");
		
		for(Object object : sourceObjects)
			System.out.print(object + "  ");
		System.out.println("\n");


	}
}



