package T20_1_Mid_1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�ּҰ����, �ִ������� ����� ������ ���� : ");
		int len = sc.nextInt();
		
		int[] arr = new int[len];
		for(int i = 0; i < len; i++) {
			System.out.print((i + 1) + "��° ���� �Է� : ");
			arr[i] = sc.nextInt();
		}
		
		GcdLcm cal = new GcdLcm(arr);
		System.out.println("�ִ����� : " + cal.gcd());
		System.out.println("�ּҰ���� : " + cal.lcm());
	}

}
