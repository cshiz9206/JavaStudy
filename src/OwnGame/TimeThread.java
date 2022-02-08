package OwnGame;

import java.time.Duration;
import java.time.LocalDateTime;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class TimeThread extends Thread {
	static int score = 0;
	int maxTime = 50;
	JLabel jlbHead;
	static boolean timeEnd = false;
	
	public TimeThread(JLabel jlbHead) {
		this.jlbHead = jlbHead;
	}
	
	public void run() {
		LocalDateTime start = LocalDateTime.now();
		while(true) {
			LocalDateTime now = LocalDateTime.now();
			Duration time = Duration.between(start, now);
			int sec = (int)(maxTime - time.getSeconds());
			jlbHead.setText("time : " + sec + "s, score : " + User.score);
			if(sec == 0) {
				timeEnd = true;
				jlbHead.setText("Your score : " + (User.score + sec));
				break;
			}
			if(Ball.isDead) {
				jlbHead.setText("Your score : " + User.score);
				break;
			}
		}
	}
}
