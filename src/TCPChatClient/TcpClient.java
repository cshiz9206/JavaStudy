package TCPChatClient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TcpClient extends Thread {
	Socket clientSocket;
	JTextArea jtaChat;
	BufferedReader in;
	BufferedWriter out;
	
	public TcpClient(JTextArea jtaChat, JTextField jtfServIP, JTextField jtfServPort) {
		this.jtaChat = jtaChat;
		
		try {
			clientSocket = new Socket(jtfServIP.getText(), Integer.parseInt(jtfServPort.getText()));
			jtaChat.append("서버와 연결이 되었습니다.\n");
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println();
			e.printStackTrace();
		}
	}
	
	public void run() {
		while(true) {
			try {
				jtaChat.append(in.readLine() + "\n"); // line 중단점(\n) 주의
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void sendMsg(String msg) {
		try {
			out.write(msg);
			//out.newLine();
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
