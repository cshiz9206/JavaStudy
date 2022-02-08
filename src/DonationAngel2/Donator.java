package DonationAngel2;

public class Donator {
	DonationCenter donateCenter = new DonationCenter();
	
	void donate(int amount) {
		donateCenter.deposit(amount);
	}
}
