package T18_1_01_Mid_1;

import java.util.Scanner;

public class Exam01 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Exam01 ex = new Exam01();
		while(true) {
			System.out.println("=== 진수 변환기 ===");
			System.out.print("10진수 입력 : ");
			int num = sc.nextInt();
			System.out.println("입력받은 10진수 : " + num);
			System.out.print(num + "의 2진수 표기 : ");
			int[] result = ex.trans_bin(num);
			for(int i : result) System.out.print(i);
			System.out.println();
			System.out.print(num + "의 16진수 표기 : 0x");
			String[] resultHex = ex.trans_hex(num);
			for(String s : resultHex) System.out.print(s);
			System.out.println();
			System.out.println();
		}
	}	
	
	int[] trans_bin(int num) {
		int[] bin = new int[7];
		for(int i = bin.length - 1; i >= 0; i--) {
			bin[i] = num % 2;
			num = num / 2;
		}
		
		return bin;
	}
	
	String[] trans_hex(int num) {
		String[] hex = new String[2];
		for(int i = hex.length - 1; i >= 0; i--) {
			int tmp = num % 16;
			if(tmp == 10) hex[i] = "A";
			else if(tmp == 11) hex[i] = "B";
			else if(tmp == 12) hex[i] = "C";
			else if(tmp == 13) hex[i] = "D";
			else if(tmp == 14) hex[i] = "E";
			else if(tmp == 15) hex[i] = "F";
			else hex[i] = String.valueOf(tmp);
			num = num / 16;
		}
		
		return hex;
	}
}
