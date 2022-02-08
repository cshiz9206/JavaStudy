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
		// 당첨 번호 생성
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
		// 응모 번호 입력
		Scanner sc = new Scanner(System.in);
		entry = new int[6];
		System.out.print("응모 번호를 입력하세요 (1 ~ 45, 6개) : ");
		String[] tmp = sc.nextLine().split(" ");
		for(int i = 0; i < 6; i++) {
			entry[i] = Integer.parseInt(tmp[i]);
		}
	}
	
	protected void printResult(int grade) throws IOException {
		// 당첨 결과 출력
		System.out.println("당첨 번호 : " + arrToStr(lot) + ", 2등 보너스볼 : " + secondBonusBall);
		System.out.print("응모 번호 : " + arrToStr(entry));
		if(grade == 0) System.out.println(" => 꽝입니다.");
		else System.out.println(" => 축하합니다! " + grade + "등입니다!");
		
		FileWriter tries = new FileWriter("tries.txt", true);
		FileWriter wins = new FileWriter("wins.txt", true);
		
		if(grade == 0) {
			tries.write("당첨 번호 : " + arrToStr(lot) + ", 2등 보너스볼 : " + secondBonusBall + "\n");
			tries.write("응모 번호 : " + arrToStr(entry));
			tries.write(" => 꽝입니다." + "\n");
		}
		else {
			tries.write("당첨 번호 : " + arrToStr(lot) + ", 2등 보너스볼 : " + secondBonusBall + "\n");
			tries.write("응모 번호 : " + arrToStr(entry));
			tries.write(" => 축하합니다! " + grade + "등입니다!" + "\n");
			wins.write("당첨 번호 : " + arrToStr(lot) + ", 2등 보너스볼 : " + secondBonusBall + "\n");
			wins.write("응모 번호 : " + arrToStr(entry));
			wins.write(" => 축하합니다! " + grade + "등입니다!" + "\n");
		}
		tries.close();
		wins.close();
	}
	
	// 번호 출력시 사용할 string 제작
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
