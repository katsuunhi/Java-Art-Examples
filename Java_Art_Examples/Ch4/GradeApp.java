//Demo of testing the Grade class with nested if-else
import javax.swing.JOptionPane;

public class GradeApp {

	public static void main(String[] args) {
		Grade grade = new Grade();	//create an object
		
		int score;
		//int total = 100, sum = 0;
		String str, message;
		//ask for input score
		str = JOptionPane.showInputDialog("please enter an integer score: ");
		score = Integer.parseInt(str); //convert to int
		
		grade.setScore(score);			//call the method to set the score
		grade.assginGrade();			//call the method to assign the grade
		
		//build the output message
		message = "Your score is " + score + " and grade is " + grade.getGrade();
		
		//output the message
		JOptionPane.showMessageDialog(null, message);
		//double discountRate = total >= 150 ? 0.2+0.5 : 0.15-2;
		//System.out.println(discountRate);	
		//System.out.println("\t\t\t\t九九乘法表\n");	//在中间位置打印标题
		//for (int row = 1; row <= 9; row++)  {		//外循环打印9行
		//	for (int col = 1; col <= 9; col++)		//内循环打印9列
		//		System.out.print("\t" + row * col);		//显示乘积
		//	System.out.println();				//一行的开始
		//}

		
	}	//end of main()
}		//end of GradeApp class
