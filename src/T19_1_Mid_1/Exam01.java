package T19_1_Mid_1;

import java.util.Random;

public class Exam01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exam01 ex = new Exam01();
		Random rd = new Random();
		
		System.out.println("=== �ִ�����, �ּҰ���� ���� ===");
		System.out.println("���� ����");
		
		int[] arr = new int[rd.nextInt(7) + 4];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = rd.nextInt(100) + 1;
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		GcdLcm cal = new GcdLcm(arr);
		
		System.out.println("�ִ����� : " + cal.gcd());
		System.out.println("�ּҰ���� : " + cal.lcm());
	}
	
//	public int gcd(int[] arr) {
//		int result = 100;
//		for(int i = 0; i < arr.length; i++) {
//			if(arr[i] % result != 0) {
//				i = 0;
//				result -= 1;
//				continue;
//			}
//		}
//		return result;
//	}
//	
//	public long lcm(int[] arr) {
//		long result = 1;
//		for(int i = 0; i < arr.length; i++) {
//			if(result % arr[i] != 0) {
//				i = -1;
//				result += 1;
//				continue;
//			}
//		}
//		return result;
//	}
}
