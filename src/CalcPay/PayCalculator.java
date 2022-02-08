package CalcPay;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PayCalculator {
	int payday = 0;
	boolean[] day_of_work = new boolean[7];
	int my_pay = 0;
	int start_work_H  = 0;
	int start_work_M = 0;
	int end_work_H = 0;
	int end_work_M = 0;
	float pay_of_second = 0;
	float oneday_sec;
	int work_day_cnt_of_month;
	
	LocalDateTime start_time;
	LocalDateTime end_time;
	
	LocalDateTime now;
	LocalDateTime today_start;
	LocalDateTime today_end;
	
	public void set_my_schedule() {
		now = LocalDateTime.now();
		
		if(now.getDayOfMonth() > 25) start_time = LocalDateTime.of(now.getYear(), now.getMonth(), 26, start_work_H, start_work_M);
		else start_time = LocalDateTime.of(now.getYear(), now.getMonthValue() + 1, 26, start_work_H, start_work_M);
		
		if(now.getDayOfMonth() > 25) end_time = LocalDateTime.of(now.getYear(), now.getMonthValue() + 1, 25, end_work_H, end_work_M);
		else end_time = LocalDateTime.of(now.getYear(), now.getMonthValue(), 25, end_work_H, end_work_M);
		
		set_day_cnt_of_month();
		cal_pay_of_second();
	}
	
	public void cal_pay_of_second() {
		pay_of_second = my_pay / work_day_cnt_of_month / oneday_sec;
	}
	
	public float todays_pay() {
		for(int i = 0; i < day_of_work.length; i++) {
			if(!day_of_work[now.getDayOfWeek().getValue() - 1]) {
				return 0;
			}
		}
		return (pay_of_second * Duration.between(today_start, now).getSeconds());
	}
	
	public int how_many_work_days() {
		int cnt = 0;
		int after = 1;
		while(true) {
			LocalDateTime tmp = now.plusDays(after);
			if(day_of_work[tmp.getDayOfWeek().getValue() - 1]) cnt += 1;
			if(tmp.getDayOfMonth() == payday) break;
			after++;
		}
		return cnt;
	}
	
	public float month_pay_now() {
		int cnt = 0;
		int after = 1;
		while(true) {
			LocalDateTime tmp = end_time.plusDays(after);
			if(day_of_work[tmp.getDayOfWeek().getValue() - 1]) 
				cnt += 1;
			if(tmp.getDayOfMonth() == now.getDayOfMonth()) 
				break;
			after++;
		}
		return (pay_of_second * oneday_sec * (cnt - 1) + todays_pay());
	}
	
	public void set_times(String when, String times) {
		if(when.contentEquals("출근")) {
			start_work_H = Integer.parseInt(times.split(":")[0]);
			start_work_M = Integer.parseInt(times.split(":")[1]);
			today_start = LocalDateTime.of(LocalDate.now(), LocalTime.of(start_work_H, start_work_M));
		}
		else {
			end_work_H = Integer.parseInt(times.split(":")[0]);
			end_work_M = Integer.parseInt(times.split(":")[1]);
			today_end = LocalDateTime.of(LocalDate.now(), LocalTime.of(end_work_H, end_work_M));
		}
		if((today_start != null) && (today_end != null)) {
			//oneday_sec = (int)Duration.between(LocalTime.of(start_work_H, start_work_M), LocalTime.of(end_work_H, end_work_M)).getSeconds();
			oneday_sec = Duration.between(today_start, today_end).getSeconds();
		}
	}
	
	public void set_mypay(int my_pay) {
		this.my_pay = my_pay;
	}
	
	public void set_payday(int payday) {
		this.payday = payday;
	}
	
	public void set_days(String days) {
		String[] daysArray = days.split(" ");
		for(int i = 0; i < daysArray.length; i++) {
			int day_num = get_day_number(daysArray[i]);
			day_of_work[day_num] = true;
		}
	}
	
	public int get_day_number(String day) {
		if(day.equals("월")) return 0;
		else if(day.equals("화")) return 1;
		else if(day.equals("수")) return 2;
		else if(day.equals("목")) return 3;
		else if(day.equals("금")) return 4;
		else if(day.equals("토")) return 5;
		else if(day.equals("일")) return 6;
		else return -1;
	}
	
	public void set_day_cnt_of_month() {
		int cnt = 0;
		int after = 1;
		while(true) {
			LocalDateTime tmp = end_time.plusDays(after);
			if(day_of_work[tmp.getDayOfWeek().getValue() - 1]) 
				cnt += 1;
			if(tmp.getDayOfMonth() == end_time.getDayOfMonth()) 
				break;
			after++;
		}
		work_day_cnt_of_month = cnt;
	}
}
