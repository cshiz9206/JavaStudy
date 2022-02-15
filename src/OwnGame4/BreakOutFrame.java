package OwnGame4;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class BreakOutFrame extends JFrame implements KeyListener, ActionListener, MouseListener {
	JPanel mainPnl;
	JPanel endPnl;
	JPanel startPnl;
	JTable jtb;
	JLabel titleLbl, endLbl, timerLbl, scoreLbl;
	JButton saveBtn, restartBtn;
	JLabel startBtn;
	JTextField nameJtf;
	
	Container ct;
	ScoreBoard db;
	ChangePnlThread st;
	
	Wall[] walls;
	Bar bar;
	Bar bar2;
	Ball ball;
	JLabel info;
	
	Thread ballMove;
	TimeThread timer;
	LoadThread loadLbl;
	Thread load;
	
	TcpClient tcpConnection;
	
	final int floor = 4;
	final int wallCntByFloor = 11;
	final int wallCount = floor * wallCntByFloor;
	
	final int frameWidth = 700;
	final int frameHeight = 900;
	
	static boolean isStart = false;
	static boolean isRestart = false;
	
	public BreakOutFrame() {
		// initialize Window
		initFrame();
		initContainer();
		
		// create DataBase
		db = new ScoreBoard();
	}
	
	void initContainer() {
		ct = getContentPane();
		ct.setLayout(null);
		ct.setFocusable(true);
		ct.addKeyListener(this);
		ct.setSize(700, 900);
		ct.setBackground(Color.black);
	}
	
	void initFrame() {
		setTitle("Break out");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(frameWidth, frameHeight);
		setVisible(true);
	}
	
	void createStartPnl() {
		startPnl = new JPanel(null);
		startPnl.setBackground(Color.black);
		startPnl.setBounds(0, 0, frameWidth, frameHeight);
		
		createTitleLabel();
		startPnl.add(titleLbl);
		
		createStartBtn();
		startPnl.add(startBtn);
	}
	
	void createMainPnl() {
		mainPnl = new JPanel(null);
		mainPnl.setBackground(Color.black);
		mainPnl.setBounds(0, 0, frameWidth, frameHeight);

		walls = createWalls(0, frameWidth, frameHeight);
		for(Wall wall : walls) mainPnl.add(wall);

		bar = new Bar(0, frameWidth - 20, frameHeight);
		mainPnl.add(bar);
		
		bar2 = new Bar(0, frameWidth - 20, frameHeight);
		mainPnl.add(bar2);

		ball = new Ball(0, frameWidth - 20, frameHeight, bar, bar2,  walls, mainPnl);
		Ball.isDead = false;
		mainPnl.add(ball);
		
		timerLbl = createTimeLabel();
		mainPnl.add(timerLbl);
		
		scoreLbl = createScoreLabel();
		mainPnl.add(scoreLbl);
//		info = createInfoLabel();
//		mainPnl.add(info);
	}
	
	void createEndPnl() {
		endPnl = new JPanel(null);
		endPnl.setBackground(Color.black);
		endPnl.setBounds(0, 0, frameWidth, frameHeight);
		
		createEndLabel();
		endPnl.add(endLbl);
		
		createNameTextField();
		endPnl.add(nameJtf);
		
		createScoreTbl();
		endPnl.add(jtb);
		
		createSaveBtn();
		endPnl.add(saveBtn);
		
		createRestartBtn();
		endPnl.add(restartBtn);
		
		scoreLbl.setText("SCORE  " + scoreLbl.getText());
		scoreLbl.setHorizontalAlignment(JLabel.CENTER);
		scoreLbl.setFont(new Font("DungGeunMo", Font.BOLD, 70));
		scoreLbl.setBounds(40, 200, 600, 150);
		endPnl.add(scoreLbl);
		
		dataUpdate();
	}
	
	void createTitleLabel() {
		titleLbl = new JLabel();
		ImageIcon ii = new ImageIcon("..\\Test\\BreakOut_figure\\title2.png");
		titleLbl.setIcon(ii);
		titleLbl.setSize(ii.getIconWidth(), ii.getIconHeight());
		titleLbl.setLocation(40, 230);
	}
	
	void createStartBtn() {
		startBtn = new JLabel();
		ImageIcon ii = new ImageIcon("..\\Test\\BreakOut_figure\\startBtn2.png");
		startBtn.setIcon(ii);
		startBtn.setSize(ii.getIconWidth(), ii.getIconHeight());
		startBtn.setBackground(Color.black);
		startBtn.setLocation(240, 450);
		startBtn.addMouseListener(this);
	}
	
	void createScoreTbl() {
		String[] header = {"No", "User", "Score"};
		DefaultTableModel dtm = new DefaultTableModel(header, 0);
		jtb = new JTable(dtm);
		jtb.setBackground(Color.black);
		jtb.setForeground(Color.white);
		jtb.setGridColor(Color.black);
		jtb.setFont(new Font(null, Font.PLAIN, 15));
		DefaultTableCellRenderer tmp = new DefaultTableCellRenderer();
		tmp.setHorizontalAlignment(JLabel.CENTER);
		for(String colName : header) jtb.getColumn(colName).setCellRenderer(tmp);
//		jtb.setBounds(85, 200, 500, 450);
		jtb.setBounds(85, 400, 500, 250);
		dtm.addRow(header);
	}
	
	Wall[] createWalls(int startX, int ctWidth, int ctHeight) {
		Wall[] walls = new Wall[wallCount];
		int tmpWallCnt = 0;
		ctWidth -= 15;
		ctHeight -= 15;
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
					tmpWallCnt += 1;
					if(tmpWallCnt == wallCount) break a;
				}
		}
		return walls;
	}
	
	JLabel createTimeLabel() {
		JLabel timerLbl = new JLabel("0s");
		timerLbl.setHorizontalAlignment(JLabel.CENTER);
		timerLbl.setBounds(600, 0, 100, 50);
		timerLbl.setForeground(Color.GRAY);
		timerLbl.setBackground(Color.black);
		timerLbl.setFont(new Font("DungGeunMo", Font.BOLD, 20));
		timerLbl.setOpaque(true);
		return timerLbl;
	}
	
	JLabel createScoreLabel() {
		JLabel scoreLbl = new JLabel("" + Bar.score);
		//scoreLbl.setHorizontalAlignment(JLabel.CENTER);
		scoreLbl.setBounds(10, 0, 100, 50);
		scoreLbl.setForeground(Color.GRAY);
		scoreLbl.setBackground(Color.black);
		scoreLbl.setFont(new Font("DungGeunMo", Font.BOLD, 20));
		scoreLbl.setOpaque(true);
		return scoreLbl;
	}
	
