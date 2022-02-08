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

	// �޷� ���� (Ŭ���̾�Ʈ���� �� �پ� ����)
	public void createCal(int year, int month) {
		cal="";
		cal += "<" + year + "�� " + month + "��>\n";
		cal += "Sun\tMon\tTue\tWed\tThu\tFri\tSat\n"; // ���� ����
		c.set(year, month - 1, 1);
		int week = c.get(c.DAY_OF_WEEK); // 1���� ����
		int lastDay = c.getActualMaximum(c.DATE);
		for (int i = 1; i < week; i++) {
			cal += "\t";
		}

		// ��¥ ����
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
		jta.append("�޷� ���� �Ϸ�\n");
	}

	public void sendCal(String calendar) { //�޷� ����
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
				s = ss.accept(); // ����
				OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
				bw = new BufferedWriter(os);
				InputStreamReader is = new InputStreamReader(s.getInputStream());
				br = new BufferedReader(is);
				str = br.readLine(); // Ŭ���̾�Ʈ���� ��,���� ����
			} catch (Exception e) {
				e.printStackTrace();
			}
			jta.append(str + "\n"); // jta�� �߰�
			String[] strArr = str.split("-"); // "-"�������� ��� ���� �и�
			createCal(Integer.parseInt(strArr[0]), Integer.parseInt(strArr[1])); // �޷� ����
			sendCal(cal); //�޷� ����
			complete = 1;
			try {
				s.close(); // ���� ����
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
