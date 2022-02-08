package RainAvoid;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RainAvoidFrame extends JFrame implements ActionListener, KeyListener {
	JLabel jlbCh;
	JLabel jlbTime;
	JPanel jpnl;
	Container ct;
	ImageIcon rc, lc;
	JButton jbtn;
	
	LocalTime startTime;
	
	public RainAvoidFrame() {
		setTitle("ºñ ÇÇÇÏ±â ÇÁ·Î±×·¥");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 750);
		
		ct = getContentPane();
		ct.setLayout(new BorderLayout());
		ct.addKeyListener(this);
		ct.setBackground(Color.WHITE);
		
		jpnl = new JPanel();
		jpnl.setBackground(Color.WHITE);
		jpnl.setLayout(null);
		
		startTime = LocalTime.now();
		DateTimeFormatter startTimeFormatter = DateTimeFormatter.ofPattern("00:00:00");
		jlbTime = new JLabel(startTime.format(startTimeFormatter));
		jlbTime.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 50));
		jlbTime.setHorizontalAlignment(JLabel.CENTER);
		ct.add(jlbTime, BorderLayout.NORTH);
		
		jbtn = new JButton("°ÔÀÓ ½ÃÀÛ!");
		jbtn.addActionListener(this);
		ct.add(jbtn, BorderLayout.SOUTH);
		
		jlbCh = new JLabel();
		rc = new ImageIcon("C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_Á¤½ÂÇö\\JAVA_edu_Á¤½ÂÇö\\src\\RainAvoid\\rightCh.png");
		lc = new ImageIcon("C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_Á¤½ÂÇö\\JAVA_edu_Á¤½ÂÇö\\src\\RainAvoid\\leftCh.png");
		jlbCh.setIcon(rc);
		jlbCh.setSize(rc.getIconWidth(), rc.getIconHeight());
		jlbCh.setLocation(250, 550);
		jpnl.add(jlbCh);
		
		ct.add(jpnl, BorderLayout.CENTER);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		jbtn.setEnabled(false);
		new MakeRainThread(jpnl, jlbCh, jlbTime).start();
		new TimeThread(jlbTime, startTime).start();
		ct.setFocusable(true);
		ct.requestFocus();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyCode() == KeyEvent.VK_LEFT) {
			jlbCh.setIcon(lc);
			jlbCh.setSize(lc.getIconWidth(), lc.getIconHeight());
			jlbCh.setLocation(jlbCh.getX() - 10, jlbCh.getY());
		}
		if(arg0.getKeyCode() == 39) {
			jlbCh.setIcon(rc);
			jlbCh.setSize(rc.getIconWidth(), rc.getIconHeight());
			jlbCh.setLocation(jlbCh.getX() + 10, jlbCh.getY());
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}
