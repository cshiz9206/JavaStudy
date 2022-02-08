package T18_2_02_Mid_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class WordCounter {
	ArrayList<String> words;
	ArrayList<Integer> wordCounts;
	DefaultListModel dlm;
	
	public WordCounter(JList jl) {
		dlm = (DefaultListModel)jl.getModel();
	}
	
	public void wordCount(String context) {
		words = new ArrayList<>();
		wordCounts = new ArrayList<>();
		String[] contextarr = context.split(" |\n");
		for(String str : contextarr) System.out.println(str);
		StringTokenizer stk = new StringTokenizer(context);
		while(stk.hasMoreTokens()) {
			String tmpWord = stk.nextToken().trim();
			boolean tmp = true;
			for(int i = 0; i < words.size(); i++) {
				if(words.get(i).contentEquals(tmpWord)) {
					wordCounts.set(i, wordCounts.get(i) + 1);
					tmp = false;
				}
			}
			if(tmp)	{
				words.add(tmpWord);
				wordCounts.add(1);
			}
		}
	}
	
	public String toString() {
		String str = "";
		for(int i = 0; i < words.size(); i++) {
			str += words.get(i) + " " + wordCounts.get(i) + "\n";
			dlm.addElement(words.get(i) + " " + wordCounts.get(i) + "\n");
		}
		return str;
	}
}
