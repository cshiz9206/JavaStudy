package T19_2_End_2;

import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

public class WaterHoleThread extends Thread {
	WaterTank tank;
	JTextArea jtaDrain;
	
	public WaterHoleThread(WaterTank tank, JTextArea jtaDrain) {
		this.tank = tank;
		this.jtaDrain = jtaDrain;
	}
	
	public void run() {
		while(true) {
			if(!tank.isFull && !tank.isEmpty) {
				tank.drain(100);
				jtaDrain.append("100ml 빠짐, " + tank.water + "ml 남음\n");
			}
			
			if(tank.isEmpty) {
				jtaDrain.append("미션 실패");
				break;
			}
			if(tank.isFull) break;
			
			try {
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
