package Membership_Extends;

import java.util.Scanner;
import Membership.Member;

public class ExMembership extends Membership {
	
	protected void insert() {
		sc.nextLine();
		System.out.print("\"id 이름 포인트\"를 입력하세요 (id값 필수) : ");
		String inf = sc.nextLine();
		
		String[] infs = inf.split(" ");
		String name = "(none)";
		int mileage = 0;
		int id = Integer.parseInt(infs[0]);
		if (infs.length >= 2) {
			boolean isNumeric = true;
			for(int i = 0; i < infs[1].length(); i++) {
				if(!Character.isDigit(infs[1].charAt(i))) isNumeric = false;
			}
			
			if(isNumeric) mileage = Integer.parseInt(infs[1]);
			else name = infs[1];
		}
		if (infs.length == 3) mileage = Integer.parseInt(infs[2]);
		
		for (int i = 0; i < memberList.length; i++) {
			if(memberList[i] == null) {
				memberList[i] = new Member(id, name, mileage);
				break;
			}
		}
		
		System.out.println("추가되었습니다.");
	}
	
	public void manage() {
		System.out.println("*** 회원 정보 관리 프로그램 ***");
		while(true) {
			System.out.print("1. 조회, 2. 수정, 3. 추가, 4. 종료 : ");
			int ans = sc.nextInt();
			
			if(ans == 1) select();
			else if(ans == 2) update();
			else if(ans == 3) insert();
			else if(ans == 4) break;
		}
	}
}

// scanner 부모 클래스 생성자에만 선언하면 안되는 이유 / 함수마다 생성해줘야 하는 이유
// 입력값 (id, 이름, 포인트) 순서 상관 없이 받는 법
