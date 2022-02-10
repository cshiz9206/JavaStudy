package TCPBreakOutServer;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ServerFrame extends JFrame implements ActionListener {
	JTextField jtfServPort;
	
	JButton jbGeneration;
	
	TcpServer ts;
	
	public ServerFrame() {
		setTitle("TCP 채팅 서버측");
		setSize(300, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container ct = getContentPane();
		
		JPanel jpNorth = new JPanel(new GridLayout(2, 2));
		JPanel jptmp = new JPanel();
		JLabel jlServPort = new JLabel("Server Port");
		jptmp.add(jlServPort);
		jbGeneration = new JButton("생성");
		jbGeneration.addActionListener(this);
		jtfServPort = new JTextField(5);
		jpNorth.add(jptmp);
		jpNorth.add(new JLabel());
		jpNorth.add(jtfServPort);
		jpNorth.add(jbGeneration);
		ct.add(jpNorth);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().contentEquals(jbGeneration.getText())) {
			// 서버 객체 생성 / 연결 기다림(
			ts = new TcpServer(Integer.parseInt(jtfServPort.getText()));
			ts.start();
		}
	}
}
