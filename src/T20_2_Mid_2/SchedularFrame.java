package T20_2_Mid_2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SchedularFrame extends JFrame implements ActionListener, MouseListener {
	Container ct;
	JTextField jtfYear, jtfMonth;
	int year, month;

	JLabel[] jlbDates;
	JTextField[] jtfMemoes;
	JLabel jlbAddMemo;
	JPanel jpnlMemo;
	JTextField jtfMemo;
	JTextField jtfAddMemo;
	int date;
	int monthFirstDay;
	
	public SchedularFrame() {
		setTitle("일정관리 프로그램");
		setSize(700, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ct = getContentPane();
		ct.setLayout(new GridLayout(1, 5));
		
		JLabel jlbYear = new JLabel("연도(YYYY)");
		jlbYear.setHorizontalAlignment(JLabel.CENTER);
		ct.add(jlbYear);
		jtfYear = new JTextField();
		jtfMonth = new JTextField();
		ct.add(jtfYear);
		JLabel jlbMonth = new JLabel("월(MM)");
		jlbMonth.setHorizontalAlignment(JLabel.CENTER);
		ct.add(jlbMonth);
		ct.add(jtfMonth);
		JButton btnSet = new JButton("설정");
		btnSet.addActionListener(this);
		ct.add(btnSet);
		
		setVisible(true);
	}
	
	public void schedular() {
		setSize(700, 700);
		
		ct.setLayout(new BorderLayout());
		
		JLabel jlbHead = new JLabel(year + "년 " + month + "월");
		jlbHead.setHorizontalAlignment(JLabel.CENTER);
		jlbHead.setFont(new Font("굴림", Font.BOLD, 30));
		ct.add(jlbHead, BorderLayout.NORTH);
		
		GregorianCalendar cal = new GregorianCalendar(year, month - 1, 1);
		int monthLastDate = cal.getActualMaximum(cal.DATE);
		monthFirstDay = cal.get(cal.DAY_OF_WEEK);
		String[] day = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
		
		JPanel jpnlCal = new JPanel(new GridLayout(8, 7, 10, 10));
		for(String tmp : day) {
			JLabel jlbDay = new JLabel(tmp);
			jlbDay.setFont(new Font("굴림", Font.BOLD, 15));
			jlbDay.setHorizontalAlignment(JLabel.CENTER);
			jpnlCal.add(jlbDay);
		}
		for(int i = 1; i < monthFirstDay; i++) jpnlCal.add(new JLabel(" "));
		jlbDates = new JLabel[monthLastDate];
		jtfMemoes = new JTextField[monthLastDate];
		for(int i = 1; i <= monthLastDate; i++) {
			JPanel jpnlB = new JPanel(new BorderLayout());
			JLabel jlbDate = new JLabel(String.valueOf(i));
			jlbDate.setFont(new Font("굴림", Font.BOLD, 20));
			jlbDate.setHorizontalAlignment(JLabel.CENTER);
			jlbDate.addMouseListener(this);
			jlbDate.setFocusable(true);
			jlbDates[i - 1] = jlbDate;
			jpnlB.add(jlbDate, BorderLayout.CENTER);
			jtfMemo = new JTextField();
			jtfMemo.setEnabled(false);
			jtfMemoes[i - 1] = jtfMemo;
			jpnlB.add(jtfMemo, BorderLayout.SOUTH);
			jpnlCal.add(jpnlB);
		}
		for(int i = monthLastDate + (monthFirstDay - 1) + 7; i < 56; i++) jpnlCal.add(new JLabel(" "));
		ct.add(jpnlCal, BorderLayout.CENTER);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().contentEquals("설정")) {
			ct.removeAll();
			year = Integer.parseInt(jtfYear.getText());
			month = Integer.parseInt(jtfMonth.getText());
			schedular();
		}
		
		if(e.getActionCommand().contentEquals("일정 저장")) {
			jtfMemoes[date - 1].setText(jtfAddMemo.getText());
			remove(jpnlMemo); //ct.remove와의 차이?
			setSize(700, 700);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		setSize(700, 850);
		
		jpnlMemo = new JPanel(new GridLayout(1, 3));
		jlbAddMemo = new JLabel();
		jlbAddMemo.setHorizontalAlignment(JLabel.CENTER);
		jtfAddMemo = new JTextField();
		JButton btnAddMemo = new JButton("일정 저장");
		btnAddMemo.addActionListener(this);
		jpnlMemo.add(jlbAddMemo);
		jpnlMemo.add(jtfAddMemo);
		jpnlMemo.add(btnAddMemo);
		ct.add(jpnlMemo, BorderLayout.SOUTH);
		
		for(JLabel tmp : jlbDates) {
			if(arg0.getSource() == tmp) {
				date = Integer.parseInt(tmp.getText());
				jlbAddMemo.setText(date + "일 일정 : ");
			}
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
