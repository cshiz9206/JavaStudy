package RainAvoid;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MakeRainThread extends Thread{
	JPanel jpnl;
	JLabel jlbCh, jlbTime;
	
	public MakeRainThread(JPanel jpnl, JLabel jlbCh, JLabel jlbTime) {
		this.jpnl = jpnl;
		this.jlbCh = jlbCh;
		this.jlbTime = jlbTime;
	}
	
	public void run() {
		while(true) {
			if(RainThread.isDead) {
				jlbTime.setText("Game Over");
				break;
			}
			
			try {
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			new RainThread(jpnl, jlbCh).start();
		}
	}
}
