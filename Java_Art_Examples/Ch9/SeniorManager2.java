//SeniorManager2 class derived from Manager2

public final class SeniorManager2 extends Manager2 {
   private double meritPay;

   public SeniorManager2( String name, double salary, double meritPay) {
      super( name, salary );  // call superclass constructor
      this.meritPay = meritPay;
   }

   public double earnings() { return salary + meritPay; }	//override the method to retrieve salary

   public String toString() {	//override the method to print the name
      return "Senior Manager: " + getName();   
   }
}