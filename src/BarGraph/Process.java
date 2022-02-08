package BarGraph;

import java.util.Scanner;

public class Process {
	public Process() {
		Scanner sc = new Scanner(System.in);
		int[] users = new int[4];;
		FileIO io = new FileIO();
		
		io.println("점수의 범위는 0~100이며 10단위입니다.");
		io.print("철수의 점수를 입력해주세요 : ");
		users[0] = sc.nextInt();
		io.write_file(String.valueOf(users[0]) + "\n");
		io.print("영희의 점수를 입력해주세요 : ");
		users[1] = sc.nextInt();
		io.write_file(String.valueOf(users[1]) + "\n");
		io.print("수영의 점수를 입력해주세요 : ");
		users[2] = sc.nextInt();
		io.write_file(String.valueOf(users[2]) + "\n");
		io.print("민지의 점수를 입력해주세요 : ");
		users[3] = sc.nextInt();
		io.write_file(String.valueOf(users[3]) + "\n");
		
		for(int i = 100; i >= 0; i -= 10) {
			if(i != 0) io.print(i + "-");
			for(int j = 0; j < 4; j++) {
				if(i == 0) {
					if(j == 0) io.print("\t철수");
					if(j == 1) io.print("\t영희");
					if(j == 2) io.print("\t수영");
					if(j == 3) io.print("\t민지");
				}
				else {
					if(users[j] >= i) io.print("\t■");
					else io.print("\t ");
				}
			}
			io.println("");
		}
	}
}
