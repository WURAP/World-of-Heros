import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.util.List;

public class Buchstabenspiel extends JApplet
{
    private static final long serialVersionUID = 952170643977406303L;
    private final static String WORDS_CLUES_FILE = "wordsclues.txt";
    private List<WordClue> wordsClues;

    public void init ()
    {
        WordClue clue = new WordClue();
        wordsClues = clue.readFromInputFile(WORDS_CLUES_FILE);

        try
        {
            SwingUtilities.invokeAndWait (new Runnable ()
            {
                public void run ()
                {
                    createGUI ();
                }
            });
        }
        catch (Exception exc)
        {
            System.err.println (exc.getMessage());
        }
    }

    private void createGUI ()
    {
        // This applet uses a transparent JPanel to prevent puzzle tiles from being
        // selected between correctly unscrambling a word and the applet
        // presenting the next scrambled word.
        JPanel pnlGlass = new JPanel ();
        pnlGlass.setOpaque (false);
        pnlGlass.addMouseListener (new MouseAdapter() {});
        pnlGlass.addMouseMotionListener (new MouseMotionAdapter() {});
        setGlassPane (pnlGlass);

        // Create the GUI components. A clue that associates with the current
        // scrambled word is presented via a label. The scrambled word is
        // presented via the puzzle board as a horizontal sequence of tiles (one
        // tile per word character).
        JLabel lblClue = new JLabel ("");
        lblClue.setForeground (Color.white);

        JLabel counter = new JLabel("");
        counter.setFont(new Font("Arial", Font.PLAIN, 30));
        counter.setForeground(Color.white);

        PuzzleBoard pb = new PuzzleBoard(wordsClues, pnlGlass, lblClue, counter);

        // Lay out the GUI such that the label is centered below the centered
        // puzzle board.
        Box vBox = Box.createVerticalBox ();
        vBox.add (Box.createVerticalStrut (10));

        Box hBox = Box.createHorizontalBox ();
        hBox.add (Box.createHorizontalGlue ());
        hBox.add (pb);
        hBox.add (Box.createHorizontalGlue ());
        vBox.add (hBox);

        vBox.add (Box.createVerticalStrut (10));

        hBox = Box.createHorizontalBox ();
        hBox.add (Box.createHorizontalGlue ());
        hBox.add (lblClue);
        hBox.add (Box.createHorizontalGlue ());
        vBox.add (hBox);
        hBox.add(counter);

        // Install the GUI.
        setContentPane (vBox);
        setSize(500, 150);

        // Background colour.
        setBackground (new Color (0, 128, 0));
    }

}
