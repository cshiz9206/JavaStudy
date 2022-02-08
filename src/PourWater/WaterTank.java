package PourWater;

public class WaterTank {
	protected int water;
	
	public WaterTank(int water) {
		// 물의 양 초기화
		this.water = water;
	}
	
	public synchronized void drain(int amount) {
		// amount 만큼 물 빠짐
		water -= amount;
	}
	
	public synchronized void pour(int amount) {
		// amount 만큼 물 보충
		water += amount;
	}
	
	public int getWater() { return water; }
}