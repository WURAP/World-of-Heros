import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.*;

public class NextAction implements ActionListener {
    private JButton question;
    private List<JButton> buttonList;
    Random random = new Random();

    public NextAction(JButton question, List<JButton> buttonList) {
        this.question = question;
        this.buttonList = buttonList;
    }

    public void actionPerformed(ActionEvent e) {
        Color color = UIManager.getColor( "Panel.background");
        for (JButton button:buttonList) {
            button.setBackground(color);
        }
        Operation op = new Operation();
        int a = random.nextInt(4);
        switch (a) {
            case 0:
                op.Sum(buttonList, question);
                break;
            case 1:
                op.Substract(buttonList, question);
                break;
            case 2:
                op.Divide(buttonList, question);
                break;
            case 3:
                op.Multiply(buttonList, question);
                break;
        }
        Result result = new Result();
        for (JButton button : buttonList) {
                button.addActionListener(new Correct(button,question));
        }
    }


}
