package OwnGame4;

public class TcpSendThread extends Thread {
	Bar bar;
	Ball ball;
	
	public TcpSendThread(Bar bar, Ball ball) {
		this.bar = bar;
		this.ball = ball;
	}
	
	public void run() {
		while(true) {
			TcpClient.sendMsg(bar.getX(), ball.getX(), ball.getY());
		}
	}
}
