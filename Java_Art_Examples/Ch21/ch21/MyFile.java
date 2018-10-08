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
		JOptionPane.showMessageDialog(null, "按下确定后在文件选择器中选择或打入要产生的GZIP文件名。\n"
										+ "请使用.gz作为压缩文件名后缀。");
		gzipFileName = getFileName();

		gzipFile = verify(gzipFileName);

		JOptionPane.showMessageDialog(null, "压缩文件名 " + gzipFile.toString() + "已建立。\n"
										+ "按下确定后在文件选择器中选择要压缩的源文件名。");
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
			String message = "文件压缩结束。\n源文件长度："
							+ getKB(sourceLength) + " KB\n"
							+ "压缩后文件长度："
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
		fc.setDialogTitle("创建文件或者选择文件名");
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fc.setApproveButtonToolTipText("选择或打入文件名，再按下确定。");
		fc.setApproveButtonText("确定");
		int option = fc.showOpenDialog(null);
		if (option == JFileChooser.APPROVE_OPTION) {	//如果选择文件成功
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
			JOptionPane.showMessageDialog(null, "您选择取消程序运行");
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

		JOptionPane.showMessageDialog(null, "按下确定后在文件选择器中选择要解压的的GZIP文件名。");
		gzipFileName = getFileName();
		gzipFile = verify(gzipFileName);
		JOptionPane.showMessageDialog(null, "解压文件：" + gzipFile.toString() + "\n"
										+ "按下确定后在文件选择器中选择或打入解压后的文件名。\n"
										+ "请打入正确文件名后缀。");
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
			JOptionPane.showMessageDialog(null, "解压成功结束。");
		}
		catch (IOException ioe) {
			System.out.println(ioe);
		}
	}

}