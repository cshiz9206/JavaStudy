package CalcDday;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class FileIO {
	BufferedWriter bw;
	
	public FileIO() {
		try {
			bw = new BufferedWriter(new FileWriter("dday.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void write(String context) {
		try {
			bw.write(context);
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
