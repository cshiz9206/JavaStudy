package T20_2_End_4;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BioRhythmServerFrame extends JFrame implements ActionListener {
	JTextField jtfPort;
	
	public BioRhythmServerFrame() {
		setTitle("TCP Biorhythm 서버");
		setSize(350, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container ct = getContentPane();
		ct.setLayout(new GridLayout(2, 2));
		
		JLabel jlbPort = new JLabel("Server Port");
		jlbPort.setHorizontalAlignment(JLabel.CENTER);
		jtfPort = new JTextField();
		JButton btnSet = new JButton("설정");
		btnSet.addActionListener(this);
		
		ct.add(jlbPort);
		ct.add(new JLabel());
		ct.add(jtfPort);
		ct.add(btnSet);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new Server(Integer.parseInt(jtfPort.getText())).start();
	}
}
