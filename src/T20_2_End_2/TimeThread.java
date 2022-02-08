package T20_2_End_2;

import java.time.Duration;
import java.time.LocalDateTime;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class TimeThread extends Thread {
	static int score = 0;
	int maxTime = 10;
	JLabel jlbHead;
	static boolean isEnd = false;
	
	public TimeThread(JLabel jlbHead) {
		this.jlbHead = jlbHead;
	}
	
	public void run() {
		LocalDateTime start = LocalDateTime.now();
		while(true) {
			LocalDateTime now = LocalDateTime.now();
			Duration time = Duration.between(start, now);
			int sec = (int)(maxTime - time.getSeconds());
			jlbHead.setText("남은시간 : " + sec + "초, score : " + Character.getScore() + "점");
			if(sec == 0) {
				isEnd = true;
				jlbHead.setText("Your score : " + Character.getScore());
				break;
			}
		}
	}
}
