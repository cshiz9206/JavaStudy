package OwnGame4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JLabel;

public class TcpClient extends Thread {
	Socket clientSocket;
	BufferedReader in;
	static BufferedWriter out;
//	ObjectInputStream in;
//	ObjectOutputStream out;
	int[] data;
	
	final int PORT = 9999;
	
	Bar bar;
	Bar bar2;
	Ball ball;
	
	static boolean allConnected = false;
	
	public TcpClient(Bar bar, Bar bar2, Ball ball) {
		try {
			System.out.println(InetAddress.getLocalHost().getHostAddress()); //https://onmay.tistory.com/18
			clientSocket = new Socket("210.102.142.30", PORT);
			System.out.println("서버와 연결이 되었습니다.\n");
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
//			out = new ObjectOutputStream(clientSocket.getOutputStream());
//			in = new ObjectInputStream(clientSocket.getInputStream());
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println();
			e.printStackTrace();
		}
		
		this.bar = bar;
		this.bar2 = bar2;
		this.ball = ball;
	}
	
	public void run() {
		data = new int[3];
		while(true) {
			try {
				String tmp = in.readLine(); // line 중단점(\n) 주의
				//System.out.println(tmp);
				
				if(tmp != null) {
					System.out.println(tmp.split(",")[0]);
					data[0] = Integer.parseInt(tmp.split(",")[0]); // bar
					data[1] = Integer.parseInt(tmp.split(",")[1]); // ball x
					data[2] = Integer.parseInt(tmp.split(",")[2]); // ball y
					
					if(data[0] == -1) {
						allConnected = true;
					}
					else {
//						if(data[0] == 1) {
//							bar2.moveLeft();
//							if((ball.getY() >= 900 - 150) && (ball.ySpeed > 0)) bar2.setMovLeftAmt(1);
//							bar2.resetMovRightAmt();
//						}
//						if(data[0] == 2) {
//							bar2.moveRight();
//							if((ball.getY() >= 900 - 150) && (ball.ySpeed > 0)) bar2.setMovRightAmt(1);
//							bar2.resetMovLeftAmt();
//						}
						bar2.moveByConnect(data[0]);
						ball.moveByConnect(data[1], data[2]);
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void sendMsg(int barX, int ballX, int ballY) {
		try {
			//System.out.println(barX + "," + ballX + "," + ballY);
			out.write(barX + "," + ballX + "," + ballY);
			out.newLine();
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
