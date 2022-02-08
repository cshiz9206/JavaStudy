package T19_2_Mid_1;

import java.io.FileWriter;
import java.io.IOException;

public class FileIO {
	FileWriter fw;
	
	public FileIO() {
		try {
			fw = new FileWriter("C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_Á¤½ÂÇö\\JAVA_edu_Á¤½ÂÇö\\src\\T19_2_Mid_1\\exam01_output.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void printf(String str) {
		try {
			fw.write(str);
			fw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
