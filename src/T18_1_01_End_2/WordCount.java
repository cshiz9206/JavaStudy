package T18_1_01_End_2;

public class WordCount {
	String[] android = {"삼성", "구글", "안드로이드"};
	String[] iphone = {"애플", "아이폰"};
	
	public int wordCount(String context, String keyword) {
		int cnt = 0;

		if(keyword.contentEquals("안드로이드")) {
			for(int j = 0; j < android.length; j++) {
				for(int i = 0; i < (context.length() - android[j].length()); i++) {
					if(context.substring(i, i + android[j].length()).contentEquals(android[j])) cnt += 1;
				}
			}
		}
		else if(keyword.contentEquals("아이폰")) {
			for(int j = 0; j < iphone.length; j++) {
				for(int i = 0; i <= (context.length() - iphone[j].length()); i++) {
					if(context.substring(i, i + iphone[j].length()).contentEquals(iphone[j])) cnt += 1;
				}
			}
		}
		return cnt;
	}
}
