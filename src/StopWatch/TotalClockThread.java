package StopWatch;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.JLabel;

public class TotalClockThread extends Thread {
	JLabel totalTime;
	LocalTime start;
	
//	int s;
//	int m;
//	int h;
	
	public TotalClockThread(JLabel totalTime) {
		this.totalTime = totalTime;
		start = LocalTime.now();
	}
	
	public void run() {
		while(true) {
			try {
				sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				break;
			}
			
			LocalTime now = LocalTime.now();
			Duration dur = Duration.between(start, now);
			LocalTime gap = LocalTime.of((int)dur.getSeconds() / 60 / 60, (int)dur.getSeconds() / 60, (int)dur.getSeconds());
			totalTime.setText(gap.format(DateTimeFormatter.ofPattern("H:mm:ss")));
		}
	}
	
	public void setTime() {
		start = LocalTime.now();
	}
	
//	public void run() {
//		s = 0;
//		m = 0;
//		h = 0;
//		
//		try {
//			while(true) {
//				
//				sleep(1000);
//				
//				s += 1;
//				if(s % 60 == 0) {
//					s = 0;
//					m += 1;
//					if(m % 60 == 0) {
//						m = 0;
//						h += 1;
//					}
//				}
//				totalTime.setText(h + " : " + m + " : " + s);
//			}
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	

//	public void setTime(int h, int m, int s) {
//		this.h = h;
//		this.m = m;
//		this.s = s;
//	}
}
