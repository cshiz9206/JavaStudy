package CloudCafe;

// 음료 주문 정보가 적힌 주문서
public class OrderSheet {
	Beverage[] beverages;
	int total;
	
	OrderSheet(Beverage[] beverages){
		this.beverages = beverages;
	}
	
	// 해당 주문에 대한 총 금액 반환
	int getTotalAmount() {
		total = 0;
		for (Beverage bvg : beverages) {
			if(bvg != null) {
				if(bvg.ice && bvg.type.equals("아메리카노")) total += 2200 * bvg.count;
				if(bvg.ice && bvg.type.equals("바닐라라떼")) total += 3200 * bvg.count;
				if(bvg.ice && bvg.type.equals("카라멜마끼아또")) total += 4200 * bvg.count;
				if(!bvg.ice && bvg.type.equals("아메리카노")) total += 2000 * bvg.count;
				if(!bvg.ice && bvg.type.equals("바닐라라떼")) total += 3000 * bvg.count;
				if(!bvg.ice && bvg.type.equals("카라멜마끼아또")) total += 4000 * bvg.count;
			}
		}
		return total;
	}
	
	// 해당 주문에 대한 적립 포인트 반환
	int getMileage() {
		// 포인트는 총 주문 금액의 5%, 원단위 절삭
		return (int)(total * 0.05);
	}
}
