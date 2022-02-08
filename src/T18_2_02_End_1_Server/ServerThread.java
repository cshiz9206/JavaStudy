package T18_2_02_End_1_Server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ServerThread extends Thread{
	DatagramSocket socket;
	public static int ticket = 100;
	JTextField jtfCIP, jtfCPort;
	JTextArea jta;
	
	public ServerThread(JTextArea jta, JTextField jtfSPort, JTextField jtfCIP, JTextField jtfCPort) {
		try {
			socket = new DatagramSocket(Integer.parseInt(jtfSPort.getText()));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.jtfCIP = jtfCIP;
		this.jtfCPort = jtfCPort;
		this.jta = jta;
	}
	
	public synchronized void buyTicket(String msg) {
		ticket -= 1;
		
		try {
			sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		jta.append(msg + ": 티켓을 구매했습니다. (남은 개수 : " + ticket + ")\n");
	}
	
	public void run() {
		while(true) {
			byte[] bufReceive = new byte[10];
			DatagramPacket packet = new DatagramPacket(bufReceive, bufReceive.length);
			try {
				socket.receive(packet);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String msg = new String(packet.getData()).trim();
			buyTicket(msg);
			
			if(ticket == 0) {
				jta.append("티켓이 완판되었습니다!");
				break;
			}
			
			sendMsg(msg);
		}
	}
	
	public void sendMsg(String context) {
		byte[] bufSend = context.getBytes();
		try {
			DatagramPacket packet = new DatagramPacket(bufSend, bufSend.length, InetAddress.getByName(jtfCIP.getText()), Integer.parseInt(jtfCPort.getText()));
			socket.send(packet);
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
