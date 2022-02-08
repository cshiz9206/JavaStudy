package Membership_Extends;

import java.util.Scanner;

import Membership.Member;

public class Membership {
	public static final int MAX_MEMBER = 10;
	protected Scanner sc;
	protected Member[] memberList;
	
	public Membership() {
		sc = new Scanner(System.in);
		memberList = new Member[MAX_MEMBER];
	}
	
	protected void select() {
		if(memberList[0] == null) {
			System.out.println("(���� ����)");
			return;
		}
		
		System.out.println("id\t name\t mileage");
		System.out.println("============================");
		for (int i = 0; i < memberList.length; i++) {
			if(memberList[i] == null) break;
			System.out.println(memberList[i].toString());
		}
		System.out.println("============================");
	}
	
	protected void update() {
		System.out.print("������ ȸ�� id �Է� : ");
		int id = sc.nextInt();
		System.out.print("�̸� : ");
		sc.nextLine(); // ���๮�� ����
		String name = sc.nextLine();
		System.out.print("���� ����Ʈ : ");
		int mileage = sc.nextInt();
		
		for(Member m : memberList) {
			if(m != null) {
				if (m.getId() == id) {
					m.set(name);
					m.set(mileage);
				}
			}
		}
		
		System.out.println("�����Ͽ����ϴ�.");
	}
	
	// manage() �� �� �ۼ��ϴ� ����?
	public void manage() {
		System.out.println("*** ȸ�� ���� ���� ���α׷� ***");
		while(true) {
			System.out.print("1. ��ȸ, 2. ����, 3. ���� : ");
			int ans = sc.nextInt();
			
			if(ans == 1) select();
			else if(ans == 2) update();
			else if(ans == 3) break;
		}
	}
}
