package ch17;

//Use of JColorChooser to select colors
import java.awt.*;
import javax.swing.*;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.*;

class ColorChooserFrame extends JFrame{
	JColorChooser colorChooser;
	ColorSelectionModel model;
	JLabel label;
	ChangeListener changeListener;
	ColorChooserFrame() {
		super("��ɫѡ������ʾ����");
		label = new JLabel("�Ұ�Java", JLabel.CENTER);
		label.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 48));
    	add(label, BorderLayout.SOUTH);

		colorChooser = new JColorChooser(label.getBackground());
		colorChooser.setBorder(BorderFactory.createTitledBorder("ѡ����ϲ������ɫ"));
		add(colorChooser, BorderLayout.CENTER);

		changeListener = new ChangeListener() {
		      public void stateChanged(ChangeEvent changeEvent) {
		        Color newForegroundColor = colorChooser.getColor();
		        label.setForeground(newForegroundColor);
		      }
    	};
    	model = colorChooser.getSelectionModel();
    	model.addChangeListener(changeListener);

    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
public class ColorChooserFrameApp {
  public static void main(String args[]) {
    JFrame frame = new ColorChooserFrame();
    frame.pack();
    frame.setVisible(true);
  }
}