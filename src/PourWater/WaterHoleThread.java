package PourWater;

public class WaterHoleThread extends Thread {
	protected WaterTankEx tank;
	protected int amount;
	int hId;
	
	public WaterHoleThread(WaterTankEx tank, int amount) {
		this.tank = tank;
		this.amount = amount;
	}
	
	public void run() {
		
		tank.drain(amount, hId);
		
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
