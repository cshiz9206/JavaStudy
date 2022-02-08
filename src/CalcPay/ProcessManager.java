package CalcPay;

import java.util.Scanner;

public class ProcessManager {
	PayCalculator pc;
	Scanner sc;
	FileIO io = new FileIO();
	
	public ProcessManager() {
		inputData();
		process();
	}
	
	public void inputData() {
		sc = new Scanner(System.in);
		pc = new PayCalculator();
		int tmp;
		String tmp2;
		
		io.print("월급은 몇일에 지급받나요?(1~31): ");
		tmp = sc.nextInt();
		io.write_file(String.valueOf(tmp) + "\n");
		pc.set_payday(tmp);
		sc.nextLine();
		io.print("월급은 얼마를 받나요?: ");
		tmp = sc.nextInt();
		io.write_file(String.valueOf(tmp) + "\n");
		pc.set_mypay(tmp);
		sc.nextLine();
		io.print("출근하는 요일을 입력해주세요(공백구분): ");
		tmp2 = sc.nextLine();
		io.write_file(tmp2 + "\n");
		pc.set_days(tmp2);
		io.print("몇시에 출근하나요?(24시 기준): ");
		tmp2 = sc.nextLine();
		io.write_file(tmp2 + "\n");
		pc.set_times("출근", tmp2);
		io.print("몇시에 퇴근하나요?(24시 기준): ");
		tmp2 = sc.nextLine();
		io.write_file(tmp2 + "\n");
		pc.set_times("퇴근", tmp2);
		io.println("======================================");
		
		pc.set_my_schedule();
	}
	
	public void process() {
		while(true) {
			io.println("");
			io.println("오늘 출근해서 " + pc.todays_pay() + "원 벌었습니다.");
			io.println("이번달은 현재까지 " + pc.month_pay_now() + "원 벌었습니다.");
			io.println("다음 월급날까지 " + pc.how_many_work_days() + "일 더 일해야 합니다.");
			io.print("새로고침하기(1) / 종료하기(2) : ");
			int tmp = sc.nextInt();
			if(tmp == 1) pc.set_my_schedule();
			else break;
		}
	}
}
