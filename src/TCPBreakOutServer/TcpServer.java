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
//		// 현재 server에 들어온 데이터를 보낸 클라이언트 찾기
//		for(int i = 0; i < connectedCnt; i++) {
//			if(clientConnections[i].isSendNow) sentClientNo = i;
//		}
		
		// 현재 server에 들어온 데이터를 보낸 클라이언트와 나머지 클라이언트 구분하여 데이터 전송
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
