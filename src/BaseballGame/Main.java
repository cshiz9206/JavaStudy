package BaseballGame;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		BaseballGame bbg = new BaseballGame();
		
		System.out.println("숫자 야구 게임!");
		bbg.initialize();
		while(true) {
			System.out.print("공을 던져주세요 : ");
			int[] input = new int[3];
			for(int i = 0; i < 3; i++)
				input[i] = s.nextInt();
			
			int[] cntJudge = bbg.judge(input);
			int strike = cntJudge[0];
			int ball = cntJudge[1];
			if(strike == 3) {
				System.out.println("정답입니다!");
				break;
			}
			System.out.println(strike + " strike " + ball + " ball입니다.");
		}
		System.out.println("투구 횟수 : " + bbg.getCntThrow());
	}

}
