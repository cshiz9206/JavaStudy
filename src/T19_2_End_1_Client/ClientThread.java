package T19_2_End_1_Client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JTextArea;

public class ClientThread extends Thread {
	Socket cs;
	BufferedReader in;
	BufferedWriter out;
	JTextArea jta;
	
	public ClientThread(String serverIP, int serverPort, JTextArea jta) {
		this.jta = jta;
		try {
			cs = new Socket(serverIP, serverPort);
			in = new BufferedReader(new InputStreamReader(cs.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(cs.getOutputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run() {
		while(true) {
			try {
				String received = in.readLine();
				
				jta.append(received + "\n");
				
				if(received.contains("31") || received.contains("30") 
						|| received.contains("28") || received.contains("29")) {
					jta.append("\n");
					cs.close();
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void sendMsg(String msg) {
		try {
			out.write(msg);
			out.newLine();
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
