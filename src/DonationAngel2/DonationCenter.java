package DonationAngel2;

public class DonationCenter {
	static int goal;
	static int donation;
	
	int getGoal() { return goal; }
	int getDonation() { return donation; }
	
	void setGoal(int tmp) { goal = tmp; }
	
	void deposit(int amount) {
		donation += amount;
	}
	
	void withdraw(int amount) {
		if (donation - amount < 0) {
			System.out.println("�ܾ��� �����մϴ�.");
		}
		else donation -= amount;
	}
}
