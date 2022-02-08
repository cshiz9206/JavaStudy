package BaseballGame;
import java.util.Random;

public class BaseballGame {
	int[] answer = new int[3];
	int cntThrow = 0;
	Random r = new Random();
	
	// ���� ����
	void initialize() {
		for(int i = 0; i < 3; i++) {
			answer[i] = r.nextInt(10) % 9 + 1;
			System.out.print(answer[i] + " "); // ���� ��� 
		}
		System.out.println();
	}
	
	// strike, ball ����
	int[] judge(int[] input) {
		int[] cntJudge = new int[2]; // 0 : strike, 1 : ball
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(input[j] == answer[i]) {
					if(i == j) cntJudge[0] += 1; // ��ġ ������ strike
					else cntJudge[1] += 1; // ��ġ �ٸ��� ball
				}
			}
		}
		
		cntThrow += 1;
		
		return cntJudge;
	}
	
	// ���� Ƚ�� ��ȯ
	int getCntThrow() {
		return cntThrow;
	}
}