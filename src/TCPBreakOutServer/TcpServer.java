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
			if(connectedCnt == clientMax) sendMsg(-1, "-1,-1,-1");
		}
	}
	
	public synchronized void sendMsg(int sentNo, String data) {
//		int sentClientNo = 0;
//		
//		// ���� server�� ���� �����͸� ���� Ŭ���̾�Ʈ ã��
//		for(int i = 0; i < connectedCnt; i++) {
//			if(clientConnections[i].isSendNow) sentClientNo = i;
//		}
		
		// ���� server�� ���� �����͸� ���� Ŭ���̾�Ʈ�� ������ Ŭ���̾�Ʈ �����Ͽ� ������ ����
		for(int i = 0; i < connectedCnt; i++) {
			if(i == (sentNo - 1)) {
				//System.out.println(i);
				continue;
			}
			//System.out.println(i);
			clientConnections[i].sendMsg(data);
		}
		
		clientConnections[sentNo - 1].setIsSendNow();
	}
}
