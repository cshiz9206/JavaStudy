package DonationAngelThread;

public class DonationCenter {
	private int goal; // �Ŀ��� ��ǥ��
	private int donation = 0; // ���� �Ŀ��� �Ѿ�

	// �Ŀ��� �Ա�
	synchronized void donate(int contribution) {
		donation += contribution;
	}
	
	// �Ŀ��� ���
	synchronized void withdraw(int receipt) {
		donation -= receipt;
	}
	
	
	public int goal() { return goal; }
	public int donation() { return donation; }
	
	public void setGoal(int goal) { this.goal = goal; }
}
