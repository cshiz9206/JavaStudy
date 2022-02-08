package DonationAngel;

public class Donator {
	boolean donate(int amount) {
		// 후원금이 <= 20 이면 기부센터에 기부
		// 아니면 true 반환
		if (amount > 20) {
			System.out.println("기부금은 1회 20만원 이하만 가능합니다.");
			return false;
		}
		DonationCenter.deposit(amount);
		return true;
	}
}
