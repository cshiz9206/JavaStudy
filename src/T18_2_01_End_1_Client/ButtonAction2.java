package T18_2_01_End_1_Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ButtonAction2 implements ActionListener {
	JTextField[] UdpInf;
	String[] UdpInfStr;
	JTextArea ticketSoldLog;
	Client client;
	
	public ButtonAction2(JTextField[] UdpInf, JTextArea ticketSoldLog) {
		this.UdpInf = UdpInf;
		this.ticketSoldLog = ticketSoldLog;
		UdpInfStr = new String[3];
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().contentEquals("설정")) {
			for(int i = 0; i < UdpInf.length; i++) UdpInfStr[i] = UdpInf[i].getText();
			client = new Client(UdpInfStr, ticketSoldLog);
			client.createFandom();
		}
		if(e.getActionCommand().contentEquals("구매 시작")) {
			client.start();
			client.ticketing();
		}
	}
}
