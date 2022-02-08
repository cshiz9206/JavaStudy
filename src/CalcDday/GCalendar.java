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
			System.out.print("�⵵�� �Է����ּ���(yyyy) : ");
			year = sc.nextInt();
			System.out.print("���� �Է����ּ���(mm) : ");
			month = sc.nextInt();
			System.out.print("��¥�� �Է����ּ���(dd) : ");
			date = sc.nextInt();
			System.out.println("�Է��Ͻ� ��¥�� " + year + "�⵵ " + month + "�� " + date + "�� �Դϴ�.");
			io.write("�Է��Ͻ� ��¥�� " + year + "�⵵ " + month + "�� " + date + "�� �Դϴ�.\n");
			get_dday(year, month, date);
			System.out.print("�ٸ����� �˾ƺ���(1)/������(2) : ");
			int tmp = sc.nextInt();
			if(tmp == 2) break;
		}
	}
	
	public void get_dday(int year, int month, int day) {
		GregorianCalendar findgc = new GregorianCalendar(year, month - 1, day);
		int dday = (int)((findgc.getTimeInMillis() - GregorianCalendar.getInstance().getTimeInMillis()) / 1000 / 60 / 60 / 24);
		if(dday > 0) {
			System.out.println("�Է��Ͻ� ��¥���� " + dday + "�� ���ҽ��ϴ�.");
			io.write("�Է��Ͻ� ��¥���� " + dday + "�� ���ҽ��ϴ�.\n");
		}
		else if(dday == 0) {
			System.out.println("D-Day�� �����Դϴ�!");
			io.write("D-Day�� �����Դϴ�!\n");
		}
		else {
			System.out.println("�Է��Ͻ� ��¥���� " + (-1 * dday) + "�� �������ϴ�.");
			io.write("�Է��Ͻ� ��¥���� " + (-1 * dday) + "�� �������ϴ�.\n");
		}
	}
}
