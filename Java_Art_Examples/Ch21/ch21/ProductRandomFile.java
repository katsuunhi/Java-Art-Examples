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
					System.out.println("�ļ����м�¼����" + productFile.getLength()/RECORD_SIZE);
					System.out.print("���봢���¼��: ");
					recordNumber = sc.nextInt();
					System.out.print("�����Ʒ��ţ�4λ����: ");
					productID = sc.next();
					productID = RandomFile.FixedStringLength(productID, 4);
					sc.nextLine();
					System.out.print("�����Ʒ���ƣ����32�֣�: ");
					title = sc.nextLine();
					title = RandomFile.FixedStringLength(title, 32);

					System.out.print("�����Ʒ�۸�: ");
					price = sc.nextDouble();
					productFile.setWriteRecordPos(recordNumber, RECORD_SIZE);
					productFile.outString(productID);
					productFile.outString(title);
					productFile.outDouble(price);
				}
				catch(Exception e) {
					sc.nextLine();   // discard the invalid price
					System.out.println("�������! ����������.\n");
					continue;    // jump to start of loop
				}
				System.out.print("������(y/n): ");
				choice = sc.next();
				System.out.println();
	        }
	}
	public void showData() {
		double price;
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			try {
				System.out.println("�ļ������м�¼��: "+ productFile.getLength()/RECORD_SIZE);
				System.out.print("����Ҫ����ļ�¼��: ");
				recordNumber = sc.nextInt();
				productFile.setReadRecordPos(recordNumber, RECORD_SIZE);
				System.out.println("��Ʒ���: " + productFile.inString(ID_LENGTH));
				System.out.println("��Ʒ����: " + productFile.inString(TITLE_LENGTH));
				price = productFile.inDouble();
				System.out.println("��Ʒ�۸�: " + Formatter.currency(price));
			}
			catch(IOException ioe) {
				System.out.println(ioe);
			}
			catch(Exception e) {
				sc.nextLine();   // discard the invalid price
				System.out.println("��¼�ñ��������������������롣\n");
				continue;    // jump to start of loop
			}
			System.out.print("������(y/n): ");
			choice = sc.next();
			System.out.println();
		}
	}
	/*
	public static String getSelectedFile() {
		JFileChooser fc = new JFileChooser();
		fc.setDialogTitle("ѡ���ļ�");
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int option = fc.showOpenDialog(null);
		if (option == JFileChooser.APPROVE_OPTION) {	//���ѡ���ļ��ɹ�
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


