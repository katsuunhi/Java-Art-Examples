package ch21;

//Driver for ProductRandomFile2

public class ProductRandomFileApp2 {
    public static void main(String[] args) {
    	String fileName = ProductRandomFile2.getSelectedFile();
		if (fileName != null) {
			System.out.println("��ѡ�ļ�: " + fileName +"\n");
      		ProductRandomFile2 productFile = new ProductRandomFile2(fileName);
      		productFile.createData();
      		productFile.showData();
      		productFile.closeFile();
		}
		else
			System.out.println("�ļ�ѡ���������ļ�ϵͳ�����ԡ� ");
    }
}