package T18_2_01_Mid_1;

import java.io.FileWriter;
import java.io.IOException;

public class FileIO {
	FileWriter fw;
	
	public FileIO() {
		try {
			fw = new FileWriter("result.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void write(String str) {
		try {
			fw.write(str);
			fw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
