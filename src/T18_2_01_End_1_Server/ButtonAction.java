package T18_2_01_End_1_Server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ButtonAction implements ActionListener {
	JTextField[] UdpInf;
	String[] UdpInfStr;
	JTextArea ticketSoldLog;
	
	public ButtonAction(JTextField[] UdpInf, JTextArea ticketSoldLog) {
		this.UdpInf = UdpInf;
		this.ticketSoldLog = ticketSoldLog;
		
		UdpInfStr = new String[3];
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().contentEquals("¼³Á¤")) {
			for(int i = 0; i < UdpInf.length; i++) UdpInfStr[i] = UdpInf[i].getText();
			new Server(UdpInfStr, ticketSoldLog).start();
		}
	}
}
