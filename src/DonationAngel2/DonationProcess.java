package DonationAngel2;

import java.util.Scanner;

public class DonationProcess {
	Scanner s;
	DonationCenter donateCenter;
	Donator donator;
	Recipient recipient;
	
	int cntDonate;
	
	void initialize() {
		s = new Scanner(System.in);
		donateCenter = new DonationCenter();
		donator = new Donator();
		recipient = new Recipient();
		
		cntDonate = 0;
	}
	
	void process() {
		System.out.print("기부금 목표액을 입력하세요 : ");
		donateCenter.setGoal(s.nextInt());
		
		while(true) {
			cntDonate += 1;
			System.out.print(cntDonate + "회차 기부금을 입력하세요 : ");
			int amount = s.nextInt();
			if(amount > 20) {
				cntDonate -= 1;
				System.out.println("기부금은 1회 20만원 이하만 가능합니다.");
				continue;
			}
			donator.donate(amount);
			
			if (donateCenter.getGoal() - donateCenter.getDonation() < 0) {
				System.out.println("목표액이 달성되었습니다! 총액 : " + donateCenter.getDonation() + "만원");
				System.out.println("총 " + cntDonate + "회 기부하셨습니다.");
				break;
			}
			
			recipient.receipt();
			System.out.println("후원금 총액 : " + donateCenter.getDonation() + "만원");
		}
	}
}
