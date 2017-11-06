import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.*;
import javax.swing.JButton;

public class InCorrect implements  ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		JButton button=new JButton();
		if(e.getSource().getClass()==button.getClass())
		{
			JButton butt=((JButton)(e.getSource()));
			
			butt.setBackground(Color.RED);
			butt.getParent().getParent();
		}
	}
}
