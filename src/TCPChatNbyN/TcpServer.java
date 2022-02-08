package TCPChatNbyN;

import java.io.IOException;
import java.net.ServerSocket;

import javax.swing.JTextArea;

import TCPJdbcConnection.ChatBoard;

public class TcpServer extends Thread {
	ClientConnection[] clientConnections;
	ServerSocket listener;
	JTextArea jtaChat;
	final int clientMax = 3;
	int connectedCnt = 0;
	
	ChatBoard chatBoard; // DB(MySQL)
	
	public TcpServer(int port, JTextArea jtaChat) {
		chatBoard = new ChatBoard();
		clientConnections = new ClientConnection[clientMax];
		this.jtaChat = jtaChat;
		try {
			listener = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		chatBoard.clearBoard();
	}
	
	public void run() {
		while(true) {
			try {
				// connectNo = connectedCnt + 1
				clientConnections[connectedCnt] = 
						new ClientConnection(connectedCnt + 1, this, listener.accept(), jtaChat);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			clientConnections[connectedCnt].start();
			jtaChat.append("클라이언트 접속\n");
			connectedCnt += 1;
		}
	}
	
	public void sendMsg(int sentNo, String msg) {
		int sentClientNo = 0;
		
		// 현재 server에 들어온 데이터를 보낸 클라이언트 찾기
		for(int i = 0; i < connectedCnt; i++) {
			if(clientConnections[i].isSendNow) sentClientNo = i;
		}
		
		// 현재 server에 들어온 데이터를 보낸 클라이언트와 나머지 클라이언트 구분하여 데이터 전송
		for(int i = 0; i < connectedCnt; i++) {
			// server가 전송하는 데이터일 경우 모든 클라이언트에 전송
			if(!msg.substring(0, 6).contentEquals("Server") & sentClientNo == i) {
				continue;
			}
			clientConnections[i].sendMsg(msg);
		}
		
		clientConnections[sentClientNo].setIsSendNow();
		chatBoard.insertBoard(sentNo, msg.substring(9));
	}
}
