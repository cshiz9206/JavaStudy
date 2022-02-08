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
				jlb.setText("��ǥ ��α� : " + dc.goal() + ", ���� ��α� : " + dc.donation() + " - ��ǥ �޼�!!");
				break;
			}
			
			contribution = rd.nextInt(500001);
			
			String format = "yyyy-MM-dd HH:mm:ss.SSS";
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			
			if(contribution < 100000 | contribution > 500000) {
				System.out.println("��α��� 1ȸ 10���� �̻�, 50���� ���ϸ� �����մϴ�.");
				continue;
			}
			
			dc.donate(contribution);
			dlmDonateLog.addElement(sdf.format(new Date()) + "  | " + contribution + "�� �Ա�" + "  | �ܰ� : " + dc.donation());
			
			try {
				sleep(rd.nextInt(901) + 100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
