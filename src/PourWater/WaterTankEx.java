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
		// amount 만큼 물 빠짐
		while (true) { // if문(보충되었는지) 계속 검사
			if(isEmpty()) { // 물이 아예 없는 경우
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else break;
		}
		
		if(0 < water & water < amount) { // 물이 조금(100ml 이하) 남아있는 경우
			super.drain(water);
		}
		else super.drain(amount);

		jtaLossLog.append(hId + ")-" + amount + "ml, " + water + "ml 남음\n");
		prgbar.setValue(water);
		jlWaterTitle.setText(String.valueOf(water));
	}
	
	public synchronized void pour(int amount) {
		// amount 만큼 물 보충
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