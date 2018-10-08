public class OtherClass  //demo of object name reuse
{
	private double x;
	public OtherClass() {
		x = 0.0;
	}

	public OtherClass(double x) {	//constructor overloading
			this.x = x;
	}

	public void setX(double x) {
		this.x = x;
	}
	public double getX() {
		return x;
	}

}