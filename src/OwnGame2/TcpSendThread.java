package OwnGame2;

import javax.swing.JLabel;

public class TcpSendThread extends Thread {
	Object[] objs;
	TcpClient tcpConnect;
	Bar user;
	public TcpSendThread(Bar user, Ball ball, JLabel info, TcpClient tcpConnect) {
		this.tcpConnect = tcpConnect;
		this.user = user;
		objs = new Object[1];
		objs[0] = user;
//		objs[1] = ball;
//		objs[2] = info;
	}
	
	public void run() {
		while(true) {
			tcpConnect.sendMsg(user);
		}
	}
}
