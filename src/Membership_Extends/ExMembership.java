package Membership_Extends;

import java.util.Scanner;
import Membership.Member;

public class ExMembership extends Membership {
	
	protected void insert() {
		sc.nextLine();
		System.out.print("\"id �̸� ����Ʈ\"�� �Է��ϼ��� (id�� �ʼ�) : ");
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
		
		System.out.println("�߰��Ǿ����ϴ�.");
	}
	
	public void manage() {
		System.out.println("*** ȸ�� ���� ���� ���α׷� ***");
		while(true) {
			System.out.print("1. ��ȸ, 2. ����, 3. �߰�, 4. ���� : ");
			int ans = sc.nextInt();
			
			if(ans == 1) select();
			else if(ans == 2) update();
			else if(ans == 3) insert();
			else if(ans == 4) break;
		}
	}
}

// scanner �θ� Ŭ���� �����ڿ��� �����ϸ� �ȵǴ� ���� / �Լ����� ��������� �ϴ� ����
// �Է°� (id, �̸�, ����Ʈ) ���� ��� ���� �޴� ��
