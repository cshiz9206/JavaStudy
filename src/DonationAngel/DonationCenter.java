package DonationAngel;
import java.util.*;

public class DonationCenter {
	static int goal; // 후원금 목표액
	static int donation; // 후원금 총액

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