package T20_2_Mid_1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class FileIO {
	FileReader fr;
	FileWriter fw;
	
	public FileIO() {
		try {
			fw = new FileWriter("bio.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String read() {
		try {
			fr = new FileReader("bio.txt");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		int tmp;
		String context = "";
		try {
			while((tmp = fr.read()) != -1) {
				context += (char)tmp;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return context;
	}
	
	public void write(LocalDate endTmp, double body, double sens, double intel, double percept) {
		try {
			fw.write(endTmp + "," + String.format("%.2f", body) + "," + String.format("%.2f", sens) + "," + String.format("%.2f", intel) + "," + String.format("%.2f", percept) + "\n");
			fw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
