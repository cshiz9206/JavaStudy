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
		System.out.println("�� �õ�Ƚ�� : " + max + "ȸ");
	}

	@Override
	protected void print() {
		// TODO Auto-generated method stub
		for(int i = 0; i < answer.length(); i++) {
			// blank�� true�� ���� �ε����� answer ���
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
		System.out.print(max + "ȸ �� " + count + "ȸ�� �õ� : ");
		sc = new Scanner(System.in);
		String tmp = sc.next();
		
		if(tmp.length() != 1) tmp = null; // �� ���ڰ� �ƴϸ� �Է� ���� ������ ó��
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
		if(flag) System.out.println("������ϴ�!");
		else System.out.println("Ʋ�Ƚ��ϴ�!");
	}

	@Override
	protected boolean gameEnd() {
		// TODO Auto-generated method stub
		
		// ���� ���� ���� ���ڿ� ���̿� ������ ��
		// ���� ����(true ����) Ȯ��
		int cnt = 0;
		for(boolean tmp : isBlank) {
			if (tmp) cnt += 1;
		}
		if(cnt == answer.length()) {
			System.out.println("����!");
			return true;
		}
		
		// �õ� Ƚ�� �Ϸ� ������ ��
		if(count >= max) {
			System.out.println("����! ������ " + answer + "�Դϴ�.");
			return true;
		}
		
		// ������ �� �ƴ�, �ݺ�
		return false;
	}

}
