package OwnGame2;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import com.sun.xml.internal.ws.api.server.Container;

public class TimeThread extends Thread implements Serializable {
	static int score = 0;
	int maxTime = 5000;
	JLabel jlbHead;
	ScoreBoard db;
	Container ct;
	static boolean timeEnd = false;
	
	public TimeThread(JLabel jlbHead, ScoreBoard db) {
		this.jlbHead = jlbHead;
		this.db = db;
	}
	
	public void run() {
		LocalDateTime start = LocalDateTime.now();
		while(true) {
			LocalDateTime now = LocalDateTime.now();
			Duration time = Duration.between(start, now);
			int sec = (int)(maxTime - time.getSeconds());
			jlbHead.setText("time : " + sec + "s, score : " + Bar.score);
			if(sec == 0) {
				timeEnd = true;
				Bar.score = Bar.score + sec;
				jlbHead.setText("Your score : " + Bar.score);
				break;
			}
			if(Ball.isDead) {
				jlbHead.setText("Your score : " + Bar.score);
				break;
			}
		}
		
		//SaveNameFrame snf = new SaveNameFrame(db);
	}
}
