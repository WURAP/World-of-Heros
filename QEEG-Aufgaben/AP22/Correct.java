import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Correct implements ActionListener {

   private JButton button;
   private JButton question;

    public Correct(JButton button,JButton question) {
        this.button = button;
        this.question = question;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Result result = new Result();
        if(result.getResult(question.getText().toCharArray(),button.getText())){
            button.setBackground(Color.GREEN);
        }else{
            button.setBackground(Color.RED);
        }
    }
}
