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
		    notDone = false;			 //�����������������ѭ��	
		    }
		  catch (NumberFormatException e ){
			JOptionPane.showMessageDialog(null, "�������ݴ����밴����ֵ����ѧ���ɼ�...");
			continue;
		  }
	     } //while ѭ������
		grade.setScore(score);			//call the method to set the score
		grade.assginGrade();			//call the method to assign the grade
		
		//build the output message
		message = "Your score is " + score + " and grade is " + grade.getGrade();
		
		//output the message
		JOptionPane.showMessageDialog(null, message);
	}	//end of main()
}		//end of GradeApp class
