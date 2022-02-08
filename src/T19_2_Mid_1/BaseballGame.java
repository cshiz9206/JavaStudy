package T19_2_Mid_1;

import java.util.Random;

public class BaseballGame {
	int[] answer;
	public int count;
	
	public BaseballGame() {
		createAnswer();
	}
	
	void createAnswer() {
		answer = new int[3];
		Random rd = new Random();
		a : for(int i = 0; i < answer.length; i++) {
			int rdn = rd.nextInt(10);
			for(int tmp : answer) {
				if(tmp == rdn) {
					i--;
					continue a;
				}
			}
			answer[i] = rdn;
		}
	}
	
	public int[] judge(int[] guass) {
		int ball = 0;
		int strike = 0;
		for(int i = 0; i < guass.length; i++) {
			for(int j = 0; j < guass.length; j++) {
				if(answer[i] == guass[j]) {
					if(i == j) strike += 1;
					else ball += 1;
				}
			}
		}
		int[] result = {strike, ball};
		count += 1;
		return result;
	}
}
