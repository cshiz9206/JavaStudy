package OwnGame2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class BreakOutClientFrame extends BreakOutFrame {
	static ClientBar user;
	ClientBall ball;
	
	public BreakOutClientFrame(TcpClient tcpConnect) {
		this.tcpConnect = tcpConnect;
		
		Wall[] walls = createWalls(playerScreenWidth, ct.getWidth() - scoreScreenWidth - playerScreenWidth, ct.getHeight(), wallCount);
		
		user = new ClientBar(playerScreenWidth, ct.getWidth() - scoreScreenWidth - playerScreenWidth, ct.getHeight());
		ct.add(user);
		
		ball = new ClientBall(playerScreenWidth, ct.getWidth() - scoreScreenWidth - playerScreenWidth, ct.getHeight(), user, walls, ct);
		ct.add(ball);
		
		JLabel info = new JLabel();
		info.setHorizontalAlignment(JLabel.CENTER);
		info.setSize(430, 100);
		info.setForeground(Color.GRAY);
		info.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 20));
		info.setLocation((ct.getWidth() - scoreScreenWidth) / 4 * 3 - (info.getWidth() / 2), ct.getHeight() - 150);
		ct.add(info);
		
		db.dataUpdate();
		new TcpSendThread(super.user, super.ball, info, tcpConnect).start();
		new Thread(ball).start();
		new TimeThread(info, db).start();
	}
	
	public static void setObjects(Bar data) {
		System.out.println(data.getX() + " " + data.getY());
		user.setLocation(data.getX(), data.getY());
		ct.add(user);
		ct.repaint();
	}
}
