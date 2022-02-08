package DonationAngelThread2;

import javax.swing.JProgressBar;

public class TotalThread extends Thread {
	static int total;
	JProgressBar jpgTotal;
	DonatorThread[] dts;
	
	public TotalThread(JProgressBar jpgTotal, DonatorThread[] dts) {
		this.jpgTotal = jpgTotal;
		this.dts = dts;
	}
	
	public void run() {
		while(true) {
//			try {
//				sleep(300);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
//			if(total >= 100000000) {
//				for(int i = 0; i < 10; i++) {
//					dts[i].interrupt();
//				}
//			}
			
			jpgTotal.setValue(total);
			jpgTotal.setString("ÃÑ " + total + "¿ø Àû¸³!");
		}
	}
	
	public static synchronized boolean donate(int donation) {
		if(total >= 100000000) {
			System.out.println(Thread.currentThread().getId());
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("wake " + Thread.currentThread().getId());
			return false;
		}
		
		total += donation;
		return true;
	}
}
