package BaseballGame;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		BaseballGame bbg = new BaseballGame();
		
		System.out.println("���� �߱� ����!");
		bbg.initialize();
		while(true) {
			System.out.print("���� �����ּ��� : ");
			int[] input = new int[3];
			for(int i = 0; i < 3; i++)
				input[i] = s.nextInt();
			
			int[] cntJudge = bbg.judge(input);
			int strike = cntJudge[0];
			int ball = cntJudge[1];
			if(strike == 3) {
				System.out.println("�����Դϴ�!");
				break;
			}
			System.out.println(strike + " strike " + ball + " ball�Դϴ�.");
		}
		System.out.println("���� Ƚ�� : " + bbg.getCntThrow());
	}

}
