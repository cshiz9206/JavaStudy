package T18_2_01_End_1_Client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JTextArea;

public class Fandom extends Thread {
	static Fandom[] fans = new Fandom[50];
	static DatagramSocket dskt;
	String[] UdpInfStr;
	JTextArea ticketSoldLog;
	byte[] bufReceive, bufSend;
	int ticketCnt = 0;
	static int fanId = 0;
	
	public Fandom(String[] UdpInfStr, JTextArea ticketSoldLog) {
		this.UdpInfStr = UdpInfStr;
		this.ticketSoldLog = ticketSoldLog;
		try {
			if(fanId == 0) dskt = new DatagramSocket(Integer.parseInt(UdpInfStr[0]));
		} catch (NumberFormatException | SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		fanId += 1;
		this.setName(String.valueOf(fanId));
	}
	
	public void run() {
		sendMsg(this.getName());
		while(true) {
			bufReceive = new byte[10];
			DatagramPacket dpkt = new DatagramPacket(bufReceive, bufReceive.length);
			try {
				dskt.receive(dpkt);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// ���� �� log ������ Ŭ���̾�Ʈ �� log ������ ���� ���� 
			// -> 100���� Ŭ���̾�Ʈ �� ��� Ŭ���̾�Ʈ�� ���� ������ ������ �޽����� ������ �𸣱� ������ �߻�
			// -> Ŭ���̾�Ʈ ������ ���� Ŭ���̾�Ʈ name���� �ش� �̸��� ���� Ŭ���̾�Ʈ ��ü�� ã�Ƽ� �ش� ��ü�� ���� Ƽ�� ���� �÷��ְ� log�� ���
			// Ŭ���̾�Ʈ Ŭ�������� ���� �ϳ� ���� -> �Ҵ� Ŭ�������� ��Ŷ �����Ͽ� ����?
			// �����ϴ� ��ü�� Ŭ���̾�Ʈ Ŭ���� �ϳ�
			String clientId = new String(dpkt.getData()).trim();
			
			for(Fandom fan : fans) {
				if(fan.getName().contentEquals(clientId)) {
					fan.ticketCnt += 1;
					ticketSoldLog.append(clientId + ": Ƽ���� �����߽��ϴ�. (���� ���� : " + fan.ticketCnt + ")\n");
					if(fan.ticketCnt < 2) {
						fan.sendMsg(fan.getName());
					}
				}
			}
			
			if(ticketCnt == 2) break;
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
