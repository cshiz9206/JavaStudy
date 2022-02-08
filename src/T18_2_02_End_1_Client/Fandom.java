package T18_2_02_End_1_Client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import T18_2_02_End_1_Server.ServerThread;

public class Fandom extends Thread {
	static DatagramSocket socket;
	JTextField jtfSIP, jtfSPort;
	JTextArea jta;
	static int fanCnt = 0;
	int tryCnt = 0;
	int ticketCnt = 0;
	public static Fandom[] fans;
	
	public Fandom(JTextArea jta, JTextField jtfCPort, JTextField jtfSIP, JTextField jtfSPort) {
		try {
			if(fanCnt == 0) socket = new DatagramSocket(Integer.parseInt(jtfCPort.getText()));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		fanCnt += 1;
		this.setName(String.valueOf(fanCnt));
		
		this.jtfSIP = jtfSIP;
		this.jtfSPort = jtfSPort;
		this.jta = jta;
	}
	
	public void run() {
		sendMsg(this.getName());
		while(tryCnt < 5) {
			if(ServerThread.ticket == 0) 
				break;
			
			byte[] bufReceive = new byte[10];
			DatagramPacket packet = new DatagramPacket(bufReceive, bufReceive.length);
			try {
				socket.receive(packet);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String msg = new String(packet.getData()).trim();
			for(int i = 0; i < fans.length; i++) {
				if(fans[i].getName().contentEquals(msg)) {
					fans[i].ticketCnt += 1;
					jta.append(msg + ": 티켓을 구매했습니다. (보유 개수 : " + fans[i].ticketCnt + ")\n");
					if(fans[i].ticketCnt != 1) {
						sendMsg(this.getName());
					}
				}
			}
			
			if(ticketCnt == 1)
				break;
			
			tryCnt += 1;
		}
	}
	
	public void sendMsg(String context) {
		byte[] bufSend = context.getBytes();
		try {
			DatagramPacket packet = new DatagramPacket(bufSend, bufSend.length, InetAddress.getByName(jtfSIP.getText()), Integer.parseInt(jtfSPort.getText()));
			socket.send(packet);
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
