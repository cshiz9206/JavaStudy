package DonationAngel;
import java.util.*;

public class DonationCenter {
	static int goal; // �Ŀ��� ��ǥ��
	static int donation; // �Ŀ��� �Ѿ�

	static void deposit(int depositAmount) {
		donation += depositAmount;
	}
	
	static void withdraw(int withdrawAmount) {
		if ((donation - withdrawAmount) < 0) donation = 0;
		else donation -= withdrawAmount;
	}

	boolean checkSuccess() {
		if(goal > donation)
			return false;
		return true;
	}
}