//polymorephism test

public class PolymorphismTest2 {
   public static void main( String[] args )
   {
      SubClass2 b = new SubClass2();

      SuperClass2 supper = b;
      System.out.println(supper.method());

      supper.otherMethod();
   }
}
