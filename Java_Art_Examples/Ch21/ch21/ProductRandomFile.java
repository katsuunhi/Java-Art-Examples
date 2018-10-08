package ch21;

//Product random file I/O class

import java.io.*;
import java.util.*;
import javax.swing.*;

class ProductRandomFile {
	RandomFile productFile;
	Scanner sc;
	private final int ID_LENGTH = 4;
	private final int TITLE_LENGTH = 32;
	private final int RECORD_SIZE = 80;
	private int recordNumber = 0;

	public ProductRandomFile(String fileName) {
		try {
			productFile = new RandomFile(fileName);
		}
		catch (FileNotFoundException fnf) {
			System.out.println(fnf);
		}
		sc = new Scanner(System.in);
   	}
   	public void createData() {
			String productID;
			String	title;
			double price;
			String choice = "y";
			while (choice.equalsIgnoreCase("y")) {
				try {
					System.out.println("文件现有记录数：" + productFile.getLength()/RECORD_SIZE);
					System.out.print("打入储存记录号: ");
					recordNumber = sc.nextInt();
					System.out.print("打入产品编号（4位数）: ");
					productID = sc.next();
					productID = RandomFile.FixedStringLength(productID, 4);
					sc.nextLine();
					System.out.print("打入产品名称（最多32字）: ");
					title = sc.nextLine();
					title = RandomFile.FixedStringLength(title, 32);

					System.out.print("打入产品价格: ");
					price = sc.nextDouble();
					productFile.setWriteRecordPos(recordNumber, RECORD_SIZE);
					productFile.outString(productID);
					productFile.outString(title);
					productFile.outDouble(price);
				}
				catch(Exception e) {
					sc.nextLine();   // discard the invalid price
					System.out.println("输入错误! 检查后再输入.\n");
					continue;    // jump to start of loop
				}
				System.out.print("继续？(y/n): ");
				choice = sc.next();
				System.out.println();
	        }
	}
	public void showData() {
		double price;
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			try {
				System.out.println("文件中现有记录数: "+ productFile.getLength()/RECORD_SIZE);
				System.out.print("打入要读入的纪录号: ");
				recordNumber = sc.nextInt();
				productFile.setReadRecordPos(recordNumber, RECORD_SIZE);
				System.out.println("产品编号: " + productFile.inString(ID_LENGTH));
				System.out.println("产品名称: " + productFile.inString(TITLE_LENGTH));
				price = productFile.inDouble();
				System.out.println("产品价格: " + Formatter.currency(price));
			}
			catch(IOException ioe) {
				System.out.println(ioe);
			}
			catch(Exception e) {
				sc.nextLine();   // discard the invalid price
				System.out.println("记录好必须是整数。检查后再输入。\n");
				continue;    // jump to start of loop
			}
			System.out.print("继续？(y/n): ");
			choice = sc.next();
			System.out.println();
		}
	}
	/*
	public static String getSelectedFile() {
		JFileChooser fc = new JFileChooser();
		fc.setDialogTitle("选择文件");
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int option = fc.showOpenDialog(null);
		if (option == JFileChooser.APPROVE_OPTION) {	//如果选择文件成功
		     File file = fc.getSelectedFile();
		     String fileName = file.toString();
		     return fileName;
		 }
		 else
		 	return null;
	}
	*/
   	public void closeFile() {
		try {
     		productFile.closeFile();
		}
		catch(IOException ioe) {
				System.out.println(ioe);
    	}
	}
}


