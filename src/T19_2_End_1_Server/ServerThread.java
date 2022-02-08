package T19_2_End_1_Server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JTextArea;

public class ServerThread extends Thread {
	ServerSocket ss;
	Socket s;
	BufferedReader in;
	BufferedWriter out;
	
	JTextArea jta;
	
	Calendar cal;
	
	public ServerThread(int clientPort, JTextArea jta) {
		try {
			ss = new ServerSocket(clientPort);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.jta = jta;
	}
	
	public void run() {
		while(true) {
			try {
				s = ss.accept();
				in = new BufferedReader(new InputStreamReader(s.getInputStream()));
				out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				String received = in.readLine();
				jta.append(received + "\n");
				
				cal = new Calendar(Integer.parseInt(received.split("-")[0]), 
						Integer.parseInt(received.split("-")[1]));
				sendMsg(cal.toString());
				
				jta.append("달력 전송 완료.\n");
				
				s.close();
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
