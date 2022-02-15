package TCPBreakOutServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientConnection extends Thread {
	int connectNo;
	TcpServer tcpServer;
	BufferedReader in; BufferedWriter out;
//	ObjectInputStream inObj;
//	ObjectOutputStream outObj;
	boolean isSendNow = false; 
	String receivedMsg;
	
	public ClientConnection(int connectNo, TcpServer tcpServer, Socket socket) {
		this.connectNo = connectNo;
		this.tcpServer = tcpServer;
		
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//			outObj = new ObjectOutputStream(socket.getOutputStream());
//			inObj = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(connectNo + "�� Ŭ���̾�Ʈ ����");
	}
	
	public void run() {
		while(true) {
			try {
				receivedMsg = in.readLine();
				System.out.println(receivedMsg);
				
				if(receivedMsg != null) isSendNow = true;
				tcpServer.sendMsg(connectNo, receivedMsg); // �������� ���� msg�� �ٸ� Ŭ���̾�Ʈ�鿡 ����
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void sendMsg(String data) {
		try {
			System.out.println(data);
			out.write(data);
			out.newLine();
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean isSendNow() { return isSendNow; }
	public void setIsSendNow() { isSendNow = false; }
}