
//Two dimension array test

public class TwoDArrayTest1 {
   public static void main( String args[] )

   {
		int[][] scores = { {89, 92, 87}, {99, 90, 82} };  //create and initialize array
		int sum = 0;
		double average;

		for( int row[] : scores) {			//outer loop controls rows
		 for( int col : row) {	//inner loop controls columns
			System.out.print(col + "\t");
			sum += col;
		 }
		System.out.println("\n");
		}
		average = (double) sum / (scores.length * scores[0].length); //2 * 3
		System.out.println("Average score: " + average);
   }
}
