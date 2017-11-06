package Motion;

import javax.swing.JFrame;

public class GUI {

	public GUI() {
		Var.jfl = new JFrame();
		Var.jfl.setSize(Var.screenwidth, Var.screenheight);
		Var.jfl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Var.jfl.setLocationRelativeTo(null);
		Var.jfl.setLayout(null);
		Var.jfl.setTitle("World of Heros");
		Var.jfl.setResizable(false);
		Var.jfl.requestFocus();
		Var.jfl.setVisible(true);
		Var.lbl1 = new Label();
		Var.lbl1.setBounds(0, 0, Var.screenwidth, Var.screenheight);
		Var.lbl1.setVisible(true);
		Var.jfl.add(Var.lbl1);
	}

}
