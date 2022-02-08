package Shape;

public class Rectangle extends Shape {
	private double width, height;
	
	public Rectangle(String name, double width, double height) {
		super(name);
		this.width = width;
		this.height = height;
	}
	
	protected void calcArea() {
		area = width * height;
	}
	
	// ตัทน
	protected void calcPeriphery() {
		periphery = (2 * width) + (2 * height);
	}
}
