package WordCounter;

import java.util.StringTokenizer;

public class WordCounter {
	FileIO io;
	String context;
	
	public WordCounter() {
		io = new FileIO();
		context = io.read_file();
	}
	
	public void process() {
		io.println("워트카운터 입니다.");
		io.println("분석결과 (단어명 : 개수)");
		summary(set_strlist());
	}
	
	public String[] set_strlist() {
		StringTokenizer stk = new StringTokenizer(context, ".| |\r\n|,");
		String[] tmp = new String[stk.countTokens()];
		int i = 0;
		while(stk.hasMoreTokens()) {
			tmp[i] = stk.nextToken();
			i++;
		}
		return tmp;
	}
	
	public void summary(String[] str_list) {
		String[][] tmp = new String[str_list.length][1];
		int cnt = 0;
		for(int i = 0; i < str_list.length; i++) {
			cnt = 0;
			for(int j = 0; j < str_list.length; j++) {
				if(str_list[i].contentEquals(str_list[j])) cnt += 1;
			}
			io.println(str_list[i] + " : " + cnt);
		}
	}
}
