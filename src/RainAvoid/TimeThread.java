package RainAvoid;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;

public class TimeThread extends Thread {
	JLabel jlbTime;
	LocalTime startTime;
	DateTimeFormatter nowTimeFormatter;
	
	public TimeThread(JLabel jlbTime, LocalTime startTime) {
		this.jlbTime = jlbTime;
		this.startTime = startTime;
		nowTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	}
	
	public void run() {
		while(true) {
			if(RainThread.isDead) break;
			LocalTime now = LocalTime.now();
			Duration dur = Duration.between(startTime, now);
			LocalTime gap = LocalTime.of((int)(dur.getSeconds() / 60 / 60), (int)(dur.getSeconds()) / 60, (int)(dur.getSeconds()));
			jlbTime.setText(gap.format(nowTimeFormatter));
		}
	}
}
