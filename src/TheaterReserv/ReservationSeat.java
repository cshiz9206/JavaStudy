package TheaterReserv;

import java.util.Scanner;

public class ReservationSeat {
	Theater theater;
	
	void menu() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("=== �¼� ���� ���α׷� ===");
		while(true) {
			System.out.println("1. ��ȭ�� ����\n2. �¼� ����\n3. �¼� Ȯ��\n4. ����");
			System.out.print("�޴��� ������ �ּ���. : ");
			switch(sc.nextInt()) {
			case 1:
				System.out.println("1.�߿츮�ó׸� 2.�ް��ڽ� 3.CGV");
				System.out.print("��ȭ���� �������ּ��� : ");
				switch(sc.nextInt()) {
				case 1:
					theater = new Yawoori();
					break;
				case 2:
					theater = new Megabox();
					break;
				case 3:
					theater = new CGV();
					break;
				}
				break;
			case 2:
				theater.printWelcome();
				System.out.print("�¼��� ������ �ּ���. (A-C, 1-5) : ");
				// �¼��� string �迭�� �Է¹ް�, char, int�� ��ȯ
				String[] tmp = new Scanner(System.in).nextLine().split(",");
				theater.reserveSeat(tmp[0].charAt(0), Integer.parseInt(tmp[1]));
				break;
			case 3:
				theater.checkSeat();
				break;
			case 4:
				System.out.println("���α׷��� �����մϴ�.");
				return;
			}
		}
	}
}