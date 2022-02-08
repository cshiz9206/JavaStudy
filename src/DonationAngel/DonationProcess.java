package DonationAngel;

import java.util.Scanner;

public class DonationProcess {
	DonationCenter donateCenter;
	Donator donator;
	Recipient recipient;
	Scanner s;
	
	int donateCnt;
	
	// 각종 변수, 객체 생성
	void initialize() {
		donateCenter = new DonationCenter();
		donator = new Donator();
		recipient = new Recipient();
		s = new Scanner(System.in);
		
		donateCnt = 1;
	}
	
	void process() {
		// 기부 프로세스 실행
		// 후원금 목표치 달성시 종료
		while(true) { 
			System.out.print("기부금 목표액을 입력하세요 : ");
			if((donateCenter.goal = s.nextInt()) <= 100) break; 
		}
		
		while(true) {
			System.out.print(donateCnt + "회차 기부금을 입력하세요  : ");
			if (donator.donate(s.nextInt())) {
				
				// 목표액 달성 검사
				if (donateCenter.donation >= donateCenter.goal) {
					System.out.println("목표액이 달성되었습니다! 총액 : " + donateCenter.donation + "만원");
					System.out.println("총 " + donateCnt + "회 기부하셨습니다.");
					break;
				}
				
				// 기부금 지출
				recipient.receipt();
				System.out.println("후원금 총액 : " + donateCenter.donation + "만원");
				donateCnt += 1;
			}

		}
	}
	
	public static void main(String[] args) {
	// TODO Auto-generated method stub
		DonationProcess dp = new DonationProcess();
		dp.initialize();
		dp.process();
	}
}
