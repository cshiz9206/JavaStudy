package Shape;

public class Circle extends Shape{
	private double r;
	
	public Circle(String name, double r) {
		super(name);
		this.r = r;
	}
	
	protected void calcArea() {
		area = r * r * Math.PI;
	}
	
	
	// �ѷ�
	protected void calcPeriphery() {
		periphery = 2 * r * Math.PI;
	}
}
