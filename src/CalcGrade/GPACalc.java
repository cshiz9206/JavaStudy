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
		System.out.println("====== 1�б� ���� ======");
		System.out.println(sbFileContent);
		System.out.println("=====================");
	}
	
	void printGpa() {
		String data = sbFileContent.toString();
		String[] line = data.split("\n"); // line ������ ������
		float sum = 0;
		int cnt = 0;
		for(int i = 0; i < line.length; i += 1) {
			String[] tmp = line[i].split(" "); // �ܾ� ������ ������
			sum += Float.parseFloat(tmp[2]);
			cnt += 1; // ���� ��(���� ��) ī��Ʈ
		}
		System.out.printf("1�б� ��������� %.2f�Դϴ�.", (sum / cnt));
	}
}
