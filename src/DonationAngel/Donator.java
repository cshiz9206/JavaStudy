package DonationAngel;

public class Donator {
	boolean donate(int amount) {
		// �Ŀ����� <= 20 �̸� ��μ��Ϳ� ���
		// �ƴϸ� true ��ȯ
		if (amount > 20) {
			System.out.println("��α��� 1ȸ 20���� ���ϸ� �����մϴ�.");
			return false;
		}
		DonationCenter.deposit(amount);
		return true;
	}
}
