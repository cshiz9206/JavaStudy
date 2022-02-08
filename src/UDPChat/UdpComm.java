package UDPChat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UdpComm extends Thread {
	String addrOpIP;
	int opPort, myPort;
	byte[] bufSend, bufReceive;
	DatagramSocket dskt;
	DatagramPacket dpkt;
	JTextArea jtaChat;
	
	public UdpComm(JTextArea jtaChat, String jtfYourIP, String jtfYourP, String jtfMyP) {
		addrOpIP = jtfYourIP;
		opPort = Integer.parseInt(jtfYourP);
		myPort = Integer.parseInt(jtfMyP);
		this.jtaChat = jtaChat;
		
		try {
			dskt = new DatagramSocket(myPort);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendMsg(String content) {
		bufSend = content.getBytes();
		InetAddress ia;
		try {
			ia = InetAddress.getByName(addrOpIP);
			dpkt = new DatagramPacket(bufSend, bufSend.length, ia, opPort);
			dskt.send(dpkt);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run() {
		
		while(true) {
			bufReceive = new byte[30];
			DatagramPacket dpktReceive = new DatagramPacket(bufReceive, bufReceive.length);
			try {
				dskt.receive(dpktReceive);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//jtaChat.append("���� : " + dpktReceive.getData().toString() + "\n");
			jtaChat.append("���� : " + new String(dpktReceive.getData()) + "\n");
		}
	}
}
//append�� while�� �ȿ� ���� �ϴ� ����
// new String vs toString
// �ٸ� IP���� �غ���