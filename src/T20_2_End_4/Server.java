package T20_2_End_4;

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
				
				String type = msg[0];
				int year = Integer.parseInt(msg[1]);
				int month = Integer.parseInt(msg[2]);
				int date = Integer.parseInt(msg[3]);
				
				String result = "";
				if(type.contentEquals("신체지수")) result = calcBody(year, month, date);
				if(type.contentEquals("감성지수")) result = calcSens(year, month, date);
				if(type.contentEquals("지성지수")) result = calcIntel(year, month, date);
				if(type.contentEquals("지각지수")) result = calcPercept(year, month, date);
				
				sendMsg(result);
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
	
	public String calcBody(int year, int month, int date) {
		String resultStr = "";
		LocalDate birth = LocalDate.of(year, month, date);
		for(int i = 0; i < 10; i++) {
			LocalDate now = LocalDate.now();
			long time = ChronoUnit.DAYS.between(birth, now.plusDays(i));
			resultStr += String.format("%.2f", Math.sin(2 * Math.PI * time / 23) * 100) + ",";
		}
		return resultStr;
	}
	
	public String calcSens(int year, int month, int date) {
		String resultStr = "";
		LocalDate birth = LocalDate.of(year, month, date);
		for(int i = 0; i < 10; i++) {
			LocalDate now = LocalDate.now();
			long time = ChronoUnit.DAYS.between(birth, now.plusDays(i));
			resultStr += String.format("%.2f", Math.sin(2 * Math.PI * time / 28) * 100) + ",";
		}
		return resultStr;
	}
	
	public String calcIntel(int year, int month, int date) {
		String resultStr = "";
		LocalDate birth = LocalDate.of(year, month, date);
		for(int i = 0; i < 10; i++) {
			LocalDate now = LocalDate.now();
			long time = ChronoUnit.DAYS.between(birth, now.plusDays(i));
			resultStr += String.format("%.2f", Math.sin(2 * Math.PI * time / 33) * 100) + ",";
		}
		return resultStr;
	}
	
	public String calcPercept(int year, int month, int date) {
		String resultStr = "";
		LocalDate birth = LocalDate.of(year, month, date);
		for(int i = 0; i < 10; i++) {
			LocalDate now = LocalDate.now();
			long time = ChronoUnit.DAYS.between(birth, now.plusDays(i));
			resultStr += String.format("%.2f", Math.sin(2 * Math.PI * time / 38) * 100) + ",";
		}
		return resultStr;
	}
}
