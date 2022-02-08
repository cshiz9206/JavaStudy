package Shape;

public class Triangle extends Shape {
	private double a, b, c;
	
	public Triangle(String name, double a, double b, double c) {
		super(name);
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	protected void calcArea() {
		double k = (a + b + c) / 2;
		area = Math.sqrt(k * (k - a) * (k - b) * (k - c));
	}
	
	protected void calcPeriphery() {
		periphery = a + b + c;
	}
}
