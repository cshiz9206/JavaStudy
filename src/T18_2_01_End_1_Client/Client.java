package T18_2_01_End_1_Client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JTextArea;

import T18_2_01_End_1_Server.Server;

public class Client extends Thread {
	static Fandom2[] fans;
	final int fansMax = 50;
	static DatagramSocket dskt;
	byte[] bufReceive;
	String[] UdpInfStr;
	JTextArea ticketSoldLog;
	
	public Client(String[] UdpInfStr, JTextArea ticketSoldLog) {
		this.UdpInfStr = UdpInfStr;
		this.ticketSoldLog = ticketSoldLog;
		try {
			dskt = new DatagramSocket(Integer.parseInt(UdpInfStr[0]));
		} catch (NumberFormatException | SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createFandom() {
		fans = new Fandom2[fansMax];
		for(int i = 0; i < fans.length; i++) fans[i] = new Fandom2(i + 1, dskt, UdpInfStr);
	}
	
	public void ticketing() {
		for(int i = 0; i < fans.length; i++) fans[i].start();
	}
	
	public void run() {
		while(true) {
			if(Server.totalTicket == 0) break;
			
			bufReceive = new byte[10];
			DatagramPacket dpkt = new DatagramPacket(bufReceive, bufReceive.length);
			try {
				dskt.receive(dpkt);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String clientId = new String(dpkt.getData()).trim();
			
			for(Fandom2 fan : fans) {
				if(fan.getName().contentEquals(clientId)) {
					fan.ticketCnt += 1;
					ticketSoldLog.append(clientId + ": 티켓을 구매했습니다. (보유 개수 : " + fan.ticketCnt + ")\n");
					fan.isReceived = true;
				}
			}
		}
	}
}
