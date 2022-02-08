package BarGraph;

import java.util.Scanner;

public class Process {
	public Process() {
		Scanner sc = new Scanner(System.in);
		int[] users = new int[4];;
		FileIO io = new FileIO();
		
		io.println("������ ������ 0~100�̸� 10�����Դϴ�.");
		io.print("ö���� ������ �Է����ּ��� : ");
		users[0] = sc.nextInt();
		io.write_file(String.valueOf(users[0]) + "\n");
		io.print("������ ������ �Է����ּ��� : ");
		users[1] = sc.nextInt();
		io.write_file(String.valueOf(users[1]) + "\n");
		io.print("������ ������ �Է����ּ��� : ");
		users[2] = sc.nextInt();
		io.write_file(String.valueOf(users[2]) + "\n");
		io.print("������ ������ �Է����ּ��� : ");
		users[3] = sc.nextInt();
		io.write_file(String.valueOf(users[3]) + "\n");
		
		for(int i = 100; i >= 0; i -= 10) {
			if(i != 0) io.print(i + "-");
			for(int j = 0; j < 4; j++) {
				if(i == 0) {
					if(j == 0) io.print("\tö��");
					if(j == 1) io.print("\t����");
					if(j == 2) io.print("\t����");
					if(j == 3) io.print("\t����");
				}
				else {
					if(users[j] >= i) io.print("\t��");
					else io.print("\t ");
				}
			}
			io.println("");
		}
	}
}
