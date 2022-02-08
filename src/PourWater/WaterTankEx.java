package PourWater;

import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

public class WaterTankEx extends WaterTank {
	private int waterMax;
	JTextArea jtaLossLog;
	JProgressBar prgbar;
	JLabel jlWaterTitle;
	
	public WaterTankEx(int water, JTextArea jtaLossLog, JProgressBar prgbar, JLabel jlWaterTitle) {
		super(water);
		waterMax = water;
		this.jtaLossLog = jtaLossLog;
		this.prgbar = prgbar;
		this.jlWaterTitle = jlWaterTitle;
	}
	
	public synchronized void drain(int amount, int hId) {
		// amount ��ŭ �� ����
		while (true) { // if��(����Ǿ�����) ��� �˻�
			if(isEmpty()) { // ���� �ƿ� ���� ���
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else break;
		}
		
		if(0 < water & water < amount) { // ���� ����(100ml ����) �����ִ� ���
			super.drain(water);
		}
		else super.drain(amount);

		jtaLossLog.append(hId + ")-" + amount + "ml, " + water + "ml ����\n");
		prgbar.setValue(water);
		jlWaterTitle.setText(String.valueOf(water));
	}
	
	public synchronized void pour(int amount) {
		// amount ��ŭ �� ����
		super.pour(amount);
		notifyAll();
	}
	
	public boolean isOver(int pourAmount) {
		if(waterMax >= pourAmount) return false;
		return true;
	}
	
	public boolean isEmpty() {
		if(water == 0) return true;
		return false;
	}
	
	public int getWaterMax() { return waterMax; }
}