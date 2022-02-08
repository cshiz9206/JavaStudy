package TheaterReserv;

import java.util.Scanner;

public class ReservationSeat {
	Theater theater;
	
	void menu() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("=== 좌석 예약 프로그램 ===");
		while(true) {
			System.out.println("1. 영화관 선택\n2. 좌석 예약\n3. 좌석 확인\n4. 종료");
			System.out.print("메뉴를 선택해 주세요. : ");
			switch(sc.nextInt()) {
			case 1:
				System.out.println("1.야우리시네마 2.메가박스 3.CGV");
				System.out.print("영화관을 선택해주세요 : ");
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
				System.out.print("좌석을 선택해 주세요. (A-C, 1-5) : ");
				// 좌석을 string 배열로 입력받고, char, int로 변환
				String[] tmp = new Scanner(System.in).nextLine().split(",");
				theater.reserveSeat(tmp[0].charAt(0), Integer.parseInt(tmp[1]));
				break;
			case 3:
				theater.checkSeat();
				break;
			case 4:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
}