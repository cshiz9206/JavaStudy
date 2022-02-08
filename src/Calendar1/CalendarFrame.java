package Calendar1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.*;

public class CalendarFrame extends JFrame implements ActionListener {
	JButton btnLastM;
	JButton btnNextM;
	int month;
	int year;
	JLabel todayYm;
	JPanel jpCalendar;
	Container jct;
	int monthFirstDay, monthLastDate;
	GregorianCalendar cal;
	
	public CalendarFrame(String title, int w, int h) {
		setTitle(title);
		setSize(w, h);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jct = getContentPane();
		jct.setLayout(new BorderLayout(0, 30)); // ����, �ణ ����
		
		JPanel jpHeader = new JPanel(new BorderLayout());
		btnLastM = new JButton("��");
		btnLastM.addActionListener(this);
		jpHeader.add(btnLastM, BorderLayout.WEST);
		btnNextM = new JButton("��");
		btnNextM.addActionListener(this);
		jpHeader.add(btnNextM, BorderLayout.EAST);
		
		year = Calendar.getInstance().get(Calendar.YEAR);
		month = Calendar.getInstance().get(Calendar.MONTH) + 1;
		todayYm = new JLabel(year + "�� " + month + "��");
		todayYm.setHorizontalAlignment(JLabel.CENTER);
		jpHeader.add(todayYm, BorderLayout.CENTER);
		
		jpCalendar = new JPanel(new GridLayout(7, 7));
		
		cal = new GregorianCalendar(year, month - 1, 1);
		monthLastDate = cal.getActualMaximum(cal.DATE); // ���� ������ ��¥(30 or 31 or 28)
		monthFirstDay = cal.get(cal.DAY_OF_WEEK); // �����ϴ� ��¥�� ����(1~7)

		// ���� ���
		String[] whatDay = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		for(int i = 0; i < 7; i++) {
			JLabel tmp = new JLabel(whatDay[i]);
			tmp.setHorizontalAlignment(JLabel.CENTER);
			jpCalendar.add(tmp);
		}
		// �� ���
		for(int j = 1; j < monthFirstDay; j++) {
			jpCalendar.add(new JLabel(""));
		}
		for(int i = 1; i <= monthLastDate; i++) {
			JLabel tmp = new JLabel(String.valueOf(i));
			tmp.setHorizontalAlignment(JLabel.CENTER);
			jpCalendar.add(tmp);
		}
		for(int j = monthLastDate + (monthFirstDay - 1) + 7; j < 49; j++) { // ������ ���� ���
			jpCalendar.add(new JLabel(""));
		}
		
		jct.add(jpHeader, BorderLayout.NORTH);
		jct.add(jpCalendar);
		
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand() == "��") {
			month = (month + 1);
			if(month > 12) {
				year += 1;
				month = 1;
			}
		}
		else if(e.getActionCommand() == "��") {
			month -= 1;
			if(month < 1) {
				year -= 1;
				month = 12;
			}
		}
		
		jpCalendar = new JPanel(new GridLayout(7, 7));
		
		cal = new GregorianCalendar(year, month - 1, 1);
		monthLastDate = cal.getActualMaximum(cal.DATE); // ���� ������ ��¥(30 or 31 or 28)
		monthFirstDay = cal.get(cal.DAY_OF_WEEK); // �����ϴ� ��¥�� ����(1~7)

		// ���� ���
		String[] whatDay = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		for(int i = 0; i < 7; i++) {
			JLabel tmp = new JLabel(whatDay[i]);
			tmp.setHorizontalAlignment(JLabel.CENTER);
			jpCalendar.add(tmp);
		}
		// �� ���
		for(int j = 1; j < monthFirstDay; j++) {
			jpCalendar.add(new JLabel(""));
		}
		for(int i = 1; i <= monthLastDate; i++) {
			JLabel tmp = new JLabel(String.valueOf(i));
			tmp.setHorizontalAlignment(JLabel.CENTER);
			jpCalendar.add(tmp);
		}
		for(int j = monthLastDate + (monthFirstDay - 1) + 7; j < 49; j++) { // ������ ���� ���
			jpCalendar.add(new JLabel(""));
		}
		
		todayYm.setText(year + "�� " + month + "��");
		jct.add(jpCalendar);
	}
}
