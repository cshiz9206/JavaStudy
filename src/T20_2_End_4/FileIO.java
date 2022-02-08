package T20_2_End_4;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO {
	public String read() {
		FileReader fr;
		String data = "";
		String[] lines = null;
		try {
			fr = new FileReader("bio.txt");
		
			int i;
			data = "";
			while((i = fr.read()) != -1) {
				data += (char)i;
			}
			lines = data.split("\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lines[lines.length - 1];
	}
	
	public void write(String data) {
		FileWriter fw;
		try {
			fw = new FileWriter("bio.txt", true);
			fw.write(data + "\n");
			fw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
