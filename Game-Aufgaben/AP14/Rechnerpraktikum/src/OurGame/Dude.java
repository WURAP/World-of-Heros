package OurGame;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Dude {
	int x, dx, y;
	Image still;

	public Dude() {
		ImageIcon i = new ImageIcon("//C:\\Users\\Astrid\\Desktop\\hero.png");
		still = i.getImage();
		x = 0;
		y = 172;
		//C:\\Users\\Astrid\\Desktop\\hero.png
	}

	public void move() {
		
	if (y < 356 && y > 0)
		   y = y + dx;
	
	if (x < 650)
		x = x + 1;
	
		
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImage() {
		return still;
	}
	
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_UP)
			dx = -1;

		if (key == KeyEvent.VK_DOWN)
			dx = 1;
					
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_UP)
			dx = 0;

		if (key == KeyEvent.VK_DOWN)
			dx = 0;
	}

}
