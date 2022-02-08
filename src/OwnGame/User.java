package OwnGame;

import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class User extends JLabel {
	int maxWidth;
	int moveLeftAmt = 0;
	int moveRightAmt = 0;
	final int SPEED = 10;
	
	static int score = 0;
	
	public User(int maxWidth, int maxHeight) {
		ImageIcon ii = new ImageIcon("C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_Á¤½ÂÇö\\JAVA_edu_Á¤½ÂÇö\\src\\OwnGame\\user.png");
		setIcon(ii);
		setSize(ii.getIconWidth(), ii.getIconHeight());
		setLocation(maxWidth / 2 - (getWidth() / 2), maxHeight - 30);
		
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
