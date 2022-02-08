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
		
		io.print("������ ���Ͽ� ���޹޳���?(1~31): ");
		tmp = sc.nextInt();
		io.write_file(String.valueOf(tmp) + "\n");
		pc.set_payday(tmp);
		sc.nextLine();
		io.print("������ �󸶸� �޳���?: ");
		tmp = sc.nextInt();
		io.write_file(String.valueOf(tmp) + "\n");
		pc.set_mypay(tmp);
		sc.nextLine();
		io.print("����ϴ� ������ �Է����ּ���(���鱸��): ");
		tmp2 = sc.nextLine();
		io.write_file(tmp2 + "\n");
		pc.set_days(tmp2);
		io.print("��ÿ� ����ϳ���?(24�� ����): ");
		tmp2 = sc.nextLine();
		io.write_file(tmp2 + "\n");
		pc.set_times("���", tmp2);
		io.print("��ÿ� ����ϳ���?(24�� ����): ");
		tmp2 = sc.nextLine();
		io.write_file(tmp2 + "\n");
		pc.set_times("���", tmp2);
		io.println("======================================");
		
		pc.set_my_schedule();
	}
	
	public void process() {
		while(true) {
			io.println("");
			io.println("���� ����ؼ� " + pc.todays_pay() + "�� �������ϴ�.");
			io.println("�̹����� ������� " + pc.month_pay_now() + "�� �������ϴ�.");
			io.println("���� ���޳����� " + pc.how_many_work_days() + "�� �� ���ؾ� �մϴ�.");
			io.print("���ΰ�ħ�ϱ�(1) / �����ϱ�(2) : ");
			int tmp = sc.nextInt();
			if(tmp == 1) pc.set_my_schedule();
			else break;
		}
	}
}
