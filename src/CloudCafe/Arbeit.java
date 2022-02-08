package CloudCafe;

import java.util.Scanner;

public class Arbeit {
	OrderSheet sheet;
	
	// 주문 음료 입력
	void takeOrder() {
		Scanner s = new Scanner(System.in);
	
		Beverage[] beverages = new Beverage[6];
		
		System.out.println("안녕하세요! Cloud 9 입니다~");
		
		// 주문서 생성
		for (int cntOrder = 0; cntOrder < beverages.length; cntOrder++) {
			System.out.print("주문하실 음료를 입력하세요 : ");
			String[] order = s.nextLine().split(" ");
			// 아이스 있으면 true, 인덱스 하나씩 미뤄서 생성
			if(order[0].equals("아이스"))
				beverages[cntOrder] = new Beverage(true, order[1], Integer.parseInt(order[2]));
			else if(order[0].equals("-1")) //order[0].contentEquals("-1")
				break;
			else 
				beverages[cntOrder] = new Beverage(false, order[0], Integer.parseInt(order[1]));
		}
		
		// 생성한 주문서로 영수증 생성
		sheet = new OrderSheet(beverages);
	}
	
	// 총 금액과 적립 포인트 안내
	void pay() {
		System.out.println("총 금액은 " + sheet.getTotalAmount() + "원 입니다.");
		System.out.println("적립 포인트는 " + sheet.getMileage() + "point 입니다.");
	}
}