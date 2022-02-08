package TCPChatServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JTextArea;

public class TcpServer extends Thread {
	Socket socket;
	JTextArea jtaChat;
	BufferedReader in;
	BufferedWriter out;
	ServerSocket listener;
	
	public TcpServer(int port, JTextArea jtaChat) {
		this.jtaChat = jtaChat;
		
		try {
			listener = new ServerSocket(port);
//			socket = listener.accept();
//			jtaChat.append("클라이언트 접속\n");
//			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run() {
		try {
			socket = listener.accept();
			jtaChat.append("클라이언트 접속\n");
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		while(true) {
			try {
				jtaChat.append(in.readLine() + "\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void sendMsg(String msg) {
		try {
			out.write(msg);
			//out.newLine();
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
