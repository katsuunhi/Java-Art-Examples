package ch21;

public class ProductObjectFileOutputApp {
    public static void main(String[] args) {
		String fileName = "C:/java/Ch21/productFiles/objects.dat";

		ProductFileOutput out = new ProductFileOutput();

		out.createOutputfile(fileName);
		out.createData();
		out.closeOutputFile();
    }
}