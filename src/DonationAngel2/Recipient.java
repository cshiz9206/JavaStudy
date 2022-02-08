package DonationAngel2;

public class Recipient {
	DonationCenter donateCenter = new DonationCenter();
	
	void receipt() {
		donateCenter.withdraw(8);
	}
}
