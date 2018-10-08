package ch23;

//Multi-tier client application
import java.net.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MultiTierClientFrame extends JFrame{
   public MultiTierClientFrame(){
      setTitle("Request to Server and Database");

      Toolkit tk = Toolkit.getDefaultToolkit();
      Dimension d = tk.getScreenSize();
      int width = 500;
      int height = 245;
      setBounds((int) (d.width-width)/2,
                (int) (d.height-height)/2, width, height);
      addWindowListener(new WindowAdapter(){
         public void windowClosing(WindowEvent e){
            System.exit(0);
         }
      });
      JPanel panel = new MultiTierClientPanel();
      add(panel);
   }
   public static void main(String[] args){
      JFrame frame = new MultiTierClientFrame();
      frame.setVisible(true);
   }
}
class MultiTierClientPanel extends JPanel implements ActionListener{
   JComboBox productComboBox; //, sizeComboBox, colorComboBox;
   JRadioButton allRadio, lessRadio, moreRadio;
   JTextArea textArea;
   JButton okButton, exitButton;
   Socket clientSocket;
   InputStream inData;
   OutputStream outData;
   PrintWriter toServer;
   Scanner data;

   public MultiTierClientPanel(){
      String[] items = {"Products", "Books"};
      productComboBox = new JComboBox(items);
      productComboBox.setSelectedItem("Products");

	  allRadio =  new JRadioButton("所有记录", true);			//创建并预选
	  lessRadio = new JRadioButton(">=100元");

	  ButtonGroup priceGroup = new ButtonGroup();	//创建按钮组
	  priceGroup.add(allRadio);						//注册到按钮组
	  priceGroup.add(lessRadio);
      JPanel northPanel = new JPanel();
      northPanel.add(productComboBox);
      northPanel.add(allRadio);
      northPanel.add(lessRadio);

      setLayout(new BorderLayout());
      add(northPanel, BorderLayout.NORTH);

      textArea = new JTextArea(10, 30);
      JPanel centerPanel = new JPanel();
	  centerPanel.add(textArea);
	  add(centerPanel, BorderLayout.CENTER);

      okButton = new JButton("提交");
      exitButton = new JButton("退出");
      okButton.addActionListener(this);					//注册到事件处理接口
	  exitButton.addActionListener(this);

	  JPanel southPanel = new JPanel();
	  southPanel.add(okButton);
      southPanel.add(exitButton);
      add(southPanel, BorderLayout.SOUTH);

      connectToServer();
   }
   public void actionPerformed(ActionEvent e) {		//完善事件处理接口方法
   		Object source = e.getSource();				//得到事件发生源
   		if (source == okButton) {
			connectToServer();
			String requestedDb = productComboBox.getSelectedItem().toString();
			int requestedPrice = 0;
   		    if (lessRadio.isSelected())
   			  requestedPrice = 1;

   			toServer.println(requestedDb);
   			toServer.println(requestedPrice);

   			textArea.setText("");
   			while (data.hasNextLine()) {
			  String fromServer = data.nextLine();
			  textArea.append(fromServer + "\n");
		    }
   		}
   		else if (source == exitButton) {
			try {
			 	toServer.close();
		     	clientSocket.close();
			}
			catch (IOException ex) {
			    ex.printStackTrace();
		    }
		    System.exit(0);
		}
	}
	private void connectToServer() {
		try {
			   clientSocket = new Socket("localhost", 1688);
			   textArea.setText("Conected to the server and database...");
			   inData = clientSocket.getInputStream();
			   outData = clientSocket.getOutputStream();
			   toServer = new PrintWriter(outData, true);
			   data = new Scanner(inData);
			 }
			 catch (IOException e) {
			   e.printStackTrace();
		 }
	}
}

