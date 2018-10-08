//String referencing pk. String instantiating

public class StringReferencingTest {
	public static void main(String[] args)   {
		String s1 = "Java";
		String s2 = s1;
		String s3 = "Java";

		if (s1 == s2)
			System.out.println("s1 == s2 ");
		else
			System.out.println("s1 != s2");
		if (s1 == s3)
			System.out.println("s1 == s3 ");
		else
			System.out.println("s1 != s3");
		if (s1.equals(s2))
			System.out.println("s1 equals s2 ");
		else
			System.out.println("s1 not equals s2");
		if (s1.equals(s3))
			System.out.println("s1 equals s3 ");
		else
			System.out.println("s1 not equals s3");

		s1 = "JSP";

		if (s1.equals(s2))
			System.out.println("s1 equals s2 ");
		else
			System.out.println("s1 not equals s2");
		if (s2.equals(s3))
			System.out.println("s2 equals s3 ");
		else
			System.out.println("s2 not equals s3");

		String s4 = new String(s1);

		if (s4 == s1)
			System.out.println("s4 == s1 ");
		else
			System.out.println("s4 != s1");
		if (s4.equals(s1))
			System.out.println("s4 equals s1 ");
		else
			System.out.println("s4 not equals s1");

		String s5 = new String("JSP");
		
		if (s5 == s1)
			System.out.println("s5 == s1 ");
		else
			System.out.println("s5 != s1");
		if (s5.equals(s1))
			System.out.println("s5 equals s1 ");
		else
			System.out.println("s5 not equals s1");

		s1 = s5;

		if (s5 == s1)
			System.out.println("s5 == s1 ");
		else
			System.out.println("s5 != s1");
		if (s5.equals(s1))
			System.out.println("s5 equals s1 ");
		else
			System.out.println("s5 not equals s1");
	}
}

