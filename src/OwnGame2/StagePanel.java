package OwnGame2;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class StagePanel extends JPanel {
	Bar user;
	Ball ball;
	JPanel mainPnl;
	
	Container ct;
	ScoreBoard db;
//	TcpClient tcpConnect;
	
	final int floor = 3;
	final int wallCntByFloor = 12;
	final int wallCount = floor * wallCntByFloor;
	
	final static int playerScreenWidth = 700;
	final static int scoreScreenWidth = 300;
	
	JTable jtb;
	ScoreBoard db;
	
	public StagePanel() {
		setSize(1000, 900);
		
		String[] header = {"No", "User", "Score"};
		DefaultTableModel dtm = new DefaultTableModel(header, 0);
		jtb = new JTable(dtm);
		jtb.setBackground(Color.black);
		jtb.setForeground(Color.white);
		jtb.setGridColor(Color.black);
		jtb.setFont(new Font("∏Ì¡∂", Font.PLAIN, 13));
		DefaultTableCellRenderer tmp = new DefaultTableCellRenderer();
		tmp.setHorizontalAlignment(JLabel.CENTER);
		for(String colName : header) jtb.getColumn(colName).setCellRenderer(tmp);
		jtb.setBounds(1000 - 300 + 20, 50, 260, 500);
		dtm.addRow(header);
		JScrollPane jsp = new JScrollPane(jtb);
		add(jtb);
		db = new ScoreBoard();
		
		Wall[] walls = createWalls(0, 1000 - 300, 900, wallCount);
		
		Bar user = new Bar(0, 1000 - 300, 900);
		add(user);
		
		Ball ball = new Ball(0, 700, 900, user, walls, ct);
		add(ball);
		
		JLabel info = new JLabel();
		info.setHorizontalAlignment(JLabel.CENTER);
		info.setSize(430, 100);
		info.setForeground(Color.GRAY);
		info.setFont(new Font("∏º¿∫∞ÌµÒ", Font.BOLD, 20));
		//info.setLocation((ct.getWidth() - scoreScreenWidth - playerScreenWidth) / 2 - (info.getWidth() / 2), ct.getHeight() - 150);
		info.setLocation((1000 - 300) / 2 - (info.getWidth() / 2), 900 - 150);
		add(info);
		
		db.dataUpdate();
		new Thread(ball).start();
		new TimeThread(info, db).start();
	}
	
	
	
	
}
