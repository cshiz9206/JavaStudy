package T18_1_01_End_2;

public class WordCount {
	String[] android = {"�Ｚ", "����", "�ȵ���̵�"};
	String[] iphone = {"����", "������"};
	
	public int wordCount(String context, String keyword) {
		int cnt = 0;

		if(keyword.contentEquals("�ȵ���̵�")) {
			for(int j = 0; j < android.length; j++) {
				for(int i = 0; i < (context.length() - android[j].length()); i++) {
					if(context.substring(i, i + android[j].length()).contentEquals(android[j])) cnt += 1;
				}
			}
		}
		else if(keyword.contentEquals("������")) {
			for(int j = 0; j < iphone.length; j++) {
				for(int i = 0; i <= (context.length() - iphone[j].length()); i++) {
					if(context.substring(i, i + iphone[j].length()).contentEquals(iphone[j])) cnt += 1;
				}
			}
		}
		return cnt;
	}
}
