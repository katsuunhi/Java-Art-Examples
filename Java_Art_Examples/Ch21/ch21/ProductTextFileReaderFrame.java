package ch21;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

class ProductTextFileReaderFrame extends JFrame {
    ProductTextFileReaderFrame()
    {
        setTitle("��Ʒ�ı��ļ��������");
        centerWindow(this);
        setSize(300, 240);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new ProductFileReaderPanel();
        this.add(panel);
    }

    private void centerWindow(Window w)
    {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        setLocation((d.width-w.getWidth())/2, (d.height-w.getHeight())/2);
    }
}

class ProductFileReaderPanel extends JPanel implements ActionListener
{
    private JTextField  IDTextField,
                        titleTextField,
                        priceTextField,
                        infoTextField;
    private JLabel      IDLabel,
                        titleLabel,
                        priceLabel,
                        infoLabel,
                        countLabel,
                        totalLabel,
                        endFileLabel;
    private JButton     readButton,
                        exitButton;

    private TextFileReader fileReader;
    private String fileName = "C:/java/Ch21/productFiles/products.txt";
    private int count;
    private StringTokenizer token;
    private double total;


    public ProductFileReaderPanel()
    {
        // display panel
        JPanel productFilePanel = new JPanel();
        productFilePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        // payment label
        IDLabel = new JLabel("��Ʒ���:");
        productFilePanel.add(IDLabel);

        // payment text field
        IDTextField = new JTextField(20);
        productFilePanel.add(IDTextField);

        // rate label
        titleLabel = new JLabel("��Ʒ��:");
        productFilePanel.add(titleLabel);

        // rate text field
        titleTextField = new JTextField(20);
        productFilePanel.add(titleTextField);

        // years label
        priceLabel = new JLabel("��Ʒ�۸�:");
        productFilePanel.add(priceLabel);

        // years text field
        priceTextField = new JTextField(20);
        productFilePanel.add(priceTextField);

        // future value label
        infoLabel = new JLabel("�����ļ�:");
        productFilePanel.add(infoLabel);
        infoLabel.setVisible(false);

        // future value text field
        infoTextField = new JTextField(20);
        infoTextField.setEditable(false);
        infoTextField.setFocusable(false);
        productFilePanel.add(infoTextField);
        infoTextField.setVisible(false);

        countLabel = new JLabel();
		productFilePanel.add(countLabel);

		totalLabel = new JLabel();
		productFilePanel.add(totalLabel);

		endFileLabel = new JLabel();
		productFilePanel.add(endFileLabel);

        // button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        // calculate button
        readButton = new JButton("����");
        readButton.addActionListener(this);
        buttonPanel.add(readButton);

        // exit button
        exitButton = new JButton("�˳�");
        exitButton.addActionListener(this);
        buttonPanel.add(exitButton);

        // add panels to main panel
        this.setLayout(new BorderLayout());
        this.add(productFilePanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        try {
        	fileReader = new TextFileReader(fileName);
		}
		catch (IOException e) {
			System.out.println(e);
		}
		count = 0;
		total = 0.0;
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == exitButton) {
			try {
				fileReader.closeFile();
			}
			catch (IOException io) {
				System.out.println(io);
			}
            System.exit(0);
		}
        else if (source == readButton) {
			try {
				String data = fileReader.getData();
				System.out.println(data);
				if (data != null) {
					token = new StringTokenizer(data, "|");
					String ID = token.nextToken();
					IDTextField.setText(ID);
					String title = token.nextToken();
					titleTextField.setText(title);
            		String price = token.nextToken();
            		priceTextField.setText(price);

            		infoLabel.setVisible(true);
            		infoTextField.setVisible(true);
            		infoTextField.setText(fileName);
            		countLabel.setText("�����¼:  " + ++count);

            		total += Double.parseDouble(price);
            		String totalString = Formatter.currency(total);
            		totalLabel.setText("��Ʒ�ܼۣ� " + totalString);
            		//data = fileReader.getData();
				}
				else
					endFileLabel.setText("����ȫ�����ݣ��ļ�������      ");
			}
			catch (IOException ioe) {
				System.out.println(ioe);
			}
        }
    }
}
