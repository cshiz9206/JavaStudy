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
		System.out.print("��α� ��ǥ���� �Է��ϼ��� : ");
		donateCenter.setGoal(s.nextInt());
		
		while(true) {
			cntDonate += 1;
			System.out.print(cntDonate + "ȸ�� ��α��� �Է��ϼ��� : ");
			int amount = s.nextInt();
			if(amount > 20) {
				cntDonate -= 1;
				System.out.println("��α��� 1ȸ 20���� ���ϸ� �����մϴ�.");
				continue;
			}
			donator.donate(amount);
			
			if (donateCenter.getGoal() - donateCenter.getDonation() < 0) {
				System.out.println("��ǥ���� �޼��Ǿ����ϴ�! �Ѿ� : " + donateCenter.getDonation() + "����");
				System.out.println("�� " + cntDonate + "ȸ ����ϼ̽��ϴ�.");
				break;
			}
			
			recipient.receipt();
			System.out.println("�Ŀ��� �Ѿ� : " + donateCenter.getDonation() + "����");
		}
	}
}
