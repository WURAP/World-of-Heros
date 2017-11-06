package Motion;

import java.awt.Graphics;
import javax.swing.JLabel;

public class Label extends JLabel {
	private static final long serialVersionUID = 1L;

	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		// Hintergrund
		g.drawImage(Var.ib1, 0, Var.backgroundY1, 1200, 600, null);

		// Superhero
		g.drawImage(Var.superhero, Var.x, Var.y, 50, 34, null);
		repaint();
	}
}
