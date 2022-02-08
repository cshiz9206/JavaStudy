package CloudCafe;

// 음료 주문 정보
public class Beverage {
	String type;
	int count;
	boolean ice = false;
	
	Beverage(boolean ice, String type, int count){
		this.ice = ice;
		this.type = type;
		this.count = count;
	}
	
	//음료 주문 정보 생성
	Beverage(String type, int count) {
		this.type = type;
		this.count = count;
	}
}
