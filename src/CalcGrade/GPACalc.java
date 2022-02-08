package CalcGrade;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class GPACalc {
	private StringBuffer sbFileContent;
	
	public GPACalc() {sbFileContent = new StringBuffer();}
	
	void readSbjGrade(String path) throws Exception {
		FileReader fr = new FileReader(path);
		int i;
		while((i = fr.read()) != -1) sbFileContent.append((char) i);
	}
	
	void printContent() {
		System.out.println("====== 1학기 성적 ======");
		System.out.println(sbFileContent);
		System.out.println("=====================");
	}
	
	void printGpa() {
		String data = sbFileContent.toString();
		String[] line = data.split("\n"); // line 단위로 나누기
		float sum = 0;
		int cnt = 0;
		for(int i = 0; i < line.length; i += 1) {
			String[] tmp = line[i].split(" "); // 단어 단위로 나누기
			sum += Float.parseFloat(tmp[2]);
			cnt += 1; // 라인 수(과목 수) 카운트
		}
		System.out.printf("1학기 평점평균은 %.2f입니다.", (sum / cnt));
	}
}
