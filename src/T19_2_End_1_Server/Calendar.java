package T19_2_End_1_Server;

import java.util.GregorianCalendar;

import javax.swing.JLabel;

public class Calendar {
	GregorianCalendar cal;
	int year, month;
	int monthLastDate, monthFirstDay;
	
	public Calendar(int year, int month) {
		this.year = year;
		this.month = month;
		
		cal = new GregorianCalendar(year, month - 1, 1);
		monthLastDate = cal.getActualMaximum(cal.DATE);
		monthFirstDay = cal.get(cal.DAY_OF_WEEK);
	}
	
	public String toString() {
		String calStr = "";
		String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		int cnt = 0;
		
		calStr += "<" + year + "�� " + month + "��>\n";
		for(int i = 0; i < 7; i++) {
			calStr += day[i] + "\t";
			cnt += 1;
		}
		calStr += "\n";
		// �� ���
		for(int j = 1; j < monthFirstDay; j++) {
			calStr += "\t";
			cnt += 1;
			if(cnt % 7 == 0) calStr += "\n";
		}
		for(int i = 1; i <= monthLastDate; i++) {
			calStr += i + "\t";
			cnt += 1;
			if(cnt % 7 == 0) calStr += "\n";
		}
		calStr += "\n";
		
		return calStr;
	}
}
