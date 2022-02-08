package T20_1_Mid_1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("최소공배수, 최대공약수를 계산할 숫자의 갯수 : ");
		int len = sc.nextInt();
		
		int[] arr = new int[len];
		for(int i = 0; i < len; i++) {
			System.out.print((i + 1) + "번째 숫자 입력 : ");
			arr[i] = sc.nextInt();
		}
		
		GcdLcm cal = new GcdLcm(arr);
		System.out.println("최대공약수 : " + cal.gcd());
		System.out.println("최소공배수 : " + cal.lcm());
	}

}
