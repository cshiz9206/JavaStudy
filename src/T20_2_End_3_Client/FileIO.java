package T20_2_End_3_Client;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO {
	public String read() {
		FileReader fr;
		String data = "";
		try {
			fr = new FileReader("bio.txt");
		
			int i;
			data = "";
			while((i = fr.read()) != -1) {
				data += (char)i;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
	}
	
	public void write(String data) {
		FileWriter fw;
		try {
			fw = new FileWriter("bio.txt");
			fw.write(data + "\n");
			fw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
