//the driver class for CircleShapes

public class CircleShapeApp{

	public static void main(String[] args) {
 		Circle circle = new Circle(12.98);
 		Sphere sphere = new Sphere(25.55);

 		Shape shape = circle;

 		shape.computeArea();
 		shape.computeVolume();
 		System.out.println("circle area: " + shape.getArea());
 		System.out.println("circle volume: " + shape.getVolume());

/*
		shape = myCircle;
 		shape.computeArea();
 		shape.computeVolume();
 		System.out.println("my circle area: " + shape.getArea());
 		System.out.println("my circle volume: " + shape.getVolume());
*/
		shape = sphere;
 		shape.computeArea();
 		shape.computeVolume();
 		System.out.println("Sphere area: " + shape.getArea());
 		System.out.println("Sphere volume: " + shape.getVolume());
 	}

}
