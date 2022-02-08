package HangmanGame;

import java.util.Scanner;

public class HangmanGame extends AbsHangmanGame {
	public HangmanGame() {
		answer = "committee";
		max = 8;
		isBlank = new boolean[answer.length()];
	}
	
	@Override
	protected void intro() {
		// TODO Auto-generated method stub
		System.out.println("Hangman Game!");
		System.out.println("총 시도횟수 : " + max + "회");
	}

	@Override
	protected void print() {
		// TODO Auto-generated method stub
		for(int i = 0; i < answer.length(); i++) {
			// blank가 true면 같은 인덱스의 answer 출력
			if(isBlank[i]) {
				System.out.print(answer.charAt(i) + " ");
			}
			else System.out.print("_" + " ");
		}
		System.out.println();
	}

	@Override
	protected void guess() {
		// TODO Auto-generated method stub
		count += 1;
		System.out.print(max + "회 중 " + count + "회차 시도 : ");
		sc = new Scanner(System.in);
		String tmp = sc.next();
		
		if(tmp.length() != 1) tmp = null; // 한 글자가 아니면 입력 안한 것으로 처리
		input = (char)tmp.charAt(0);
		input = Character.toLowerCase(input);
	}

	@Override
	protected void check() {
		// TODO Auto-generated method stub
		boolean flag = false;
		for(int i = 0; i < answer.length(); i++) {
			if(answer.charAt(i) == input) {
				isBlank[i] = true;
				flag = true;
			}
		}
		if(flag) System.out.println("맞췄습니다!");
		else System.out.println("틀렸습니다!");
	}

	@Override
	protected boolean gameEnd() {
		// TODO Auto-generated method stub
		
		// 맞춘 개수 정답 문자열 길이와 같으면 끝
		// 맞춘 개수(true 개수) 확인
		int cnt = 0;
		for(boolean tmp : isBlank) {
			if (tmp) cnt += 1;
		}
		if(cnt == answer.length()) {
			System.out.println("성공!");
			return true;
		}
		
		// 시도 횟수 완료 됐으면 끝
		if(count >= max) {
			System.out.println("실패! 정답은 " + answer + "입니다.");
			return true;
		}
		
		// 나머지 끝 아님, 반복
		return false;
	}

}
