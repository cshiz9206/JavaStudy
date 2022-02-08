package Lotto2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lottery {
	protected Random rand;
	protected int[] lot;
	protected int secondBonusBall;
	protected int[] entry;
	
	public Lottery() {}
	
	protected void generate() {
		// ��÷ ��ȣ ����
		rand = new Random();
		lot = new int[6];
		int i = 0;
		a : while(i < 6) {
			int tmp = rand.nextInt(45) + 1;
			for(int j = 0; j < 6; j++) {
				if(tmp == lot[j])
					continue a;
			}
			lot[i] = tmp;
			i++;
		}
		
		a : while(true) {
			int tmp = rand.nextInt(45) + 1;
			for(int j = 0; j < 6; j++) {
				if(tmp == lot[j])
					continue a;
			}
			secondBonusBall = tmp;
			break;
		}
		//secondBonusBall = rand.nextInt(45) + 1;
	}
	
	protected void inputEntry() {
		// ���� ��ȣ �Է�
		Scanner sc = new Scanner(System.in);
		entry = new int[6];
		System.out.print("���� ��ȣ�� �Է��ϼ��� (1 ~ 45, 6��) : ");
		String[] tmp = sc.nextLine().split(" ");
		for(int i = 0; i < 6; i++) {
			entry[i] = Integer.parseInt(tmp[i]);
		}
	}
	
	protected void printResult(int grade) throws IOException {
		// ��÷ ��� ���
		System.out.println("��÷ ��ȣ : " + arrToStr(lot) + ", 2�� ���ʽ��� : " + secondBonusBall);
		System.out.print("���� ��ȣ : " + arrToStr(entry));
		if(grade == 0) System.out.println(" => ���Դϴ�.");
		else System.out.println(" => �����մϴ�! " + grade + "���Դϴ�!");
		
		FileWriter tries = new FileWriter("tries.txt", true);
		FileWriter wins = new FileWriter("wins.txt", true);
		
		if(grade == 0) {
			tries.write("��÷ ��ȣ : " + arrToStr(lot) + ", 2�� ���ʽ��� : " + secondBonusBall + "\n");
			tries.write("���� ��ȣ : " + arrToStr(entry));
			tries.write(" => ���Դϴ�." + "\n");
		}
		else {
			tries.write("��÷ ��ȣ : " + arrToStr(lot) + ", 2�� ���ʽ��� : " + secondBonusBall + "\n");
			tries.write("���� ��ȣ : " + arrToStr(entry));
			tries.write(" => �����մϴ�! " + grade + "���Դϴ�!" + "\n");
			wins.write("��÷ ��ȣ : " + arrToStr(lot) + ", 2�� ���ʽ��� : " + secondBonusBall + "\n");
			wins.write("���� ��ȣ : " + arrToStr(entry));
			wins.write(" => �����մϴ�! " + grade + "���Դϴ�!" + "\n");
		}
		tries.close();
		wins.close();
	}
	
	// ��ȣ ��½� ����� string ����
	protected String arrToStr(int[] arr) {
		String tmp = "";
		for(int i = 0; i < arr.length; i++) {
			tmp += String.valueOf(arr[i]);
			tmp += " ";
		}
		return tmp.trim();
	}
	
	public void playLottery() throws IOException {
		inputEntry();
		generate();
		//Arrays.parallelSort(lot);
		Arrays.sort(lot);
		Arrays.parallelSort(entry); // parallelSort vs sort
		int grade = LottoJudge.grade(lot, secondBonusBall, entry);
		printResult(grade);
	}
}
