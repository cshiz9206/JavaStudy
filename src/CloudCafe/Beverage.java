package CloudCafe;

// ���� �ֹ� ����
public class Beverage {
	String type;
	int count;
	boolean ice = false;
	
	Beverage(boolean ice, String type, int count){
		this.ice = ice;
		this.type = type;
		this.count = count;
	}
	
	//���� �ֹ� ���� ����
	Beverage(String type, int count) {
		this.type = type;
		this.count = count;
	}
}
