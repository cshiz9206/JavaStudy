package TCPBreakOutServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class TcpServer extends Thread {
	ArrayList<ClientConnection> clientConnections;
	ServerSocket listener;
	final int clientMax = 3;
	int connectedCnt = 0;
	
	public TcpServer(int port) {
		clientConnections = new ArrayList<ClientConnection>();
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
				for(ClientConnection cc : clientConnections) {
					if(!cc.isAlive()) {
						cc = null;
					}
				}
				clientConnections.add(new ClientConnection(connectedCnt + 1, this, listener.accept()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			clientConnections.get(connectedCnt).start();
			connectedCnt += 1;
			if(connectedCnt % clientMax == 0) sendMsg(-1, "-1,-1,-1,-1,-1,-1");
		}
	}
	
	public synchronized void sendMsg(int sentNo, String data) {
		
		// 현재 server에 들어온 데이터를 보낸 클라이언트와 나머지 클라이언트 구분하여 데이터 전송
		for(int i = 0; i < connectedCnt; i++) {
			if(i == (sentNo - 1)) {
				//System.out.println(i);
				continue;
			}
			//System.out.println(i);
			clientConnections.get(i).sendMsg(data);
		}
		
		if(sentNo >= 0) clientConnections.get(sentNo - 1).setIsSendNow();
	}
}
