package T18_2_02_End_1_Client;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientFrame extends JFrame implements ActionListener {
	JTextField jtfCPort, jtfSIP, jtfSPort;
	JTextArea jta;
	Fandom[] fans = new Fandom[50];
	
	public ClientFrame() {
		setTitle("김범수 콘서트 예약 프로그램");
		setSize(400, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container ct = getContentPane();
		ct.setLayout(new BorderLayout());
		
		JPanel jpnlG = new JPanel(new GridLayout(2, 4));
		jpnlG.add(new JLabel("Client Port"));
		jpnlG.add(new JLabel("Server IP"));
		jpnlG.add(new JLabel("Server Port"));
		jpnlG.add(new JLabel(""));
		jtfCPort = new JTextField();
		jtfSIP = new JTextField();
		jtfSPort = new JTextField();
		jpnlG.add(jtfCPort);
		jpnlG.add(jtfSIP);
		jpnlG.add(jtfSPort);
		JButton btn = new JButton("설정");
		btn.addActionListener(this);
		jpnlG.add(btn);
		ct.add(jpnlG, BorderLayout.NORTH);
		
		jta = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta);
		ct.add(jsp, BorderLayout.CENTER);
		
		JButton btn2 = new JButton("구매 시작");
		btn2.addActionListener(this);
		ct.add(btn2, BorderLayout.SOUTH);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().contentEquals("설정")) {
			for(int i = 0; i < fans.length; i++) {
				fans[i] = new Fandom(jta, jtfCPort, jtfSIP, jtfSPort);
			}
			Fandom.fans = fans;
		}
		if(e.getActionCommand().contentEquals("구매 시작")) {
			for(int i = 0; i < fans.length; i++) {
				fans[i].start();
			}
		}
	}
}
