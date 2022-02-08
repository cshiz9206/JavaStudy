package Lotto2;

public class LottoJudge {
	protected static int grade(int[] lot, int second, int[] entry) {
		// 당첨번호, 응모번호 in -> 등수 out
		int cnt = 0;
		boolean bonus = false;
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 6; j++) {
				if(lot[i] == entry[j])
					cnt += 1;
				if(entry[j] == second)
					bonus = true;
			}
		}
		if(cnt == 3) {
			return 5;
		}
		else if(cnt == 4) {
			return 4;
		}
		else if(cnt == 5 && !bonus) {
			return 3;
		}
		else if(cnt == 5 && bonus) {
			return 2;
		}
		else if(cnt == 6) {
			return 1;
		}
		else return 0;
	}
}
