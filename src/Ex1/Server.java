package Ex1;

import java.io.*;
import java.net.*;
import javax.swing.JTextArea;

import java.util.Calendar;

public class Server extends Thread {
	JTextArea jta;
	ServerSocket ss;
	Socket s;
	BufferedWriter bw;
	BufferedReader br;
	Calendar c;
	String[] day = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
	String str;
	String cal="";
	static int complete = 0;

	public Server(int port, JTextArea jta) throws Exception {
		ss = new ServerSocket(port);
		this.jta = jta;
		c = Calendar.getInstance();
	}

	// 달력 생성 (클라이언트에게 한 줄씩 전송)
	public void createCal(int year, int month) {
		cal="";
		cal += "<" + year + "년 " + month + "월>\n";
		cal += "Sun\tMon\tTue\tWed\tThu\tFri\tSat\n"; // 요일 생성
		c.set(year, month - 1, 1);
		int week = c.get(c.DAY_OF_WEEK); // 1일의 요일
		int lastDay = c.getActualMaximum(c.DATE);
		for (int i = 1; i < week; i++) {
			cal += "\t";
		}

		// 날짜 생성
		int cnt = week;
		for (int i = 1; i <= lastDay; i++) {
			if (cnt == 7 || i == lastDay) {
				cal += (i + "\n");
				cnt = 1;
			} else {
				cal += (i + "\t");
				cnt++;
			}
		}
		jta.append("달력 전송 완료\n");
	}

	public void sendCal(String calendar) { //달력 전송
		try {
			bw.write(calendar);
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		while (true) {
			System.out.println(Server.complete + "s");
			try {
				s = ss.accept(); // 연결
				OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
				bw = new BufferedWriter(os);
				InputStreamReader is = new InputStreamReader(s.getInputStream());
				br = new BufferedReader(is);
				str = br.readLine(); // 클라이언트에게 년,월을 수신
			} catch (Exception e) {
				e.printStackTrace();
			}
			jta.append(str + "\n"); // jta에 추가
			String[] strArr = str.split("-"); // "-"기준으로 년과 월을 분리
			createCal(Integer.parseInt(strArr[0]), Integer.parseInt(strArr[1])); // 달력 생성
			sendCal(cal); //달력 전송
			complete = 1;
			try {
				s.close(); // 연결 해제
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
