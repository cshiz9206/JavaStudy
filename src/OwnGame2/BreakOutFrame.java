package OwnGame2;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

public class BreakOutFrame extends JFrame implements KeyListener, ActionListener {
	JPanel mainPnl;
	JPanel endPnl;
	JPanel backPnl;
	JTable jtb;
	JLabel info;
	JLabel endLbl;
	JButton saveBtn, restartBtn;
	JTextField nameJtf;
	
	Container ct;
	ScoreBoard db;
	
	Wall[] walls;
	Bar bar;
	Ball ball;
	
	Thread ballMove;
	TimeThread timer;
	
	final int floor = 5;
	final int wallCntByFloor = 12;
	final int wallCount = floor * wallCntByFloor;
	
	final int frameWidth = 700;
	final int frameHeight = 900;
	
	boolean isRestart = false;
	
	public BreakOutFrame() {
		// initialize Window
		initFrame();
		initContainer();
		
		// create DataBase;
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
	
	void createBackPnl() {
		backPnl = new JPanel();
		backPnl.setBackground(Color.green);
		backPnl.setBounds(0, 0, frameWidth, frameHeight);
		ct.add(backPnl);
	}
	
	void createMainPnl() {
		mainPnl = new JPanel(null);
		mainPnl.setBackground(Color.black);
		mainPnl.setBounds(0, 0, frameWidth, frameHeight);
		
		createWalls(0, frameWidth, frameHeight);
		for(Wall wall : walls) mainPnl.add(wall);
		
		bar = new Bar(0, frameWidth, frameHeight);
		mainPnl.add(bar);
		
		ball = new Ball(0, frameWidth - 20, frameHeight, bar, walls, mainPnl);
		mainPnl.add(ball);
		
		createInfoLabel();
		mainPnl.add(info);
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
		
		dataUpdate();
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
		jtb.setBounds(90, 200, 500, 450);
		dtm.addRow(header);
	}
	
	void createWalls(int startX, int ctWidth, int ctHeight) {
		walls = new Wall[wallCount];
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
	}
	
	void createInfoLabel() {
		info = new JLabel("time : " + 0 + "s, score : " + Bar.score);
		info.setHorizontalAlignment(JLabel.CENTER);
		info.setBounds(135, 550, 430, 100);
		info.setForeground(Color.GRAY);
		info.setBackground(Color.black);
		info.setFont(new Font("��������", Font.BOLD, 20));
		info.setOpaque(true);
	}
	
	void createEndLabel() {
		ImageIcon ii = new ImageIcon("..\\BreakOut_figure\\gameover.jpg");
		endLbl = new JLabel();
		endLbl.setIcon(ii);
		endLbl.setSize(ii.getIconWidth(), ii.getIconHeight());
		endLbl.setLocation(210, 30);
	}
	
	void createNameTextField() {
		nameJtf = new JTextField(10);
		nameJtf.setBackground(Color.black);
		nameJtf.setForeground(Color.LIGHT_GRAY);
		nameJtf.setBounds(125, 700, 250, 30);
	}
	
	void createSaveBtn() {
		saveBtn = new JButton("Save");
		saveBtn.setBackground(Color.BLACK);
		saveBtn.setForeground(Color.white);
		saveBtn.setBounds(420, 700, 150, 30);
		saveBtn.addActionListener(this);
	}
	
	void createRestartBtn() {
		restartBtn = new JButton("Restart");
		restartBtn.setBackground(Color.BLACK);
		restartBtn.setForeground(Color.white);
		restartBtn.setBounds(270, 770, 150, 30);
		restartBtn.addActionListener(this);
	}
	
	void startGame() {
		// TODO Auto-generated method stub
		initGame();
		
		try {
			ballMove.join();
			timer.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ct.removeAll();
		ct.revalidate();
		ct.repaint();
		
		createEndPnl();
		ct.add(endPnl);
		ct.revalidate();
		ct.repaint();
	}
	
	void initGame() {
		createMainPnl();
		ct.add(mainPnl);
		ct.revalidate();
		ct.repaint();
		ct.requestFocus();
		
		ballMove = new Thread(ball);
		ballMove.start();
		
		timer = new TimeThread(info);
		timer.start();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			bar.moveLeft();
			if((ball.getY() >= ct.getHeight() - 150) && (ball.ySpeed > 0)) bar.setMovLeftAmt();
			System.out.println(ball.ySpeed);
			bar.resetMovRightAmt();
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			bar.moveRight();
			if((ball.getY() >= ct.getHeight() - 150) && (ball.ySpeed > 0)) bar.setMovRightAmt();
			bar.resetMovLeftAmt();
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
}