//	JLabel createInfoLabel() {
//		JLabel info = new JLabel("time : " + 0 + "s, score : " + Bar.score);
//		info.setHorizontalAlignment(JLabel.CENTER);
//		info.setBounds(135, 550, 430, 100);
//		info.setForeground(Color.GRAY);
//		info.setBackground(Color.black);
//		info.setFont(new Font("Times", Font.BOLD, 20));
//		info.setOpaque(true);
//		return info;
//	}
	
	void createEndLabel() {
		ImageIcon ii = new ImageIcon("..\\Test\\BreakOut_figure\\gameover.jpg");
		endLbl = new JLabel();
		endLbl.setIcon(ii);
		endLbl.setSize(ii.getIconWidth(), ii.getIconHeight());
		endLbl.setLocation(210, 30);
	}
	
	void createNameTextField() {
		nameJtf = new JTextField(10);
		nameJtf.setBackground(Color.DARK_GRAY);
		nameJtf.setForeground(Color.LIGHT_GRAY);
		nameJtf.setBounds(120, 700, 250, 30);
	}
	
	void createSaveBtn() {
		saveBtn = new JButton("Save");
		saveBtn.setFont(new Font("DungGeunMo", Font.PLAIN, 30));
		saveBtn.setBorderPainted(false);
		saveBtn.setBackground(Color.BLACK);
		saveBtn.setForeground(Color.white);
		saveBtn.setBounds(415, 700, 150, 30);
		saveBtn.addActionListener(this);
	}
	
	void createRestartBtn() {
		restartBtn = new JButton("Restart");
		restartBtn.setFont(new Font("DungGeunMo", Font.PLAIN, 30));
		restartBtn.setBorderPainted(false);
		restartBtn.setBackground(Color.BLACK);
		restartBtn.setForeground(Color.white);
		restartBtn.setBounds(265, 770, 150, 30);
		restartBtn.addActionListener(this);
	}
	
	void process() {
		createStartPnl();
		ct.add(startPnl);
		ct.revalidate();
		ct.repaint();
		
		st = new ChangePnlThread();
		st.start();
		
		try {
			st.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		isStart = false;
		
		while(true) {
			initGame();
			
			try {
				ballMove.join();
				timer.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			endGame();
			
			try {
				st.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			isRestart = false;
		}
	}
	
	void initGame() {
		ct.removeAll();
		ct.revalidate();
		ct.repaint();
		
		createMainPnl();
		ct.add(mainPnl);
		ct.revalidate();
		ct.repaint();
		ct.requestFocus();
		
		// create connection
		tcpConnection = new TcpClient(bar, bar2, ball);
		tcpConnection.start();
//		new TcpSendThread(bar, ball).start();
		
		if(!TcpClient.allConnected) {
			loadLbl = new LoadThread(frameWidth, frameHeight, tcpConnection.allConnected);
			mainPnl.add(loadLbl);
			load = new Thread(loadLbl);
			load.start();
		}
		
		try {
			load.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mainPnl.remove(loadLbl);
		
		this.ballMove = null;
		ballMove = new Thread(ball);
		ballMove.start();
		
		this.timer = null;
		timer = new TimeThread(scoreLbl, timerLbl);
		bar.score = 0;
		timer.timeEnd = false;
		timer.start();
	}
	
	void endGame() {
		ct.removeAll();
		ct.revalidate();
		ct.repaint();
		
		createEndPnl();
		ct.add(endPnl);
		ct.revalidate();
		ct.repaint();
		
		st = new ChangePnlThread();
		st.start();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			moveLeftProcess();
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			moveRightProcess();
		}
		
		tcpConnection.sendMsg(bar.getX(), ball.getX(), ball.getY());
	}
	
	void moveRightProcess() {
		bar.moveRight();
		if((ball.getY() >= ct.getHeight() - 150) && (ball.ySpeed > 0)) bar.setMovRightAmt(1);
		bar.resetMovLeftAmt();
	}
	
	void moveLeftProcess() {
		bar.moveLeft();
		if((ball.getY() >= ct.getHeight() - 150) && (ball.ySpeed > 0)) bar.setMovLeftAmt(1);
		System.out.println(ball.ySpeed);
		bar.resetMovRightAmt();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().contentEquals("Save")) {
			String userName = nameJtf.getText();
			bar.userName = userName;
			db.insertBoard(bar.userName, bar.score);
			dataUpdate();
			nameJtf.setText("");
		}
		else {
			isRestart = true;
		}
	}
	
	public void dataUpdate() {
		clearJtable();
		ArrayList<String[]> data = db.readBoard();
		for(String[] userData : data) ((DefaultTableModel)jtb.getModel()).addRow(userData);
	}
	
	public void clearJtable() {
		((DefaultTableModel)jtb.getModel()).setNumRows(0);
		String[] header = {"No", "User", "Score"};
		((DefaultTableModel)jtb.getModel()).addRow(header);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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
		ImageIcon ii = new ImageIcon("..\\Test\\BreakOut_figure\\startClicked2.png");
		startBtn.setIcon(ii);
		startBtn.setSize(ii.getIconWidth(), ii.getIconHeight());
		startBtn.setLocation(220, 440);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		isStart = true;
	}
}