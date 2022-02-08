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
			jtaChat.append("Ŭ���̾�Ʈ ����\n");
			connectedCnt += 1;
		}
	}
	
	public void sendMsg(int sentNo, String msg) {
		int sentClientNo = 0;
		
		// ���� server�� ���� �����͸� ���� Ŭ���̾�Ʈ ã��
		for(int i = 0; i < connectedCnt; i++) {
			if(clientConnections[i].isSendNow) sentClientNo = i;
		}
		
		// ���� server�� ���� �����͸� ���� Ŭ���̾�Ʈ�� ������ Ŭ���̾�Ʈ �����Ͽ� ������ ����
		for(int i = 0; i < connectedCnt; i++) {
			// server�� �����ϴ� �������� ��� ��� Ŭ���̾�Ʈ�� ����
			if(!msg.substring(0, 6).contentEquals("Server") & sentClientNo == i) {
				continue;
			}
			clientConnections[i].sendMsg(msg);
		}
		
		clientConnections[sentClientNo].setIsSendNow();
		chatBoard.insertBoard(sentNo, msg.substring(9));
	}
}
