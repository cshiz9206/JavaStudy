package OwnGame;

import java.awt.Container;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Fragment extends JLabel implements Runnable {
	int moveX, moveY;
	
	Container ct;
	
	public Fragment(Wall wall, Container ct) {
		ImageIcon ii = new ImageIcon(wall.color.fragPath);
		setIcon(ii);
		setSize(ii.getIconWidth(), ii.getIconHeight());
		
		Random rd = new Random();
		
		int x = (int) (rd.nextInt(wall.getWidth()) + wall.getBounds().getMinX());
		int y = (int) (rd.nextInt(wall.getHeight()) + wall.getBounds().getMinY());
		setLocation(x, y);
		
		moveX = rd.nextInt(6) - 3;
		moveY = rd.nextInt(3) + 1;
		
		this.ct = ct;
		ct.add(this);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int moved = 0;
		float tmp = 0;
		while(true) {
			if(moveX < 0) moveX -= 0.2; //moveX -= Math.log(tmp);
			else if(moveX > 0) moveX += 0.2; //moveX += Math.log(tmp);
			moveY += Math.pow(1.2, tmp);
			setLocation(getX() + moveX, getY() + moveY);
			moved += moveY;
			tmp += 0.5;
			if(moved >= 400) {
				ct.remove(this);
				break;
			}
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
