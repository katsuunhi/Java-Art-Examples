package ch17;

//Application: the driver of FoodSurveyFrame5

import javax.swing.*;

public class FoodSurveyFrame5App {
	public static void main(String[] args) {
		JFrame frame = new FoodSurveyFrame5();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(530, 250);
		frame.setResizable(false);
        frame.setVisible(true);
	}
}
