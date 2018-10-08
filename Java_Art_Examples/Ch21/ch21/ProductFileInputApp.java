package ch21;

public class ProductFileInputApp {
    public static void main(String[] args) {
		String fileName = "C:/java/Ch21/productFiles/objects.dat";

		ProductFileInput in = new ProductFileInput();

		in.createInputfile(fileName);
		in.showData();
		in.closeInputFile();
    }
}