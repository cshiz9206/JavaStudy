package PourWater;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PourWaterFrame extends JFrame implements ActionListener {
	WaterTankEx tank;
	final int MAXW = 10000;
	final int DRAINW = 100;
	int cnt = 0;
	JTextArea jtaLossLog;
	JTextArea jtaAddLog;
	JTextField jtfWater;
	JLabel jlWaterTitle;
	JProgressBar prgbar;
	JButton jdAddHole;
	
	public PourWaterFrame() {
		
		setTitle("밑 빠진 독에 물 붓기 - swing");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container ct = getContentPane();
		ct.setLayout(new BorderLayout(10, 10));
		
		// 물빠짐 로그영역
		JPanel jpLossLog = new JPanel(new BorderLayout(5, 5));
		
		JPanel jpLossTitle = new JPanel();
		JLabel jlLossTitle = new JLabel("물 빠짐");
		jpLossTitle.add(jlLossTitle);
		jpLossLog.add(jpLossTitle, BorderLayout.NORTH);
		
		jtaLossLog = new JTextArea();
		jpLossLog.add(new JScrollPane(jtaLossLog), BorderLayout.CENTER);
		
		jdAddHole = new JButton("구멍 추가 (현재 0개)");
		jdAddHole.addActionListener(this);
		jpLossLog.add(jdAddHole, BorderLayout.SOUTH);
		
		// 바 영역
		JPanel jpWaterState = new JPanel(new BorderLayout(5, 5));
		
		JPanel jpWaterTitle = new JPanel();
		jlWaterTitle = new JLabel(String.valueOf(MAXW));
		jpWaterTitle.add(jlWaterTitle);
		jpWaterState.add(jpWaterTitle, BorderLayout.NORTH);
		
		prgbar = new JProgressBar(JProgressBar.VERTICAL);
		prgbar.setMaximum(MAXW);
		prgbar.setMinimum(0);
		prgbar.setValue(MAXW);
		jpWaterState.add(prgbar, BorderLayout.CENTER);
		
		jtfWater = new JTextField();
		jpWaterState.add(jtfWater, BorderLayout.SOUTH);
		
		// 물부음 로그영역
		JPanel jpAddLog = new JPanel(new BorderLayout(5, 5));
		
		JPanel jpAddTitle = new JPanel();
		JLabel jlAddTitle = new JLabel("물 부음");
		jpAddTitle.add(jlAddTitle);
		jpAddLog.add(jpAddTitle, BorderLayout.NORTH);
		
		jtaAddLog = new JTextArea();
		jpAddLog.add(new JScrollPane(jtaAddLog), BorderLayout.CENTER);
		
		JButton jbPour = new JButton("물 붓기");
		jbPour.addActionListener(this);
		jpAddLog.add(jbPour, BorderLayout.SOUTH);
		
		ct.add(jpLossLog, BorderLayout.WEST);
		ct.add(jpWaterState, BorderLayout.CENTER);
		ct.add(jpAddLog, BorderLayout.EAST);
		
		// tank 생성
		tank = new WaterTankEx(MAXW, jtaLossLog, prgbar, jlWaterTitle);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		if(arg0.getActionCommand().equals("물 붓기")) {
			int pourAmount = Integer.parseInt(jtfWater.getText());
			if(tank.isOver(pourAmount)) tank.pour(tank.getWaterMax()); // 최대 용량보다 더 부으면 최대 용량 만큼만 보충됨
			else tank.pour(pourAmount);
			
			jtaAddLog.setText(jtaAddLog.getText() + "물 부음 : " + pourAmount + "ml\n");
			
			prgbar.setValue(tank.getWater());
			
			jlWaterTitle.setText(String.valueOf(tank.getWater()));
		}
		else {
			cnt += 1;
			WaterHoleThread whte = new WaterHoleThreadEx(cnt, tank, DRAINW);
			jdAddHole.setText("구멍 추가 (현재 " + cnt + "개)");
			whte.start();
		}
	}
}
