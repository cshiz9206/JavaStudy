package DonationAngelThread2;

import java.util.Random;

import javax.swing.JProgressBar;

public class DonatorThread extends Thread {
	
	JProgressBar jpgDonator;
	Random rd;
	final int amount = 1000000;
	
	public DonatorThread(JProgressBar jpgDonator) {
		this.jpgDonator = jpgDonator;
		rd = new Random();
	}
	
	public void run() {
		try {
			while(true) {
				if(TotalThread.total > DonationAngelFrame.goal) break;
				sleep(300);
				
				int rdn = rd.nextInt(amount);
//				if(TotalThread.total > (DonationAngelFrame.goal - amount)) {
//					int tmp = DonationAngelFrame.goal - TotalThread.total;
//					rdn = rd.nextInt(tmp);
//				}
				if(TotalThread.donate(rdn)) {
					jpgDonator.setValue(jpgDonator.getValue() + rdn);
					jpgDonator.setString(jpgDonator.getValue() + "원 기부!");
				}
				else System.out.println("기부 실패");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
