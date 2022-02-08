package Membership;

import java.util.Scanner;

// 조회 및 수정 구현
public class Membership {
	Member[] memberList = new Member[4];
	
	public Membership() {
		memberList[0] = new Member(1001L);
		memberList[1] = new Member(1002L, "박대환", 5300);
		memberList[2] = new Member(1003L, "Jake");
		memberList[3] = new Member(1004L, 7700);
	}
	
	void inquiry() {
		System.out.println("id\t name\t mileage");
		System.out.println("============================");
		System.out.println(memberList[0].toString());
		System.out.println(memberList[1].toString());
		System.out.println(memberList[2].toString());
		System.out.println(memberList[3].toString());
		System.out.println("============================");
	}
	
	void set(int id, String name, int mileage) {
		
		for(Member m : memberList) {
			if (m.getId() == id) {
				m.set(name);
				m.set(mileage);
			}
		}
		
		System.out.println("수정하였습니다.");
	}
}
