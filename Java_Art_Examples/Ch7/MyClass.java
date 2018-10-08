public class MyClass {

    public static void printClassName(Object object) {
    	System.out.println("The class of " + object +
	                   " is " + object.getClass().getName());
     }
    
    public static String getInheritanceTree(Class aClass){
    StringBuilder superclasses = new StringBuilder();
    superclasses.append( "\n");
    Class theClass = aClass;
    while ( theClass != null ) {
       superclasses.append( theClass );
       superclasses.append( "\n" );
       theClass = theClass.getSuperclass();
    }
    superclasses.append( "\n" );
    return superclasses.toString();
  }
}
