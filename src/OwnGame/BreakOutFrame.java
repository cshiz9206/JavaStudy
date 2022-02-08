package OwnGame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BreakOutFrame extends JFrame implements KeyListener {
	User user;
	Ball ball;
	
	Container ct;
	
	final int floor = 5;
	final int wallCntByFloor = 12;
	final int wallCount = floor * wallCntByFloor;
	
	public BreakOutFrame() {
		setSize(676, 900);
		setTitle("Break out");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ct = getContentPane();
		ct.setLayout(null);
		ct.setFocusable(true);
		ct.addKeyListener(this);
		ct.setBackground(Color.black);

		setVisible(true);
		
		Wall[] walls = createWalls(ct.getWidth(), ct.getHeight(), wallCount);
		
		user = new User(ct.getWidth(), ct.getHeight());
		ct.add(user);
		
		ball = new Ball(ct.getWidth(), ct.getHeight(), user, walls, ct);
		ct.add(ball);
		
		JLabel info = new JLabel();
		info.setHorizontalAlignment(JLabel.CENTER);
		info.setSize(430, 100);
		info.setForeground(Color.GRAY);
		info.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 20));
		info.setLocation(ct.getWidth() / 2 - (info.getWidth() / 2), ct.getHeight() - 150);
		ct.add(info);

		new Thread(ball).start();
		new TimeThread(info).start();
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
	
	Wall[] createWalls(int ctWidth, int ctHeight, int wallCount) {
		Wall[] walls = new Wall[wallCount];
		int tmpWallCnt = 0;
		a : for(int i = 0; i < wallCntByFloor; i++) {
				for(int j = 0; j < floor; j++) {
					walls[tmpWallCnt] = new Wall(ctWidth, ctHeight);
					walls[tmpWallCnt].setLocation(((i * ctWidth / wallCntByFloor) + 
							(ctWidth / wallCntByFloor / 2) - (walls[tmpWallCnt].getWidth() / 2)), 
							50 + j * (walls[tmpWallCnt].getHeight() + 10));
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
}
