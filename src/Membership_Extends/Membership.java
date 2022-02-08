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
			System.out.println("(정보 없음)");
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
		System.out.print("수정할 회원 id 입력 : ");
		int id = sc.nextInt();
		System.out.print("이름 : ");
		sc.nextLine(); // 개행문자 제거
		String name = sc.nextLine();
		System.out.print("적립 포인트 : ");
		int mileage = sc.nextInt();
		
		for(Member m : memberList) {
			if(m != null) {
				if (m.getId() == id) {
					m.set(name);
					m.set(mileage);
				}
			}
		}
		
		System.out.println("수정하였습니다.");
	}
	
	// manage() 두 번 작성하는 이유?
	public void manage() {
		System.out.println("*** 회원 정보 관리 프로그램 ***");
		while(true) {
			System.out.print("1. 조회, 2. 수정, 3. 종료 : ");
			int ans = sc.nextInt();
			
			if(ans == 1) select();
			else if(ans == 2) update();
			else if(ans == 3) break;
		}
	}
}
