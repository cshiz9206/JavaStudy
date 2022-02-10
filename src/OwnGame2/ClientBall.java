package OwnGame2;

import java.awt.Container;
import java.awt.Point;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ClientBall extends JLabel implements Runnable {
	int maxWidth, maxHeight;
	ClientBar user;
	Wall[] walls;
	Container ct;
	double xSpeed, ySpeed;
	static boolean isDead = false;
	final int MAXSPEED = 10;
	
	public ClientBall(int startX, int maxWidth, int maxHeight, ClientBar user, Wall[] walls, Container ct) {
		ImageIcon ii = new ImageIcon(System.getProperty("user.dir") + "\\src\\OwnGame\\ball.png");
		setIcon(ii);
		setSize(ii.getIconWidth(), ii.getIconHeight());
		setLocation(startX + maxWidth / 2 - (getWidth() / 2), maxHeight / 2);
		
		this.maxWidth = maxWidth;
		this.maxHeight = maxHeight;
		this.user = user;
		this.walls = walls;
		this.ct = ct;
		
		this.xSpeed = 0;
		this.ySpeed = 0;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			if(checkWallsRemoved()) {
				ct.remove(this);
				ct.repaint();
				isDead = true;
				break;
			}
			if(isDead || TimeThread.timeEnd) {
				ct.remove(this);
				ct.repaint();
				break;
			}
			
			checkBumpedBorder();
			checkBumpedUser();
			checkBumpedWall();
			
			setLocation((int)(getX() + xSpeed), (int)(getY() + ySpeed));
			ct.repaint();
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	boolean checkWallsRemoved() {
		for(int i = 0; i < walls.length; i++) {
			if(walls[i] != null) return false;
		}
		return true;
	}
	
	void checkBumpedBorder() {
		if(getX() <= 0) xSpeed *= -1;
		if((getX() + getWidth()) >= maxWidth) xSpeed *= -1;
		if(getY() <= 0) ySpeed *= -1;
		if((getY() + getHeight()) >= maxHeight) isDead = true;
	}
	
	void checkBumpedUser() {
		if(user.getBounds().contains(getBounds().getCenterX(), getBounds().getMaxY())) {
			ySpeed *= -1;
			
			xSpeed += user.moveRightAmt;
			xSpeed -= user.moveLeftAmt;
			if(xSpeed > MAXSPEED) xSpeed = MAXSPEED;
			if(xSpeed < (-1) * MAXSPEED) xSpeed = (-1) * MAXSPEED;
			
			user.resetMovLeftAmt();
			user.resetMovRightAmt();
		}
	}
	
	void checkBumpedWall() {
		boolean isBumped;
		Point topP = new Point((int)getBounds().getCenterX(), getY());
		Point rightP = new Point((int)getBounds().getMaxX(), (int)getBounds().getCenterY());
		Point leftP = new Point((int)getBounds().getMinX(), (int)getBounds().getCenterY());
		Point bottomP = new Point((int)getBounds().getCenterX(), (int)getBounds().getMaxY());
		Point leftTopP = new Point((int)getBounds().getMinX(), (int)getBounds().getMinY());
		Point leftBotP = new Point((int)getBounds().getMinX(), (int)getBounds().getMaxY());
		Point rightTopP = new Point((int)getBounds().getMaxX(), (int)getBounds().getMinY());
		Point rightBotP = new Point((int)getBounds().getMaxX(), (int)getBounds().getMaxY());
		for(int i = 0; i < walls.length; i++) {
			isBumped = false;
			if(walls[i] == null) continue;
			if(walls[i].getBounds().contains(topP)) {
				ySpeed *= -1;
				isBumped = true;
			}
			else if(walls[i].getBounds().contains(rightP)) {
				xSpeed *= -1;
				isBumped = true;
			}
			else if(walls[i].getBounds().contains(leftP)) {
				xSpeed *= -1;
				isBumped = true;
			}
			else if(walls[i].getBounds().contains(bottomP)) {
				ySpeed *= -1;
				isBumped = true;
			}
			else if(walls[i].getBounds().contains(leftTopP)) {
				xSpeed = Math.abs(xSpeed);
				ySpeed = Math.abs(ySpeed);
				isBumped = true;
			}
			else if(walls[i].getBounds().contains(leftBotP)) {
				xSpeed = Math.abs(xSpeed);
				ySpeed = -Math.abs(ySpeed);
				isBumped = true;
			}
			else if(walls[i].getBounds().contains(rightBotP)) {
				xSpeed = -Math.abs(xSpeed);
				ySpeed = -Math.abs(ySpeed);
				isBumped = true;
			}
			else if(walls[i].getBounds().contains(rightTopP)) {
				xSpeed = -Math.abs(xSpeed);
				ySpeed = Math.abs(ySpeed);
				isBumped = true;
			}
			
			if(isBumped) {
				walls[i].scoring();
				crash(i);
				
				ct.remove(walls[i]);
				ct.repaint();
				walls[i] = null;
			}
		}
	}
	
	void crash(int i) {
		for(int j = 0; j < 100; j++) {
			Fragment fg = new Fragment(walls[i], ct);
			new Thread(fg).start();
		}
	}
}
