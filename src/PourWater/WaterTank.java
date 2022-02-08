package PourWater;

public class WaterTank {
	protected int water;
	
	public WaterTank(int water) {
		// ���� �� �ʱ�ȭ
		this.water = water;
	}
	
	public synchronized void drain(int amount) {
		// amount ��ŭ �� ����
		water -= amount;
	}
	
	public synchronized void pour(int amount) {
		// amount ��ŭ �� ����
		water += amount;
	}
	
	public int getWater() { return water; }
}