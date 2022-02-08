package Lotto;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

// 추첨 번호 6개, 보너스 볼 1개 생성(중복x)
// 응모 번호 6개 입력
// 출력 시 오름차순
// 등수 출력
public class Lottery {
	int[] winning;
	int[] lot;
	int bonus;
	int[] entry;
	
	void createBall() {
		winning = new int[7];
		
		Random random = new Random();
		int i = 0;
		a : while(i < 7) { // 보너스 번호까지 생성
			int tmp = random.nextInt(45) + 1;
			
			// 당첨 번호 중복 확인
			for (int j = 0; j < 7; j++) {
				if(winning[j] == tmp) continue a;
			}
			
			winning[i] = tmp;
			System.out.print(winning[i] + " "); // 당첨번호 출력
			i++;
		}
		System.out.println();
		
		// 당첨 번호, 보너스 번호 분리
		lot = Arrays.copyOfRange(winning, 0, 6); // 인덱스 5까지 복사
		bonus = winning[6];
	}
	
	void select() {
		Scanner s = new Scanner(System.in);
		entry = new int[6];
		
		System.out.print("응모 번호를 입력하세요 : ");
		for (int i = 0; i < entry.length; i++)
			entry[i] = s.nextInt();
	}
	
	void printRank() {
		int rank = 6;
		for (int i = 0; i < 6; i++) {
			rank = LottoJudge.grade(lot, bonus, entry[i]);
		}
		
		System.out.print("당첨 번호 : ");
		for(int i : lot) System.out.print(i + " ");
		System.out.println(", 2등 보너스볼 : " + bonus);
		System.out.print("응모 번호 : ");
		for(int i : entry) System.out.print(i + " ");
		System.out.println();
		
		if(rank == 6) System.out.println("꽝입니다.");
		else System.out.println("축하합니다! " + rank + "등입니다!");
	}
}
