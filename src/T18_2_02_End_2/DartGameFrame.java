package T18_2_02_End_2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DartGameFrame extends JFrame implements ActionListener{
	JPanel jpnl;
	JButton btn;
	
	public DartGameFrame() {
		setTitle("다트 게임");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container ct = getContentPane();
		ct.setLayout(new BorderLayout());
		
		jpnl = new JPanel(null);
		
		JButton btn = new JButton("던지기");
		btn.addActionListener(this);
		
		ct.add(jpnl, BorderLayout.CENTER);
		ct.add(btn, BorderLayout.SOUTH);
		
		setVisible(true);
		
		new Thread(new PigThread(jpnl, btn)).start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new Thread(new DartThread(jpnl)).start();
	}
}
