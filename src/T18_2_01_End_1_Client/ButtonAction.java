package T18_2_01_End_1_Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ButtonAction implements ActionListener {
	JTextField[] UdpInf;
	String[] UdpInfStr;
	JTextArea ticketSoldLog;
	Fandom[] fans;
	
	public ButtonAction(JTextField[] UdpInf, JTextArea ticketSoldLog) {
		this.UdpInf = UdpInf;
		this.ticketSoldLog = ticketSoldLog;
		fans = new Fandom[50];
		UdpInfStr = new String[3];
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().contentEquals("설정")) {
			for(int i = 0; i < UdpInf.length; i++) UdpInfStr[i] = UdpInf[i].getText();
			for(int i = 0; i < fans.length; i++) fans[i] = new Fandom(UdpInfStr, ticketSoldLog);
			Fandom.fans = fans;
		}
		if(e.getActionCommand().contentEquals("구매 시작")) {
			for(Fandom fan : fans) fan.start();
		}
	}
}
