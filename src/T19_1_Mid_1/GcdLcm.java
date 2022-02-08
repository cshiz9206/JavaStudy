package T19_1_Mid_1;

public class GcdLcm{
	int[] arr;
	
	public GcdLcm(int[] arr) {
		this.arr = arr;
	}
	
	int gcd() {
		int[] tmp = arr.clone();
		for(int i = 0; i < tmp.length - 1; i++) {
			if(tmp[i] > tmp[i + 1]) tmp[i + 1] = gcd(tmp[i], tmp[i + 1]);
			else tmp[i + 1] = gcd(tmp[i + 1], tmp[i]);
		}
		return tmp[tmp.length - 1];
	}
	
	int gcd(int a, int b) {
		int tmp;
		while(b > 0) {
			tmp = a;
			a = b;
			b = tmp % a;
		}
		
		return a;
	}
	
	int lcm() {
		int[] tmp = arr.clone();
		for(int i = 0; i < tmp.length - 1; i++) {
			if(tmp[i] > tmp[i + 1]) tmp[i + 1] = lcm(tmp[i], tmp[i + 1]);
			else tmp[i + 1] = lcm(tmp[i + 1], tmp[i]);
		}
		return tmp[tmp.length - 1];
	}
	
	int lcm(int a, int b) {
		int gcd = gcd(a, b);
		return a * b / gcd;
	}
}
