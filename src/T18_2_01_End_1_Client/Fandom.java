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
			
			// 서버 측 log 순서와 클라이언트 측 log 순서가 맞지 않음 
			// -> 100개의 클라이언트 중 어느 클라이언트가 서버 측에서 전송한 메시지를 받을지 모르기 때문에 발생
			// -> 클라이언트 측에서 받은 클라이언트 name으로 해당 이름과 같은 클라이언트 객체를 찾아서 해당 객체의 구매 티켓 수를 늘려주고 log에 기록
			// 클라이언트 클래스에서 소켓 하나 생성 -> 팬덤 클래스에서 패킷 생성하여 전송?
			// 수신하는 객체는 클라이언트 클래스 하나
			String clientId = new String(dpkt.getData()).trim();
			
			for(Fandom fan : fans) {
				if(fan.getName().contentEquals(clientId)) {
					fan.ticketCnt += 1;
					ticketSoldLog.append(clientId + ": 티켓을 구매했습니다. (보유 개수 : " + fan.ticketCnt + ")\n");
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
