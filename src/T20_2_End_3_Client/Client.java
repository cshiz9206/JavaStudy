package T20_2_End_3_Client;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class Client extends Thread {
	Socket socket;
	BufferedReader in; BufferedWriter out;
	JProgressBar[] jpbs;
	JLabel[] jlbIndexes;
	String[] index;
	FileIO io;
	
	public Client(String IP, int port, JProgressBar[] jpbs, JLabel[] jlbIndexes, String[] index) {
		try {
			socket = new Socket(IP, port);
			System.out.println("서버에 접속");
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.jpbs = jpbs;
		this.jlbIndexes = jlbIndexes;
		this.index = index;
		io = new FileIO();
	}
	
	public void run() {
		while(true) {
			try {
				String msg = in.readLine();
				
				io.write(msg);
				print(io.read().trim().split(","));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void print(String[] data) {
		for(int i = 0; i < data.length; i++) {
			jpbs[i].setValue((int)Float.parseFloat(data[i]));
			if(jpbs[i].getValue() < 0) jpbs[i].setForeground(Color.RED);
			else jpbs[i].setForeground(Color.GREEN);
			jlbIndexes[i].setText(index[i] + " : " + data[i]);
		}
	}
	
	public void sendMsg(String msg) {
		try {
			out.write(msg);
			out.newLine();
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
