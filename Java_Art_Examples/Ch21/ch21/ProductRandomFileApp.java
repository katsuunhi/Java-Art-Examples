package ch21;

//Driver for ProductRandomFile

public class ProductRandomFileApp {
    public static void main(String[] args) {
    	String fileName = "c:/java/Ch21/productFiles/products.dat";			//指定随机文件
  		ProductRandomFile productFile = new ProductRandomFile(fileName);	//创建
  		productFile.createData();											//随机创建产品记录
  		productFile.showData();												//随机显示产品记录
  		productFile.closeFile();											//关闭文件
    }
}