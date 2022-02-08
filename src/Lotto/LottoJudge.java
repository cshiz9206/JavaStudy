package Lotto;

public class LottoJudge {
	static int rank = 6;
	static int win_cnt = 0;
	static boolean win_bonus = false;
	
	static int grade(int[] lot, int bonus, int entry) {
		// 추첨 번호 / 2등 보너스볼 번호 / 응모 번호
		// 등수 반환
		
		for(int i = 0; i < lot.length; i++) {
			if(bonus == entry) win_bonus = true;
			if(lot[i] == entry) {
				win_cnt += 1;
			}
		}
		
		if (win_cnt == 3) rank = 5;
		if (win_cnt == 4) rank = 4;
		if (win_cnt == 5) rank = 3;
		if (win_cnt == 5 && win_bonus) rank = 2;
		if (win_cnt == 6) rank = 1;
		
		// 하나도 못 맞췄으면 6 반환
		return rank;
	}
}
