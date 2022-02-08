package Membership;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		Membership membership = new Membership();
		
		while(true) {
			System.out.println("**** 회원 정보 수정 프로그램 ****");
			System.out.print("1. 조회, 2. 수정, 3. 종료 : ");
			int ans = s.nextInt();
			if (ans == 1)
				// 조회
				membership.inquiry();
			else if(ans == 2) {
				// 수정
				System.out.print("수정할 회원 id 입력 : ");
				int id = s.nextInt();
				System.out.print("이름 : ");
				String name = s.next();
				System.out.print("적립 포인트 : ");
				int mileage = s.nextInt();
				
				membership.set(id, name, mileage);
			}
			else if(ans == 3)
				return;
		}
	}

}
