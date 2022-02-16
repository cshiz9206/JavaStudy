package OwnGameHost;

import java.awt.Color;
import java.awt.Font;
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

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class TcpClient extends Thread {
	Socket clientSocket;
	BufferedReader in;
	static BufferedWriter out;
//	ObjectInputStream in;
//	ObjectOutputStream out;
	int[] data;
	
	final int PORT = 9999;
	
	Bar barClient;
	Ball ball;
	int frameX, frameY;
	
	static boolean allConnected = false;
	
	public TcpClient(Bar barClient, Ball ball, int frameX, int frameY) {
		try {
			System.out.println(InetAddress.getLocalHost().getHostAddress()); //https://onmay.tistory.com/18
			clientSocket = new Socket(InetAddress.getLocalHost().getHostAddress(), PORT);
			System.out.println("������ ������ �Ǿ����ϴ�.\n");
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
//			out = new ObjectOutputStream(clientSocket.getOutputStream());
//			in = new ObjectInputStream(clientSocket.getInputStream());
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println();
			e.printStackTrace();
		}
		
		this.barClient = barClient;
		this.ball = ball;
		this.frameX = frameX;
		this.frameY = frameY;
	}
	
	public void run() {
		data = new int[5];
		while(true) {
			try {
				if(!clientSocket.isConnected()) break;
				String tmp = in.readLine(); // line �ߴ���(\n) ����
				//System.out.println(tmp);
				
				if(tmp.contentEquals("����Ϸ�")) {
					BreakOutFrame.saveBtn.setEnabled(false);
					new SavedInfoFrame(frameX, frameY);
					BreakOutFrame.dataUpdate();
				}
				else if(tmp != null) {
					//System.out.println(tmp.split(",")[0]);
					data[0] = Integer.parseInt(tmp.split(",")[0]); // bar
					data[1] = Integer.parseInt(tmp.split(",")[1]); // bar moveLeftAmt
					data[2] = Integer.parseInt(tmp.split(",")[2]); // bar moveRightAmt
					data[3] = Integer.parseInt(tmp.split(",")[3]); // ball x
					data[4] = Integer.parseInt(tmp.split(",")[4]); // ball y
					
					if(data[0] == -1) {
						allConnected = true;
					}
					else {
						barClient.moveByConnect(data[0], data[4]);
						if(data[1] != -1) barClient.setMovLeftAmt(data[1]);
						if(data[2] != -1) barClient.setMovRightAmt(data[2]);
						ball.moveByConnect(data[3], data[4]);
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void sendMsg(String data) {
		try {
			//System.out.println(barX + "," + ballX + "," + ballY);
			out.write(data);
			out.newLine();
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
