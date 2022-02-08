package T19_1_End_2;

import java.util.Scanner;

public class TypeCounter {
	Scanner sc;
	String data = "";
	int[] count;
	
	public TypeCounter() {
		sc = new Scanner(System.in);
		count = new int[5];
	}
	
	void inputContent() {
		String line;
		while((line = sc.nextLine()).length() != 0) {
			data += line + "\n";
		}
	}
	
	void count() {
		// 카운트, 출력
		System.out.print(data);
		for(int i = 0; i < data.length(); i++) {
			if(data.charAt(i) >= 127) count[0] += 1;
			else if((data.charAt(i) <= 122 && 97 <= data.charAt(i)) 
					|| (data.charAt(i) <= 90 && 65 <= data.charAt(i))) count[1] += 1;
			else if(data.charAt(i) >= 48 && data.charAt(i) <= 57) count[2] += 1;
			else if(data.codePointAt(i) == 32) count[4] += 1;
			else if(data.charAt(i) != 10) count[3] += 1;
		}
		
		System.out.println("한 글 : " + count[0]);
		System.out.println("영 어 : " + count[1]);
		System.out.println("숫 자 : " + count[2]);
		System.out.println("특수문자 : " + count[3]);
		System.out.println("공 백 : " + count[4]);
	}
}
