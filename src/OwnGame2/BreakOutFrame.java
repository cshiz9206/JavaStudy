package OwnGame2;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class BreakOutFrame extends JFrame implements KeyListener {
	Bar user;
	Ball ball;
	
	static Container ct;
	ScoreBoard db;
//	TcpClient tcpConnect;
	
	final int floor = 3;
	final int wallCntByFloor = 12;
	final int wallCount = floor * wallCntByFloor;
	
	final static int playerScreenWidth = 700;
	final static int scoreScreenWidth = 300;
	
	public BreakOutFrame() {
		setSize(playerScreenWidth + scoreScreenWidth, 900);
		setTitle("Break out");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ct = getContentPane();
		ct.setLayout(null);
		ct.setFocusable(true);
		ct.addKeyListener(this);
		ct.setBackground(Color.black);

		setVisible(true);
		
		stageStart();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			user.moveLeft();
			if((ball.getY() >= ct.getHeight() - 150) && (ball.ySpeed > 0)) user.setMovLeftAmt();
			System.out.println(ball.ySpeed);
			user.resetMovRightAmt();
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			user.moveRight();
			if((ball.getY() >= ct.getHeight() - 150) && (ball.ySpeed > 0)) user.setMovRightAmt();
			user.resetMovLeftAmt();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	void stageStart() {
		String[] header = {"No", "User", "Score"};
		DefaultTableModel dtm = new DefaultTableModel(header, 0);
		JTable jtb = new JTable(dtm);
		jtb.setBackground(Color.black);
		jtb.setForeground(Color.white);
		jtb.setGridColor(Color.black);
		jtb.setFont(new Font("∏Ì¡∂", Font.PLAIN, 13));
		DefaultTableCellRenderer tmp = new DefaultTableCellRenderer();
		tmp.setHorizontalAlignment(JLabel.CENTER);
		for(String colName : header) jtb.getColumn(colName).setCellRenderer(tmp);
		jtb.setBounds(ct.getWidth() - scoreScreenWidth + 20, 50, 260, 500);
		dtm.addRow(header);
		JScrollPane jsp = new JScrollPane(jtb);
		ct.add(jtb);
		db = new ScoreBoard(jtb);
		
//		Wall[] walls = createWalls(0, ct.getWidth() - scoreScreenWidth - playerScreenWidth, ct.getHeight(), wallCount);
//		
//		user = new Bar(0, ct.getWidth() - scoreScreenWidth - playerScreenWidth, ct.getHeight());
//		ct.add(user);
//		
//		ball = new Ball(0, ct.getWidth() - scoreScreenWidth - playerScreenWidth, ct.getHeight(), user, walls, ct);
//		ct.add(ball);
		
		Wall[] walls = createWalls(0, ct.getWidth() - scoreScreenWidth, ct.getHeight(), wallCount);
		
		user = new Bar(0, ct.getWidth() - scoreScreenWidth, ct.getHeight());
		ct.add(user);
		
		ball = new Ball(0, ct.getWidth() - scoreScreenWidth, ct.getHeight(), user, walls, ct);
		ct.add(ball);
		
		JLabel info = new JLabel();
		info.setHorizontalAlignment(JLabel.CENTER);
		info.setSize(430, 100);
		info.setForeground(Color.GRAY);
		info.setFont(new Font("∏º¿∫∞ÌµÒ", Font.BOLD, 20));
		//info.setLocation((ct.getWidth() - scoreScreenWidth - playerScreenWidth) / 2 - (info.getWidth() / 2), ct.getHeight() - 150);
		info.setLocation((ct.getWidth() - scoreScreenWidth) / 2 - (info.getWidth() / 2), ct.getHeight() - 150);
		ct.add(info);
		
		db.dataUpdate();
		new Thread(ball).start();
		new TimeThread(info, db).start();
	}
	
	Wall[] createWalls(int startX, int ctWidth, int ctHeight, int wallCount) {
		Wall[] walls = new Wall[wallCount];
		int tmpWallCnt = 0;
		a : for(int i = 0; i < wallCntByFloor; i++) {
				for(int j = 0; j < floor; j++) {
					walls[tmpWallCnt] = new Wall(ctWidth, ctHeight);
					walls[tmpWallCnt].setLocation(((i * ctWidth / wallCntByFloor) + 
							(ctWidth / wallCntByFloor / 2) - (walls[tmpWallCnt].getWidth() / 2)), 
							50 + j * (walls[tmpWallCnt].getHeight() + 10));
					walls[tmpWallCnt].setLocation(walls[tmpWallCnt].getX() + startX, walls[tmpWallCnt].getY());
					for(WallColor wc : WallColor.values()) {
						if(wc.floorNum == (floor - j)) {
							walls[tmpWallCnt].setIcon(new ImageIcon(wc.path));
							walls[tmpWallCnt].color = wc;
						}
					}
					ct.add(walls[tmpWallCnt]);
					tmpWallCnt += 1;
					if(tmpWallCnt == wallCount) break a;
				}
		}
		return walls;
	}
	
//	public static void setObjects(int[] data) {
//		user.setLocation(userData.getX(), userData.getY());
////		ballData.setLocation(ballData.getX() + playerScreenWidth, ballData.getY());
////		infoData.setLocation(infoData.getX() + playerScreenWidth, infoData.getY());
//		ct.add(userData);
////		ct.add(ballData);
////		ct.add(infoData);
//		ct.repaint();
//	}
}
