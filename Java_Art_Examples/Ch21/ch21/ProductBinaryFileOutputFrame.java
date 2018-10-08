package ch21;

//product Binary file output Frame and panel

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

class ProductBinaryFileOutputFrame extends JFrame {
    ProductBinaryFileOutputFrame() {
        setTitle("产品二进制文件输出程序");
        centerWindow(this);
        setSize(300, 220);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new ProductFileOutputPanel();
        this.add(panel);
    }

    private void centerWindow(Window w) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        setLocation((d.width-w.getWidth())/2, (d.height-w.getHeight())/2);
    }
}

class ProductFileOutputPanel extends JPanel implements ActionListener {
    private JTextField  IDTextField,
                        titleTextField,
                        priceTextField,
                        infoTextField;
    private JLabel      IDLabel,
                        titleLabel,
                        priceLabel,
                        infoLabel,
                        countLabel;
    private JButton     saveButton,
                        exitButton;

    private BinayFileOutput fileOutput;
    private String fileName = "C:/java/Ch21/productFiles/products.dat";
    private int count;


    public ProductFileOutputPanel() {
        // display panel
        JPanel productFilePanel = new JPanel();
        productFilePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        // payment label
        IDLabel = new JLabel("产品编号:");
        productFilePanel.add(IDLabel);

        // payment text field
        IDTextField = new JTextField(20);
        productFilePanel.add(IDTextField);

        // rate label
        titleLabel = new JLabel("产品名:");
        productFilePanel.add(titleLabel);

        // rate text field
        titleTextField = new JTextField(20);
        productFilePanel.add(titleTextField);

        // years label
        priceLabel = new JLabel("产品价格:");
        productFilePanel.add(priceLabel);

        // years text field
        priceTextField = new JTextField(20);
        productFilePanel.add(priceTextField);

        // future value label
        infoLabel = new JLabel("数据存至:");
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

        // button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        // calculate button
        saveButton = new JButton("保存");
        saveButton.addActionListener(this);
        buttonPanel.add(saveButton);

        // exit button
        exitButton = new JButton("退出");
        exitButton.addActionListener(this);
        buttonPanel.add(exitButton);

        // add panels to main panel
        this.setLayout(new BorderLayout());
        this.add(productFilePanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        try {
        	fileOutput = new BinayFileOutput(fileName, true);
		}
		catch (IOException e) {
			System.out.println(e);
		}
		count = 0;
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == exitButton) {
			try {
				fileOutput.closeFile();
			}
			catch (IOException io) {
				System.out.println(io);
			}
            System.exit(0);
		}
        else if (source == saveButton) {
            String ID = IDTextField.getText();
            String title = titleTextField.getText();
            String price = priceTextField.getText();
            try {
            	fileOutput.outUTF(ID);
            	fileOutput.outUTF(title);
            	fileOutput.outDouble(Double.parseDouble(price));
			}
			catch (IOException ioe) {
				System.out.println(ioe);
			}
            IDTextField.setText("");
            titleTextField.setText("");
            priceTextField.setText("");

            infoLabel.setVisible(true);
            infoTextField.setVisible(true);
            infoTextField.setText(fileName);
            countLabel.setText("共数据:                " + ++count);
        }
    }
}
