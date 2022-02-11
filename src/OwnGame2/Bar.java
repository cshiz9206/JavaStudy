package OwnGame2;

import java.awt.Container;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bar extends JLabel {
	int maxWidth;
	int moveLeftAmt = 0;
	int moveRightAmt = 0;
	final int SPEED = 10;
	
	static int score = 0;
	static String userName = "none";
	
	public Bar(int startX, int maxWidth, int maxHeight) {
		ImageIcon ii = new ImageIcon("..\\BreakOut_figure\\user.png");
		setIcon(ii);
		setSize(ii.getIconWidth(), ii.getIconHeight());
		//setLocation(startX + maxWidth / 2 - (getWidth() / 2), maxHeight - 70);
		setLocation(270, 810);
		
		this.maxWidth = maxWidth;
	}
	
	public void moveRight() { 
		setLocation(getX() + SPEED, getY());
		if(getBounds().getMaxX() > maxWidth) setLocation(maxWidth - getWidth(), getY());
	}
	public void moveLeft() { 
		setLocation(getX() - SPEED, getY()); 
		if(getX() < 0) setLocation(0, getY());
	}
	public void resetMovRightAmt() { moveRightAmt = 0; }
	public void resetMovLeftAmt() { moveLeftAmt = 0; }
	public void setMovRightAmt() { 
		moveRightAmt += 1;
		if(moveRightAmt > 3) moveRightAmt = 3;
	}
	public void setMovLeftAmt() { 
		moveLeftAmt += 1;
		if(moveLeftAmt > 3) moveLeftAmt = 3;
	}
}
