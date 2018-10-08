//demo: object instantiating vs. object referencing

public class ObjectReferenceTest {
    public static void main(String[] args) {


        SomeClass obj1 = new SomeClass(10);		//obj1 is created
        SomeClass obj2 = obj1;					//obj1 is referenced by obj2
        SomeClass obj3 = obj2;					//obj1 is referenced by obj3, too

		SomeClass otherObj = new SomeClass(10);	//otherObj is created

		obj2.setX(100);							//obj1's x is changed to 100

        System.out.println("obj1's x = " + obj1.getX());
        System.out.println("otherObj's x = " + otherObj.getX());
    }
}
