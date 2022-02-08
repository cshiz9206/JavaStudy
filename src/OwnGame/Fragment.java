package OwnGame;

import java.awt.Container;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Fragment extends JLabel implements Runnable {
	int moveX;
	int moveY;
	
	Container ct;
	
	public Fragment(Wall wall, Container ct) {
		ImageIcon ii = new ImageIcon(wall.color.fragPath);
		setIcon(ii);
		setSize(ii.getIconWidth(), ii.getIconHeight());
		
		Random rd = new Random();
		
		int x = (int) (rd.nextInt(wall.getWidth()) + wall.getBounds().getMinX());
		int y = (int) (rd.nextInt(wall.getHeight()) + wall.getBounds().getMinY());
		setLocation(x, y);
		
		moveX = rd.nextInt(10) - 5;
		moveY = rd.nextInt(3) + 1;
		
		this.ct = ct;
		ct.add(this);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int moved = 0;
		while(true) {
			if(moveX < 0) moveX -= Math.log(moved);
			else if(moveX > 0) moveX += Math.log(moved);
			moveY += Math.exp(moved);
			setLocation(getX() + moveX, getY() + moveY);
			moved += moveY;
			if(moved >= 500) {
				ct.remove(this);
				break;
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
