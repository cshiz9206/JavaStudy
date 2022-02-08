package T18_2_01_End_1_Server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JTextArea;

public class Server extends Thread {
	DatagramSocket dskt;
	String[] UdpInf;
	byte[] bufReceive, bufSend;
	JTextArea ticketSoldLog;
	
	int totalTicket = 100;
	
	public Server(String[] UdpInf, JTextArea ticketSoldLog) {
		this.UdpInf = UdpInf;
		this.ticketSoldLog = ticketSoldLog;
		try {
			dskt = new DatagramSocket(Integer.parseInt(UdpInf[0]));
		} catch (NumberFormatException | SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized void buyTicket(String clientId) {
		if(totalTicket > 0) {
			totalTicket -= 1;
			
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sendMsg(clientId);
			ticketSoldLog.append(clientId + ": 티켓을 구매했습니다. (남은 개수 : " + totalTicket + ")\n");
		}
	}
	
	public void run() {
		while(true) {
			if(totalTicket == 0) {
				ticketSoldLog.append("티켓이 완판되었습니다!");
				break;
			}
			
			bufReceive = new byte[10];
			DatagramPacket dpkt = new DatagramPacket(bufReceive, bufReceive.length);
			try {
				dskt.receive(dpkt);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String clientId = new String(dpkt.getData()).trim();
			buyTicket(clientId);
		}
	}
	
	public void sendMsg(String context) {
		bufSend = context.getBytes();
		try {
			DatagramPacket dpkt = new DatagramPacket(bufSend, bufSend.length, InetAddress.getByName(UdpInf[1]), Integer.parseInt(UdpInf[2]));
			dskt.send(dpkt);
		} catch (NumberFormatException | UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
