package T18_2_01_Mid_1;

import java.util.ArrayList;

public class Scores {
	private ArrayList<ArrayList<String>> scores;
	
	public Scores() {
		scores = new ArrayList<>();
	}
	
	public void addScoresInv(ArrayList scoresInv) {
		scores.add(scoresInv);
	}
	
	public String calcTotalAvg() {
		float sumKor = 0;
		float sumMath = 0;
		float sumEng = 0;
		
		for(ArrayList inv : scores) {
			for(int i = 0; i < inv.size(); i++) {
				if(i == 1) sumKor += Integer.parseInt((String) inv.get(i));
				if(i == 2) sumMath += Integer.parseInt((String) inv.get(i));
				if(i == 3) sumEng += Integer.parseInt((String) inv.get(i));
			}
		}
		
		float avgKor = sumKor/scores.size();
		float avgMath = sumMath/scores.size();
		float avgEng = sumEng/scores.size();
		float avgTotal = (avgKor + avgMath + avgEng) / 3;
		
		return String.format("<���� ���> ���� : %.2f, ���� : %.2f, ���� : %.2f, �� ��� : %.2f", avgKor, avgMath, avgEng, avgTotal);
	}
}
