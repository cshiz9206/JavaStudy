package Membership;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		Membership membership = new Membership();
		
		while(true) {
			System.out.println("**** ȸ�� ���� ���� ���α׷� ****");
			System.out.print("1. ��ȸ, 2. ����, 3. ���� : ");
			int ans = s.nextInt();
			if (ans == 1)
				// ��ȸ
				membership.inquiry();
			else if(ans == 2) {
				// ����
				System.out.print("������ ȸ�� id �Է� : ");
				int id = s.nextInt();
				System.out.print("�̸� : ");
				String name = s.next();
				System.out.print("���� ����Ʈ : ");
				int mileage = s.nextInt();
				
				membership.set(id, name, mileage);
			}
			else if(ans == 3)
				return;
		}
	}

}
