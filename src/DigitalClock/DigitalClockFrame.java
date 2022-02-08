package DigitalClock;

import java.awt.Container;
import java.awt.FlowLayout;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class DigitalClockFrame extends JFrame {
	ClockThread clock;
	JLabel jl;
	
	public DigitalClockFrame() {
		// thread 생성
		clock = new ClockThread();
		
		setSize(250, 80);
		setTitle("디지털 시계");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container ct = getContentPane();
		ct.setLayout(new FlowLayout());
		
		jl = new JLabel("test");
		ct.add(jl);
		
		setVisible(true);
		
		// thread start
		clock.run();
	}
	
	private class ClockThread extends Thread {
		String format;
		
		public ClockThread() {
			format = "yyyy-MM-dd HH:mm:ss.SSS";
		}
		
		public void run() {
			while(true) {
				SimpleDateFormat sdf = new SimpleDateFormat(format);
				jl.setText(sdf.format(new Date()));
			}
		}
	}
}
