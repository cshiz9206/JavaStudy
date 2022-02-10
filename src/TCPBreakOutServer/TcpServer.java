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
		
		// 현재 server에 들어온 데이터를 보낸 클라이언트 찾기
		for(int i = 0; i < connectedCnt; i++) {
			if(clientConnections[i].isSendNow) sentClientNo = i;
		}
		
		// 현재 server에 들어온 데이터를 보낸 클라이언트와 나머지 클라이언트 구분하여 데이터 전송
		for(int i = 0; i < connectedCnt; i++) {
			// server가 전송하는 데이터일 경우 모든 클라이언트에 전송
			if(sentClientNo == i) {
				continue;
			}
			clientConnections[i].sendMsg(obj);
		}
		
		clientConnections[sentClientNo].setIsSendNow();
	}
}
