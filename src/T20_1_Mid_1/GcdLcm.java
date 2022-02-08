package T20_1_Mid_1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GcdLcm{
	int[] arr;
	
	public GcdLcm(int[] arr) {
		this.arr = arr;
	}
	
	int gcd() {
		return forArray(chooseMethod("gcd"));
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
		return forArray(chooseMethod("lcm"));
	}
	
	int lcm(int a, int b) {
		int gcd = gcd(a, b);
		return a * b / gcd;
	}
	
	Method chooseMethod(String methodName) {
		Method method = null;
		try {
			method = getClass().getMethod(methodName, int.class, int.class);
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return method;
	}
	
	int forArray(Method method) {
		int[] tmp = arr.clone();
		
		try {
			for(int i = 0; i < tmp.length - 1; i++) {
				if(tmp[i] > tmp[i + 1]) tmp[i + 1] = (int)method.invoke(tmp[i], tmp[i + 1]);
				else tmp[i + 1] = (int)method.invoke(tmp[i + 1], tmp[i]);
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tmp[tmp.length - 1];
	}
}
