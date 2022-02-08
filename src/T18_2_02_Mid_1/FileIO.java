package T18_2_02_Mid_1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO {
	FileReader fr;
	FileWriter fw;
	
	public FileIO() {
		try {
			fw = new FileWriter("C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_Á¤½ÂÇö\\JAVA_edu_Á¤½ÂÇö\\src\\T18_2_02_Mid_1\\wordcount.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String read(String fileName) {
		int i;
		String context = "";
		
		try {
			fr = new FileReader("C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_Á¤½ÂÇö\\JAVA_edu_Á¤½ÂÇö\\src\\T18_2_02_Mid_1\\" + fileName);
			while((i = fr.read()) != -1) {
				context += (char)i;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return context;
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
