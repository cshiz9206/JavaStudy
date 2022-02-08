package DonationAngelThread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;

public class Donator extends Thread {
	DonationCenter dc;
	DefaultListModel dlmDonateLog;
	JLabel jlb;
	private int contribution;
	
	public Donator(DonationCenter dc, DefaultListModel dlmDonateLog, JLabel jlb) {
		this.dc =  dc;
		this.dlmDonateLog = dlmDonateLog;
		this.jlb = jlb;
	}
	
	public void run() {
		Random rd = new Random();
		
		while(true) {
			if(dc.goal() <= dc.donation()) {
				jlb.setText("목표 기부금 : " + dc.goal() + ", 현재 기부금 : " + dc.donation() + " - 목표 달성!!");
				break;
			}
			
			contribution = rd.nextInt(500001);
			
			String format = "yyyy-MM-dd HH:mm:ss.SSS";
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			
			if(contribution < 100000 | contribution > 500000) {
				System.out.println("기부금은 1회 10만원 이상, 50만원 이하만 가능합니다.");
				continue;
			}
			
			dc.donate(contribution);
			dlmDonateLog.addElement(sdf.format(new Date()) + "  | " + contribution + "원 입금" + "  | 잔고 : " + dc.donation());
			
			try {
				sleep(rd.nextInt(901) + 100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
