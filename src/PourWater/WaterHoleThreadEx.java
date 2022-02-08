package PourWater;

public class WaterHoleThreadEx extends WaterHoleThread {
	
	public WaterHoleThreadEx(int hId, WaterTankEx tank, int amount) {
		super(tank, amount);
		super.hId = hId;
	}
	
	public void run() {
		while(true) {
			super.run();
		}
	}
}
