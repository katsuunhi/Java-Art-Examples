//Demo: test this as return type

class Rectangle {
    private double x, y;
    private double width, height;

    public Rectangle() {
        this(0, 0, 0, 0);		//启动下面有4个参数的构造器
    }
    public Rectangle(int width, int height) {
        this(0, 0, width, height);				////启动下面有4个参数的构造器
    }
   public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
   public String toString() {
	   return ("x: " + x + " y: " + y + " width: " + width + " height: " + height);
   }
}

public class TestThisConstructorApp {
    public static void main(String[] args) {
        Rectangle rec1 = new Rectangle();
        Rectangle rec2 = new Rectangle(20, 30);
        System.out.println(rec1);
        System.out.println(rec2 );
    }
}
