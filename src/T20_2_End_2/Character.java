package T20_2_End_2;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Character extends JLabel {
	private static int score = 0;
	int xMax, speed;
	private static int x = 220, y = 530;
	private static int width, height;
	ImageIcon rightImage, leftImage;
	
	public Character(int screenWidth) {
		xMax = screenWidth;
		speed = 5;
		
		rightImage = new ImageIcon("..\\JAVA_edu_Á¤½ÂÇö\\src\\T20_2_End_2\\Human_R.png");
		leftImage = new ImageIcon("C:\\Users\\witlab\\OneDrive\\WITLAB\\Java\\java_edu_Á¤½ÂÇö\\JAVA_edu_Á¤½ÂÇö\\src\\T20_2_End_2\\Human_L.png");
		setIcon(rightImage);
		setSize(rightImage.getIconWidth(), rightImage.getIconHeight());
		setLocation(x, y);
		
		width = getWidth();
		height = getHeight();
	}
	
	public void moveRight() {
		setIcon(rightImage);
		setLocation(getX() + speed, 530);
		x = getX();
	}
	
	public void moveLeft() {
		setIcon(leftImage);
		setLocation(getX() - speed, 530);
		y = getY();
	}
	
	public static synchronized void addScore() { score += 1; }
	public static int getScore() { return score; }
	public static int getXLocate() { return x; }
	public static int getYLocate() { return y; }
	public static int getCharacterWidth() { return width; }
	public static int getCharacterHeight() { return height; }
}
