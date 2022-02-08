package DonationAngelThread;

public class DonationCenter {
	private int goal; // 후원금 목표액
	private int donation = 0; // 현재 후원금 총액

	// 후원금 입금
	synchronized void donate(int contribution) {
		donation += contribution;
	}
	
	// 후원금 출금
	synchronized void withdraw(int receipt) {
		donation -= receipt;
	}
	
	
	public int goal() { return goal; }
	public int donation() { return donation; }
	
	public void setGoal(int goal) { this.goal = goal; }
}
