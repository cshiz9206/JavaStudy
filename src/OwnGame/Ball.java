package OwnGame;

import java.awt.Container;
import java.awt.Point;
import java.util.Arrays;
import java.util.Random;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Ball extends JLabel implements Runnable {
	int maxWidth, maxHeight;
	User user;
	Wall[] walls;
	Container ct;
	double xSpeed, ySpeed;
	static boolean isDead = false;
	final int MAXSPEED = 10;
	
	public Ball(int maxWidth, int maxHeight, User user, Wall[] walls, Container ct) {
		ImageIcon ii = new ImageIcon("C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_Á¤½ÂÇö\\JAVA_edu_Á¤½ÂÇö\\src\\OwnGame\\ball.png");
		setIcon(ii);
		setSize(ii.getIconWidth(), ii.getIconHeight());
		setLocation(maxWidth / 2 - (getWidth() / 2), maxHeight / 2);
		
		this.maxWidth = maxWidth;
		this.maxHeight = maxHeight;
		this.user = user;
		this.walls = walls;
		this.ct = ct;
		
		Random rd = new Random();
		this.xSpeed = 0;
		this.ySpeed = rd.nextInt(MAXSPEED) + 1;
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
		boolean isBumped = false;
		if(getX() <= 0) xSpeed *= -1;
		if((getX() + getWidth()) >= maxWidth) xSpeed *= -1;
		if(getY() <= 0) ySpeed *= -1;
		if((getY() + getHeight()) >= maxHeight) ySpeed *= -1; //isDead = true;
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
		for(int j = 0; j < 40; j++) {
			Fragment fg = new Fragment(walls[i], ct);
			new Thread(fg).start();
		}
	}
	
//	void calcDirSpeed(int i) {
//		Vector<Double> p1v = new Vector<Double>(Arrays.asList(xSpeed, ySpeed));
//		Vector<Double> p1r = new Vector<Double>(Arrays.asList((double)getBounds().getCenterX(), (double)getBounds().getCenterY()));
//		Vector<Double> p2r = new Vector<Double>(Arrays.asList((double)walls[i].getBounds().getCenterX(), (double)walls[i].getBounds().getCenterY()));
//		Vector<Double> p2v = new Vector<Double>(Arrays.asList((double)0, (double)0));
//		Vector<Double> p1rSp2r = new Vector<Double>(Arrays.asList((double)p1r.get(0) - (double)p2r.get(0), (double)p1r.get(1) - (double)p2r.get(1)));
//		Vector<Double> p2rSp1r = new Vector<Double>(Arrays.asList((double)p2r.get(0) - (double)p1r.get(0), (double)p2r.get(1) - (double)p1r.get(1)));
//		Vector<Double> p1vSp2v = new Vector<Double>(Arrays.asList((double)p1v.get(0) - (double)p2v.get(0), (double)p1v.get(1) - (double)p2v.get(1)));
//		Vector<Double> dTmp = new Vector<Double>(Arrays.asList((double)p1rSp2r.get(0) / (double)p1rSp2r.get(0), (double)p1rSp2r.get(1) / (double)p1rSp2r.get(1)));
//		Vector<Double> d = new Vector<Double>(Arrays.asList((double)dTmp.get(0) * (double)dTmp.get(0), ((double)dTmp.get(1) * (double)dTmp.get(1))));
//		Vector<Double> dotTmp = new Vector<Double>(Arrays.asList(Math.abs((double)p1vSp2v.get(0) * (double)p1rSp2r.get(0)), Math.abs((double)p1vSp2v.get(1) * (double)p1rSp2r.get(1))));
//		double dot = (double)dotTmp.get(0) + (double)dotTmp.get(1);
//		Vector<Double> div = new Vector<Double>(Arrays.asList((double)dot / (double)d.get(0), (double)dot / (double)d.get(1)));
//		Vector<Double> mul = new Vector<Double>(Arrays.asList((double)div.get(0) * (double)p2rSp1r.get(0), (double)div.get(1) * (double)p2rSp1r.get(1)));
//		Vector<Double> sub = new Vector<Double>(Arrays.asList((double)p2v.get(0) - (double)mul.get(0), (double)p2v.get(1) - (double)mul.get(1)));
//		Vector<Double> u1 = sub;
//		xSpeed = u1.get(0) % 5;
//		ySpeed = u1.get(1) % 5;
//	}
}
