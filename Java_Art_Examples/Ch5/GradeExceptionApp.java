//Demo of testing the Grade class with nested if-else
import javax.swing.JOptionPane;

public class GradeExceptionApp {

	public static void main(String[] args) {
		Grade grade = new Grade();	//create an object
		
		int score = 0;
		
		String str, message;
		boolean notDone = true;
	    while (notDone) { 
		  try {		//
			//ask for input score
			str = JOptionPane.showInputDialog("please enter an integer score: ");
			score = Integer.parseInt(str); //convert to int
		    notDone = false;			 //如果无输入错误，则结束循环	
		    }
		  catch (NumberFormatException e ){
			JOptionPane.showMessageDialog(null, "输入数据错误。请按整数值打入学生成绩...");
			continue;
		  }
	     } //while 循环结束
		grade.setScore(score);			//call the method to set the score
		grade.assginGrade();			//call the method to assign the grade
		
		//build the output message
		message = "Your score is " + score + " and grade is " + grade.getGrade();
		
		//output the message
		JOptionPane.showMessageDialog(null, message);
	}	//end of main()
}		//end of GradeApp class
