package Lotto;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

// ��÷ ��ȣ 6��, ���ʽ� �� 1�� ����(�ߺ�x)
// ���� ��ȣ 6�� �Է�
// ��� �� ��������
// ��� ���
public class Lottery {
	int[] winning;
	int[] lot;
	int bonus;
	int[] entry;
	
	void createBall() {
		winning = new int[7];
		
		Random random = new Random();
		int i = 0;
		a : while(i < 7) { // ���ʽ� ��ȣ���� ����
			int tmp = random.nextInt(45) + 1;
			
			// ��÷ ��ȣ �ߺ� Ȯ��
			for (int j = 0; j < 7; j++) {
				if(winning[j] == tmp) continue a;
			}
			
			winning[i] = tmp;
			System.out.print(winning[i] + " "); // ��÷��ȣ ���
			i++;
		}
		System.out.println();
		
		// ��÷ ��ȣ, ���ʽ� ��ȣ �и�
		lot = Arrays.copyOfRange(winning, 0, 6); // �ε��� 5���� ����
		bonus = winning[6];
	}
	
	void select() {
		Scanner s = new Scanner(System.in);
		entry = new int[6];
		
		System.out.print("���� ��ȣ�� �Է��ϼ��� : ");
		for (int i = 0; i < entry.length; i++)
			entry[i] = s.nextInt();
	}
	
	void printRank() {
		int rank = 6;
		for (int i = 0; i < 6; i++) {
			rank = LottoJudge.grade(lot, bonus, entry[i]);
		}
		
		System.out.print("��÷ ��ȣ : ");
		for(int i : lot) System.out.print(i + " ");
		System.out.println(", 2�� ���ʽ��� : " + bonus);
		System.out.print("���� ��ȣ : ");
		for(int i : entry) System.out.print(i + " ");
		System.out.println();
		
		if(rank == 6) System.out.println("���Դϴ�.");
		else System.out.println("�����մϴ�! " + rank + "���Դϴ�!");
	}
}
