package ch21;

//Driver for ProductRandomFile

public class ProductRandomFileApp {
    public static void main(String[] args) {
    	String fileName = "c:/java/Ch21/productFiles/products.dat";			//ָ������ļ�
  		ProductRandomFile productFile = new ProductRandomFile(fileName);	//����
  		productFile.createData();											//���������Ʒ��¼
  		productFile.showData();												//�����ʾ��Ʒ��¼
  		productFile.closeFile();											//�ر��ļ�
    }
}