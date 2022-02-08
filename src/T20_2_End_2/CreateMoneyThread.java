package T20_2_End_2;

import java.util.Random;

import javax.swing.JPanel;

public class CreateMoneyThread extends Thread {
	Random rd;
	int xMax, yMax;
	JPanel jpnlScreen;
	
	public CreateMoneyThread(int xMax, int yMax, JPanel jpnlScreen) {
		this.xMax = xMax;
		this.yMax = yMax;
		this.jpnlScreen = jpnlScreen;
		rd = new Random();
	}
	
	public void run() {
		while(true) {
			int moneyX = rd.nextInt(xMax);
			new Thread(new MoneyThread(moneyX, yMax, jpnlScreen)).start();
			
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
