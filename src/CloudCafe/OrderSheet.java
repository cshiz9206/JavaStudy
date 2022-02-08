package CloudCafe;

// ���� �ֹ� ������ ���� �ֹ���
public class OrderSheet {
	Beverage[] beverages;
	int total;
	
	OrderSheet(Beverage[] beverages){
		this.beverages = beverages;
	}
	
	// �ش� �ֹ��� ���� �� �ݾ� ��ȯ
	int getTotalAmount() {
		total = 0;
		for (Beverage bvg : beverages) {
			if(bvg != null) {
				if(bvg.ice && bvg.type.equals("�Ƹ޸�ī��")) total += 2200 * bvg.count;
				if(bvg.ice && bvg.type.equals("�ٴҶ��")) total += 3200 * bvg.count;
				if(bvg.ice && bvg.type.equals("ī��Ḷ���ƶ�")) total += 4200 * bvg.count;
				if(!bvg.ice && bvg.type.equals("�Ƹ޸�ī��")) total += 2000 * bvg.count;
				if(!bvg.ice && bvg.type.equals("�ٴҶ��")) total += 3000 * bvg.count;
				if(!bvg.ice && bvg.type.equals("ī��Ḷ���ƶ�")) total += 4000 * bvg.count;
			}
		}
		return total;
	}
	
	// �ش� �ֹ��� ���� ���� ����Ʈ ��ȯ
	int getMileage() {
		// ����Ʈ�� �� �ֹ� �ݾ��� 5%, ������ ����
		return (int)(total * 0.05);
	}
}
