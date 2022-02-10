package OwnGame2;

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
//	BufferedReader in;
//	BufferedWriter out;
	ObjectInputStream in;
	ObjectOutputStream out;
	Bar data;
	
	final int PORT = 9999;
	
	public TcpClient() {
		try {
			System.out.println(InetAddress.getLocalHost().getHostAddress()); //https://onmay.tistory.com/18
			clientSocket = new Socket(InetAddress.getLocalHost().getHostAddress(), PORT);
			System.out.println("서버와 연결이 되었습니다.\n");
//			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//			out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
			out = new ObjectOutputStream(clientSocket.getOutputStream());
			in = new ObjectInputStream(clientSocket.getInputStream());
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println();
			e.printStackTrace();
		}
	}
	
	public void run() {
		while(true) {
			try {
				data = (Bar) in.readObject(); // line 중단점(\n) 주의
				System.out.println(data);
				if(data != null)
					BreakOutClientFrame.setObjects(data/*, (Ball)data.get(1), (JLabel)data.get(2)*/);
			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void sendMsg(Object obj) {
		try {
			//System.out.println(obj);
			out.writeObject(obj);
			//out.newLine();
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
