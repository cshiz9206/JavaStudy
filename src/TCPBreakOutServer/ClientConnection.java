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
//	BufferedReader in; BufferedWriter out;
	ObjectInputStream inObj;
	ObjectOutputStream outObj;
	boolean isSendNow = false; Object receivedMsg;
	
	public ClientConnection(int connectNo, TcpServer tcpServer, Socket socket) {
		this.connectNo = connectNo;
		this.tcpServer = tcpServer;
		
		try {
//			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			outObj = new ObjectOutputStream(socket.getOutputStream());
			inObj = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(connectNo + "번 클라이언트 접속");
	}
	
	public void run() {
		while(true) {
			try {
				receivedMsg = inObj.readObject();
				//System.out.println(receivedMsg);
				
				if(receivedMsg != null) isSendNow = true;
				tcpServer.sendMsg(connectNo, receivedMsg); // 서버에서 받은 msg를 다른 클라이언트들에 전송
			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void sendMsg(Object obj) {
		try {
			//System.out.println(obj);
			outObj.writeObject(obj);
			//out.newLine();
			outObj.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean isSendNow() { return isSendNow; }
	public void setIsSendNow() { isSendNow = false; }
}