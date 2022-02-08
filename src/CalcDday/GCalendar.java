package CalcDday;

import java.time.Duration;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class GCalendar {
	Scanner sc;
	FileIO io;
	int year, month, date;
	
	public GCalendar() {
		sc = new Scanner(System.in);
		io = new FileIO();
		process();
	}
	
	public void process() {
		while(true) {
			System.out.print("년도를 입력해주세요(yyyy) : ");
			year = sc.nextInt();
			System.out.print("월을 입력해주세요(mm) : ");
			month = sc.nextInt();
			System.out.print("날짜을 입력해주세요(dd) : ");
			date = sc.nextInt();
			System.out.println("입력하신 날짜는 " + year + "년도 " + month + "월 " + date + "일 입니다.");
			io.write("입력하신 날짜는 " + year + "년도 " + month + "월 " + date + "일 입니다.\n");
			get_dday(year, month, date);
			System.out.print("다른날도 알아보기(1)/끝내기(2) : ");
			int tmp = sc.nextInt();
			if(tmp == 2) break;
		}
	}
	
	public void get_dday(int year, int month, int day) {
		GregorianCalendar findgc = new GregorianCalendar(year, month - 1, day);
		int dday = (int)((findgc.getTimeInMillis() - GregorianCalendar.getInstance().getTimeInMillis()) / 1000 / 60 / 60 / 24);
		if(dday > 0) {
			System.out.println("입력하신 날짜까지 " + dday + "일 남았습니다.");
			io.write("입력하신 날짜까지 " + dday + "일 남았습니다.\n");
		}
		else if(dday == 0) {
			System.out.println("D-Day는 오늘입니다!");
			io.write("D-Day는 오늘입니다!\n");
		}
		else {
			System.out.println("입력하신 날짜까지 " + (-1 * dday) + "일 지났습니다.");
			io.write("입력하신 날짜까지 " + (-1 * dday) + "일 지났습니다.\n");
		}
	}
}
