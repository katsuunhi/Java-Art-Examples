package ch21;

//Class used to create GZIP file

import java.io.*;
import java.util.zip.*;
import javax.swing.*;

public class MyFile {
	public static void createGzip() {
		GZIPOutputStream out;
		FileInputStream in;
		String gzipFileName;
		String sourceFileName;
		File gzipFile = null;
		File sourceFile = null;
		JOptionPane.showMessageDialog(null, "����ȷ�������ļ�ѡ������ѡ������Ҫ������GZIP�ļ�����\n"
										+ "��ʹ��.gz��Ϊѹ���ļ�����׺��");
		gzipFileName = getFileName();

		gzipFile = verify(gzipFileName);

		JOptionPane.showMessageDialog(null, "ѹ���ļ��� " + gzipFile.toString() + "�ѽ�����\n"
										+ "����ȷ�������ļ�ѡ������ѡ��Ҫѹ����Դ�ļ�����");
		sourceFileName = getFileName();
		sourceFile = verify(sourceFileName);
		try {
			out = new GZIPOutputStream(new FileOutputStream(gzipFileName));
				in = new FileInputStream(sourceFileName);
			// Transfer bytes from the input file
			// to the gzip output stream
			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			in.close();
			long sourceLength = sourceFile.length();
			// Finish creation of gzip file
			out.finish();
			out.close();
			long gzipLength = gzipFile.length();
			String message = "�ļ�ѹ��������\nԴ�ļ����ȣ�"
							+ getKB(sourceLength) + " KB\n"
							+ "ѹ�����ļ����ȣ�"
							+ getKB(gzipLength) + " KB\n";
			JOptionPane.showMessageDialog(null, message);
		}
		catch (IOException ioe) {
			System.out.println(ioe);
		}
	}
	private static String getFileName() {
		String fileName;
		JFileChooser fc = new JFileChooser();
		fc.setDialogTitle("�����ļ�����ѡ���ļ���");
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fc.setApproveButtonToolTipText("ѡ�������ļ������ٰ���ȷ����");
		fc.setApproveButtonText("ȷ��");
		int option = fc.showOpenDialog(null);
		if (option == JFileChooser.APPROVE_OPTION) {	//���ѡ���ļ��ɹ�
			 File file = fc.getSelectedFile();
			 fileName = file.toString();
			 return fileName;
		 }
		else
			 return null;
	}
	private static File verify(String fileName) {
		try {
			File gzipFile = new File(fileName);
			return gzipFile;
		}
		catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "��ѡ��ȡ����������");
			System.exit(2);
			return null;
		}
	}

	private static int getKB(long length) {
		return (int) (length/1024);
	}
	public static void unZip() {
		GZIPInputStream gzipIn;
		OutputStream out;
		String gzipFileName; // = "c:\articles\examplegzip.gz";
		String outFileName;
		File gzipFile = null;
		File outFile = null;

		JOptionPane.showMessageDialog(null, "����ȷ�������ļ�ѡ������ѡ��Ҫ��ѹ�ĵ�GZIP�ļ�����");
		gzipFileName = getFileName();
		gzipFile = verify(gzipFileName);
		JOptionPane.showMessageDialog(null, "��ѹ�ļ���" + gzipFile.toString() + "\n"
										+ "����ȷ�������ļ�ѡ������ѡ�������ѹ����ļ�����\n"
										+ "�������ȷ�ļ�����׺��");
		outFileName = getFileName();
		outFile = verify(outFileName);
		try {
			gzipIn = new GZIPInputStream(new FileInputStream(gzipFileName));
			out = new FileOutputStream(outFileName);
			// Transfer bytes from the compressed file to the output file
			byte[] buf = new byte[1024];
			int len;
			while ((len = gzipIn.read(buf)) > 0) {
			out.write(buf, 0, len);
			}
			// Close the file and stream
			gzipIn.close();
			out.close();
			JOptionPane.showMessageDialog(null, "��ѹ�ɹ�������");
		}
		catch (IOException ioe) {
			System.out.println(ioe);
		}
	}

}