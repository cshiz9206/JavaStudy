package T20_2_End_3_Server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Server extends Thread {
	ServerSocket listener;
	Socket socket;
	BufferedReader in;
	BufferedWriter out;
	
	public Server(int port) {
		try {
			listener = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run() {
		try {
			socket = listener.accept();
			System.out.println("클라이언트 접속");
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(true) {
			try {
				String[] msg = in.readLine().split(",");
				
				int year = Integer.parseInt(msg[0]);
				int month = Integer.parseInt(msg[1]);
				int date = Integer.parseInt(msg[2]);
				
				sendMsg(calcBR(year, month, date));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	
	public String calcBR(int year, int month, int date) {
		LocalDate birth = LocalDate.of(year, month, date);
		long time = ChronoUnit.DAYS.between(birth, LocalDate.now());
		double body = Math.sin(2 * Math.PI * time / 23) * 100;
		double sens = Math.sin(2 * Math.PI * time / 28) * 100;
		double intel = Math.sin(2 * Math.PI * time / 33) * 100;
		double percept = Math.sin(2 * Math.PI * time / 38) * 100;
		return String.format("%.2f,%.2f,%.2f,%.2f", body, sens, intel, percept);
	}
}
