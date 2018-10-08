// Driver for Employee2 hierarchy using interface Printable

public class Polymorphism2App {
   public static void main( String args[] )
   {
      Employee2[] ref = new Employee2[3];  // superclass reference
      
      Manager2 manager = new Manager2( "Wang", 5800.00 );
      SeniorManager2 senior = new SeniorManager2( "Smith", 6250.0, 1500.0);
      RegularWorker2 regular = new RegularWorker2( "Lee", 2980.00, 270.0);

      ref[0] = manager;  // Employee reference to a Boss

      ref[1] = senior;  // Employee reference to a CommissionWorker

      ref[2] = regular;  // Employee reference to a PieceWorker

      for(int i = 0; i < 3; i++)  //polymorphically form output for different objects
        ref[i].print();
   }
}
