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
		//System.out.println("\t\t\t\t�žų˷���\n");	//���м�λ�ô�ӡ����
		//for (int row = 1; row <= 9; row++)  {		//��ѭ����ӡ9��
		//	for (int col = 1; col <= 9; col++)		//��ѭ����ӡ9��
		//		System.out.print("\t" + row * col);		//��ʾ�˻�
		//	System.out.println();				//һ�еĿ�ʼ
		//}

		
	}	//end of main()
}		//end of GradeApp class
