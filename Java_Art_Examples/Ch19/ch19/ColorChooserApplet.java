package ch19;

//Use of JApplet and JColorChooser to select colors
import java.awt.*;
import javax.swing.*;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.*;

public class ColorChooserApplet extends JApplet{
	JColorChooser colorChooser;
	ColorSelectionModel model;
	JLabel label;
	ChangeListener changeListener;
	public void init() {
		label = new JLabel("我爱Java", JLabel.CENTER);
		label.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 48));
    	add(label, BorderLayout.SOUTH);
		colorChooser = new JColorChooser(label.getBackground());
		colorChooser.setBorder(BorderFactory.createTitledBorder("选择您喜欢的颜色"));
		add(colorChooser, BorderLayout.CENTER);

		changeListener = new ChangeListener() {
		      public void stateChanged(ChangeEvent changeEvent) {
		        Color newForegroundColor = colorChooser.getColor();
		        label.setForeground(newForegroundColor);
		      }
    	};
    	model = colorChooser.getSelectionModel();
    	model.addChangeListener(changeListener);
	}
}