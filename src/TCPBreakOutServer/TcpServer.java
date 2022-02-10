package TCPBreakOutServer;

import java.io.IOException;
import java.net.ServerSocket;

public class TcpServer extends Thread {
	ClientConnection[] clientConnections;
	ServerSocket listener;
	final int clientMax = 2;
	int connectedCnt = 0;
	
	public TcpServer(int port) {
		clientConnections = new ClientConnection[clientMax];
		try {
			listener = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run() {
		while(true) {
			try {
				// connectNo = connectedCnt + 1
				clientConnections[connectedCnt] = 
						new ClientConnection(connectedCnt + 1, this, listener.accept());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			clientConnections[connectedCnt].start();
			connectedCnt += 1;
		}
	}
	
	public void sendMsg(int sentNo, Object obj) {
		int sentClientNo = 0;
		
		// ���� server�� ���� �����͸� ���� Ŭ���̾�Ʈ ã��
		for(int i = 0; i < connectedCnt; i++) {
			if(clientConnections[i].isSendNow) sentClientNo = i;
		}
		
		// ���� server�� ���� �����͸� ���� Ŭ���̾�Ʈ�� ������ Ŭ���̾�Ʈ �����Ͽ� ������ ����
		for(int i = 0; i < connectedCnt; i++) {
			// server�� �����ϴ� �������� ��� ��� Ŭ���̾�Ʈ�� ����
			if(sentClientNo == i) {
				continue;
			}
			clientConnections[i].sendMsg(obj);
		}
		
		clientConnections[sentClientNo].setIsSendNow();
	}
}
