import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window {
  static String[] texts = {
    "First game description",
    "Second game description",
    "Third game description"
  };
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    JButton game1 = new JButton("First game");
    JButton game2 = new JButton("Second game");
    JButton game3 = new JButton("Third game");

    game1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JFrame desc = new JFrame();
        JLabel label = new JLabel(texts[0]);
        desc.add(label);
        desc.pack();
        desc.show(true);
      }
    });

    game2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JFrame desc = new JFrame();
        JLabel label = new JLabel(texts[1]);
        desc.add(label);
        desc.pack();
        desc.show(true);
      }
    });

    game3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JFrame desc = new JFrame();
        JLabel label = new JLabel(texts[2]);
        desc.add(label);
        desc.pack();
        desc.show(true);
      }
    });


    frame.add(game1, "North");
    frame.add(game2, "Center");
    frame.add(game3, "South");

    frame.pack();

    frame.show(true);
  }
}
