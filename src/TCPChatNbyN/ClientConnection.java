package TCPChatNbyN;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JTextArea;

public class ClientConnection extends Thread {
	int connectNo;
	TcpServer tcpServer;
	BufferedReader in; BufferedWriter out;
	boolean isSendNow = false; String receivedMsg;
	JTextArea jtaChat;
	
	public ClientConnection(int connectNo, TcpServer tcpServer, Socket socket, JTextArea jtaChat) {
		this.connectNo = connectNo;
		this.jtaChat = jtaChat;
		this.tcpServer = tcpServer;
		
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run() {
		while(true) {
			try {
				receivedMsg = in.readLine() + "\n";
				jtaChat.append(receivedMsg);
				
				isSendNow = true;
				tcpServer.sendMsg(connectNo, receivedMsg); // 서버에서 받은 msg를 다른 클라이언트들에 전송
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
	
	public boolean isSendNow() { return isSendNow; }
	public void setIsSendNow() { isSendNow = false; }
}