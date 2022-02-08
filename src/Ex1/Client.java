package Ex1;

import java.io.*;
import java.net.*;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class Client extends Thread {
	Socket c;
	BufferedReader br;
	BufferedWriter bw;
	JTextArea jta;
	JButton jbSend;
	JButton jbReceive;

	public Client(String server, int port, JTextArea jta, JButton jbSend, JButton jbReceive) throws Exception {
		this.jta = jta;
		this.jbSend = jbSend;
		this.jbReceive = jbReceive;

		c = new Socket(server, port); // 소켓 생성
		InputStreamReader is = new InputStreamReader(c.getInputStream());
		br = new BufferedReader(is);
		OutputStreamWriter os = new OutputStreamWriter(c.getOutputStream());
		bw = new BufferedWriter(os);
		System.out.println(Server.complete + "c");
	}

	public void sendYearMonth(String str) { // 연,월을 서버에게 전송
		try {
			bw.write(str + "\n");
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		System.out.println(Server.complete + "c");
		while (true) { // 서버가 달력을 다 보낼때까지 수신받음
			try {
				System.out.println(Server.complete + "c");
				String str=br.readLine();
				
				if (Server.complete == 1) {
					c.close(); // 연결 해제
					jbSend.setEnabled(true);
					jbReceive.setEnabled(false);
					System.out.println(Server.complete + "c");
					break;
				}
				System.out.println(Server.complete + "c");
				jta.append(str + "\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Server.complete + "c");
	}
}
