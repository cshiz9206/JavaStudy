package OXQuiz;

import java.util.Random;
import java.util.Scanner;

public class RandomOX {
	Random rd;
	Scanner sc;
	FileIO io;
	
	public RandomOX() {
		rd = new Random();
		sc = new Scanner(System.in);
		io = new FileIO();
	}
	
	public void process() {
		io.println("���������� �����մϴ�.");
		int n = 0;
		int money = 1;
		while(true) {
			n += 1;
			io.println(n + "�� �õ��Դϴ�.");
			io.print("���� �� ������ �ּ��� (True/False) : ");
			boolean user = sc.nextBoolean();
			if(user != rd.nextBoolean()) {
				io.println("���ÿ� �����ϼ̽��ϴ�.");
				if(n == 1) money = 0;
				io.println("���� ����� " + money + "�� �Դϴ�.");
				io.print("������ �����մϴ�.");
				break;
			}
			io.println("���ÿ� �����ϼ̽��ϴ�.");
			money *= 10;
			io.println("���� ����� " + money + "�� �Դϴ�.");
			io.println("���� ���带 �����մϴ�.");
		}
	}
}
