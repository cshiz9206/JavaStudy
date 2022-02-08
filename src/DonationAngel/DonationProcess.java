package DonationAngel;

import java.util.Scanner;

public class DonationProcess {
	DonationCenter donateCenter;
	Donator donator;
	Recipient recipient;
	Scanner s;
	
	int donateCnt;
	
	// ���� ����, ��ü ����
	void initialize() {
		donateCenter = new DonationCenter();
		donator = new Donator();
		recipient = new Recipient();
		s = new Scanner(System.in);
		
		donateCnt = 1;
	}
	
	void process() {
		// ��� ���μ��� ����
		// �Ŀ��� ��ǥġ �޼��� ����
		while(true) { 
			System.out.print("��α� ��ǥ���� �Է��ϼ��� : ");
			if((donateCenter.goal = s.nextInt()) <= 100) break; 
		}
		
		while(true) {
			System.out.print(donateCnt + "ȸ�� ��α��� �Է��ϼ���  : ");
			if (donator.donate(s.nextInt())) {
				
				// ��ǥ�� �޼� �˻�
				if (donateCenter.donation >= donateCenter.goal) {
					System.out.println("��ǥ���� �޼��Ǿ����ϴ�! �Ѿ� : " + donateCenter.donation + "����");
					System.out.println("�� " + donateCnt + "ȸ ����ϼ̽��ϴ�.");
					break;
				}
				
				// ��α� ����
				recipient.receipt();
				System.out.println("�Ŀ��� �Ѿ� : " + donateCenter.donation + "����");
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
