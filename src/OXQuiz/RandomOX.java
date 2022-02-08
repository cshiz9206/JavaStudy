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
		io.println("랜덤게임을 시작합니다.");
		int n = 0;
		int money = 1;
		while(true) {
			n += 1;
			io.println(n + "차 시도입니다.");
			io.print("다음 중 선택해 주세요 (True/False) : ");
			boolean user = sc.nextBoolean();
			if(user != rd.nextBoolean()) {
				io.println("선택에 실패하셨습니다.");
				if(n == 1) money = 0;
				io.println("최종 상금은 " + money + "원 입니다.");
				io.print("게임을 종료합니다.");
				break;
			}
			io.println("선택에 성공하셨습니다.");
			money *= 10;
			io.println("누적 상금은 " + money + "원 입니다.");
			io.println("다음 라운드를 진행합니다.");
		}
	}
}
