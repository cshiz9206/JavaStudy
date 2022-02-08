package BioRhythm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class BioRhythmFrame extends JFrame implements ActionListener {
	JProgressBar[] prgbar;
	JLabel[] lbls;
	
	JTextField jtfY, jtfM, jtfD;
	
	public BioRhythmFrame() {
		setSize(500, 300);
		setTitle("Today_Biorhythm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container ct = getContentPane();
		ct.setLayout(new BorderLayout());
		
		JPanel pnlTop = new JPanel(new GridLayout(1, 4));
		prgbar = new JProgressBar[4];
		for(int i = 0; i < 4; i++) {
			prgbar[i] = new JProgressBar(JProgressBar.VERTICAL);
			prgbar[i].setMaximum(100);
			prgbar[i].setMinimum(-100);
			pnlTop.add(prgbar[i]);
		}
		
		lbls = new JLabel[4];
		lbls[0] = new JLabel("신체지수");
		lbls[1] = new JLabel("감성지수");
		lbls[2] = new JLabel("지성지수");
		lbls[3] = new JLabel("지각지수");
		for(int i = 0; i < 4; i++) {
			lbls[i].setHorizontalAlignment(JLabel.CENTER);
		}
		
		for(int i = 0; i < 4; i++) {
			JPanel figBar = new JPanel(new BorderLayout());
			figBar.add(prgbar[i], BorderLayout.CENTER);
			figBar.add(lbls[i], BorderLayout.SOUTH);
			pnlTop.add(figBar);
		}
		
		ct.add(pnlTop, BorderLayout.CENTER);
		
		/////////////////////////////////
		
		JPanel pnlBot = new JPanel(new BorderLayout());
		JPanel pnlIn = new JPanel(new GridLayout(2, 3));
		JLabel tmp = new JLabel("연도");
		tmp.setHorizontalAlignment(JLabel.CENTER);
		pnlIn.add(tmp);
		tmp = new JLabel("월");
		tmp.setHorizontalAlignment(JLabel.CENTER);
		pnlIn.add(tmp);
		tmp = new JLabel("일");
		tmp.setHorizontalAlignment(JLabel.CENTER);
		pnlIn.add(tmp);
		
		jtfY = new JTextField();
		jtfM = new JTextField();
		jtfD = new JTextField();
		pnlIn.add(jtfY);
		pnlIn.add(jtfM);
		pnlIn.add(jtfD);
		
		JLabel input = new JLabel("생년월일 입력");
		input.setBackground(Color.GRAY);
		input.setOpaque(true);
		input.setHorizontalAlignment(JLabel.CENTER);
		pnlBot.add(input, BorderLayout.NORTH);
		pnlBot.add(pnlIn, BorderLayout.CENTER);
		JButton btn = new JButton("계 산");
		btn.addActionListener(this);
		pnlBot.add(btn, BorderLayout.SOUTH);
		ct.add(pnlBot, BorderLayout.SOUTH);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int off;
		try {
			String date1 = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
			String date2 = Integer.parseInt(jtfY.getText()) + "/" + Integer.parseInt(jtfM.getText()) + "/" + Integer.parseInt(jtfD.getText());
			System.out.println(date1 + " " + date2);
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			
			Date format1 = format.parse(date1);
			Date format2 = format.parse(date2);
			
			off = (int) ((format1.getTime() - format2.getTime()) / (24 * 60 * 60 * 1000));
			
			lbls[0].setText("신체지수 : " + (Math.sin(2 * Math.PI * off / 23) * 100));
			lbls[1].setText("감성지수 : " + (Math.sin(2 * Math.PI * off / 28) * 100));
			lbls[2].setText("지성지수 : " + (Math.sin(2 * Math.PI * off / 33) * 100));
			lbls[3].setText("지각지수 : " + (Math.sin(2 * Math.PI * off / 38) * 100));
			prgbar[0].setValue((int) (Math.sin(2 * Math.PI * off / 23) * 100));
			prgbar[1].setValue((int) (Math.sin(2 * Math.PI * off / 28) * 100));
			prgbar[2].setValue((int) (Math.sin(2 * Math.PI * off / 33) * 100));
			prgbar[3].setValue((int) (Math.sin(2 * Math.PI * off / 38) * 100));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for(int i = 0; i < 4; i++) {
			if(prgbar[i].getValue() < 0) prgbar[i].setForeground(Color.RED);
			else prgbar[i].setForeground(Color.GREEN);
		}
	}
}
