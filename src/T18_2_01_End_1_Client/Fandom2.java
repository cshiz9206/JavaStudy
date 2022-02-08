package T18_2_01_End_1_Client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JTextArea;

import T18_2_01_End_1_Server.Server;

public class Fandom2 extends Thread {
	static DatagramSocket dskt;
	String[] UdpInfStr;
	byte[] bufSend;
	int ticketCnt = 0;
	boolean isReceived = true;
	
	public Fandom2(int id, DatagramSocket dskt, String[] UdpInfStr) {
		this.UdpInfStr = UdpInfStr;
		this.dskt = dskt;
		this.setName(String.valueOf(id));
	}
	
	public void run() {
		while(true) {
			if(Server.totalTicket == 0) break;
			if(isReceived) {// 계속 send 하면 ticketCnt가 최신으로 업데이트하기 전에 또 send하는 문제 발생
				if(ticketCnt > 2) break;
				sendMsg(this.getName());
				isReceived = false;
			}
		}
	}
	
	public void sendMsg(String context) {
		bufSend = context.getBytes();
		try {
			DatagramPacket dpkt = new DatagramPacket(bufSend, bufSend.length, InetAddress.getByName(UdpInfStr[1]), Integer.parseInt(UdpInfStr[2]));
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
