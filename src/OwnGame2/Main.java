package OwnGame2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		TcpClient tcpConnect = new TcpClient();
//		tcpConnect.start();
		new Thread(new StageThread()).start();
	}

}
