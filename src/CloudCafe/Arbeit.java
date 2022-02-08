package CloudCafe;

import java.util.Scanner;

public class Arbeit {
	OrderSheet sheet;
	
	// �ֹ� ���� �Է�
	void takeOrder() {
		Scanner s = new Scanner(System.in);
	
		Beverage[] beverages = new Beverage[6];
		
		System.out.println("�ȳ��ϼ���! Cloud 9 �Դϴ�~");
		
		// �ֹ��� ����
		for (int cntOrder = 0; cntOrder < beverages.length; cntOrder++) {
			System.out.print("�ֹ��Ͻ� ���Ḧ �Է��ϼ��� : ");
			String[] order = s.nextLine().split(" ");
			// ���̽� ������ true, �ε��� �ϳ��� �̷Ｍ ����
			if(order[0].equals("���̽�"))
				beverages[cntOrder] = new Beverage(true, order[1], Integer.parseInt(order[2]));
			else if(order[0].equals("-1")) //order[0].contentEquals("-1")
				break;
			else 
				beverages[cntOrder] = new Beverage(false, order[0], Integer.parseInt(order[1]));
		}
		
		// ������ �ֹ����� ������ ����
		sheet = new OrderSheet(beverages);
	}
	
	// �� �ݾװ� ���� ����Ʈ �ȳ�
	void pay() {
		System.out.println("�� �ݾ��� " + sheet.getTotalAmount() + "�� �Դϴ�.");
		System.out.println("���� ����Ʈ�� " + sheet.getMileage() + "point �Դϴ�.");
	}
}