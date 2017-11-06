package Motion;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Var {

	static JFrame jfl;
	static int screenwidth = 1200, screenheight = 600;
	static int backgroundY1 = 0;
	static int x = 0, y = 250;
	static int speedup = 2, speeddown = 2;
	static double linksnachrechts = 1;
	static boolean moveup = false, movedown = false;
	static Label lbl1;

	static BufferedImage ib1;
	static BufferedImage superhero;

	public Var() {

		try {
			// Background
			ib1 = ImageIO.read(new File("//home/h1250600/SR/eclipse-workspace/hero_v0.2/src/rsc/b1.png"));

			// Superheld
			superhero = ImageIO.read(new File("//home/h1250600/SR/eclipse-workspace/hero_v0.2/src/rsc/superhero.png"));

		} catch (IOException e) {

		}

	}
}
