package DonationAngelThread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.swing.DefaultListModel;

public class Recipient extends Thread {
	DonationCenter dc;
	DefaultListModel dlmReceiptLog;
	
	public Recipient(DonationCenter dc, DefaultListModel dlmReceiptLog) {
		this.dc =  dc;
		this.dlmReceiptLog = dlmReceiptLog;
	}
	
	public void run() {
		Random rd = new Random();
		
		a : while(true) {
			if(dc.goal() <= dc.donation()) break;
			
			int receipt = rd.nextInt(300001);
			
			while(true) {
				String format = "yyyy-MM-dd HH:mm:ss.SSS";
				SimpleDateFormat sdf = new SimpleDateFormat(format);
				
				if(receipt < 100000 | receipt > 300000) {
					System.out.println("출금은 1회 10만원 이상, 30만원 이하만 가능합니다.");
					continue a;
				}
				if(dc.donation() < receipt) {
					dlmReceiptLog.addElement(sdf.format(new Date()) + "  | " + 
				"잔액이 부족하여 입금 대기중... | 출금시도액 : " + receipt + "  | 잔고 : " + dc.donation());
				}
				else {
					dc.withdraw(receipt);
					dlmReceiptLog.addElement(sdf.format(new Date()) + "  | " + receipt + "원 출금" + "  | 잔고 : " + dc.donation());
					break;
				}
				
				try {
					sleep(rd.nextInt(901) + 100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			try {
				sleep(rd.nextInt(901) + 100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}


