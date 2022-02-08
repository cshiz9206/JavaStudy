package T19_1_Mid_2;

import java.util.Scanner;

public class Exam02 {
	int[] binArr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exam02 ex = new Exam02();
		Scanner sc = new Scanner(System.in);
		int num;
		while(true) {
			System.out.println("=== 진수 변환기 ===");
			
			System.out.print("10진수 입력 : ");
			num = sc.nextInt();
			if(0 > num && num > 127) break;
			
			System.out.println("입력받은 10진수 : " + num);
			System.out.print(num + "의 2진수 표기 : ");
			int[] binArr = ex.bin(num);
			for(int tmp : binArr) System.out.print(tmp);
			System.out.println();
			System.out.print(num + "의 8진수 표기 : ");
			int[] octArr = ex.oct();
			for(int tmp : octArr) System.out.print(tmp);
			System.out.println();
			System.out.print(num + "의 16진수 표기 : 0x");
			String[] hexArr = ex.hex();
			for(String tmp : hexArr) System.out.print(tmp);
			System.out.println();
			System.out.println();
		}
	}
	
	int[] bin(int num) {
		binArr = new int[7];
		for(int i = binArr.length - 1; i >= 0; i--) {
			binArr[i] = num % 2;
			num = num / 2;
		}
		return binArr;
	}
	
	int[] oct() {
		int octArr[] = new int[3];
		int j = octArr.length - 1;
		int n = 0;
		int sum = 0;
		for(int i = binArr.length - 1; i >= 0; i--) {
			sum += Math.pow(2, n) * binArr[i];
			if(i == 0 || (binArr.length - i) % 3 == 0) { // 0 1 4
				octArr[j] = sum;
				j--;
				n = -1;
				sum = 0;
			}
			n++;
		}
		
		return octArr;
	}
	
	String[] hex() {
		String hexArr[] = new String[2];
		int j = hexArr.length - 1;
		int n = 0;
		int sum = 0;
		for(int i = binArr.length - 1; i >= 0; i--) {
			sum += Math.pow(2, n) * binArr[i];
			if(i == 0 || (binArr.length - i) % 4 == 0) { // 0 3
				if(sum == 15) hexArr[j] = "F";
				else if(sum == 14) hexArr[j] = "E";
				else if(sum == 13) hexArr[j] = "D";
				else if(sum == 12) hexArr[j] = "C";
				else if(sum == 11) hexArr[j] = "B";
				else if(sum == 10) hexArr[j] = "A";
				else hexArr[j] = String.valueOf(sum);
				j--;
				n = -1;
				sum = 0;
			}
			n++;
		}
		
		return hexArr;
	}
}
