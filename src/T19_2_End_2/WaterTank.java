package T19_2_End_2;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class WaterTank {
	int water = 1000;
	JProgressBar jpb;
	JLabel jlbAmount;
	boolean isFull = false;
	boolean isEmpty = false;
	
	public WaterTank(JProgressBar jpb, JLabel jlbAmount) {
		this.jpb = jpb;
		this.jlbAmount = jlbAmount;
	}
	
	synchronized void drain(int amount) {
		if(!isFull && !isEmpty) {
			water -= amount;
			jpb.setValue(water);
			jlbAmount.setText(String.valueOf(water));
		}
		
		if(water <= 0) isEmpty = true;
	}
	
	synchronized void pour(int amount) {
		if(!isFull && !isEmpty) {
			water += amount;
			jpb.setValue(water);
			jlbAmount.setText(String.valueOf(water));
		}
		
		if(water >= 2000) isFull = true;
	}
}
