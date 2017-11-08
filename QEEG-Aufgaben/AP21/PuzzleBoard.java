import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PuzzleBoard extends JPanel {

    private static final long serialVersionUID = -9139866544143252957L;
    private final static int DELAY = 3500;
    private final static int TILE_SIZE = 30;
    private final static String HINWEIS = "Hinweis ";

    private List<WordClue> wordsClues;
    private char [] scramWord, word;
    private int prevIndex;

    private ActionListener al;
    private boolean tileSelected;
    private Component pnlGlass;
    private Font font;
    private int selectedTileID;
    private JLabel lblClue, counter;
    private int count;

    public PuzzleBoard (List<WordClue> wordsClues, Component pnlGlass, JLabel lblClue, JLabel counter)
    {
        this.wordsClues = new ArrayList<>();
        this.wordsClues = wordsClues;
        this.pnlGlass = pnlGlass;
        this.lblClue = lblClue;
        this.counter = counter;


        prevIndex = 0;

        nextWord(prevIndex = generateRandomNumber((wordsClues.size ())));

        font = new Font ("Arial", Font.BOLD, 20);
        addMouseListener (new MouseAdapter()
        {
            public void mouseClicked (MouseEvent e)
            {
                doSelection (e.getX ());
            }
        });

    }

    private void doSelection (int mouseX)
    {
        // Identify the tile that was clicked.
        int tileID = mouseX/TILE_SIZE;

        Timer timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                if (count < 100000) {
                    counter.setText(Integer.toString(count));
                } else {
                    ((Timer)(e.getSource())).stop();
                }
            }
        });
        timer.setInitialDelay(0);
        timer.start();

        // If no tile has been selected, highlight this tile. Its associated
        // character will be swapped with the character belonging to the next
        // tile (which is not highlighted) to be selected.
        if (!tileSelected)
        {
            tileSelected = true;
            selectedTileID = tileID;
            repaint ();
            return;
        }

        // Swap the characters in the scrambled word character array that are
        // associated with the highlighted tile (identified by selectedTileID)
        // and the second selected tile (identified by tileID).
        scramWord = swapTwoElementsInArray(scramWord, selectedTileID, tileID);
        tileSelected = false;

        // Display the swapped characters as soon as doSelection() and its
        // mouseClicked() method caller exit.
        repaint ();

        // Return if the word has not been unscrambled.
        for (int i = 0; i < word.length; i++)
            if (word [i] != scramWord [i])
                return;

        // Inform the user that the word has been unscrambled as soon as
        // doSelect() and its mouseClicked() method caller exit.
        lblClue.setHorizontalTextPosition (JLabel.CENTER);
        lblClue.setText ("RICHTIG!");
        timer.stop();
        count = 0;
        counter.setText(" ");

        // Activate the glass pane.
        pnlGlass.setVisible (true);

        // Create the action listener that takes us to the next scrambled word.
        if (al == null)
            al = new ActionListener ()
            {
                public void actionPerformed (ActionEvent e)
                {
                    int index;
                    while ((index = generateRandomNumber (wordsClues.size ())) == prevIndex);
                    prevIndex = index;
                    nextWord(prevIndex);
                    revalidate ();
                    pnlGlass.setVisible (false);
                }
            };


        // Register an action listener with a non-repeating (one-shot) timer.
        // This listener is contacted after a suitable delay.
        javax.swing.Timer t = new javax.swing.Timer (DELAY, al);
        t.setRepeats (false);

        // Start the timer.
        t.start ();
    }

    protected void paintComponent (Graphics g)
    {
        int width = getWidth ();
        int height = getHeight ();

        // This component is always opaque, so color entire background.
        g.setColor (Color.blue);
        g.fillRect (0, 0, width, height);

        // Highlight the first selected tile.
        if (tileSelected)
        {
            g.setColor (Color.yellow);
            g.fillRect (selectedTileID*TILE_SIZE, 0, TILE_SIZE, height);
        }

        g.setFont (font);
        FontMetrics fm = g.getFontMetrics ();

        // Paint the tiles and their associated characters.
        for (int i = 0; i < word.length; i++)
        {
            g.setColor (Color.white);
            g.drawLine (i*TILE_SIZE, 0, i*TILE_SIZE+TILE_SIZE-1, 0);
            g.drawLine (i*TILE_SIZE, 0, i*TILE_SIZE, height-1);

            g.setColor (Color.black);
            g.drawLine (i*TILE_SIZE, height-1, i*TILE_SIZE+TILE_SIZE-1,
                    height-1);
            g.drawLine (i*TILE_SIZE+TILE_SIZE-1, 0, i*TILE_SIZE+TILE_SIZE-1,
                    height-1);

            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint (RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            if (tileSelected && i == selectedTileID)
                g.setColor (Color.black);
            else
            {
                g.setColor (Color.black);

                // Render the shadow.
                g.drawString (""+scramWord [i], i*TILE_SIZE+
                                (TILE_SIZE-fm.stringWidth (""+scramWord [i]))/2+3,
                        3*height/4+3);

                g.setColor (Color.yellow);
            }

            g.drawString (""+scramWord [i], i*TILE_SIZE+
                            (TILE_SIZE-fm.stringWidth (""+scramWord [i]))/2,
                    3*height/4);
        }
    }



    // Return a randomly chosen integer between 0 and limit-1 inclusive.
    private int generateRandomNumber(int limit)
    {
        return (int) (Math.random ()*limit);
    }

    private char [] scramble (char [] word)
    {
        // Create a copy of the array word, automatically sets the appropriate size.
        char [] scramWord = Arrays.copyOf(word, word.length);

        // Boolean variables to determine when the while loop should abort.
        // Default initialization with true, so that the loop is executed at least once.
        boolean checkWordLevelOfDifficultity = true;

        while (checkWordLevelOfDifficultity)
        {
            // 100 runs in which two elements in the array are randomly swapped.
            for (int i = 0; i < 100; i++)
            {
                // Random index of the first element.
                int x = generateRandomNumber(word.length);
                // Random index of the second element.
                int y = generateRandomNumber(word.length);
                
                // The method swaps the elements at the index positions x and y in the array and returns
                // the array of swapped elements.
                scramWord = swapTwoElementsInArray(scramWord, x, y);
            }

            // Make sure word is scrambled in the forward and reverse directions.
            // For example, if word contains "Game", scramWord must not
            // contain "Game" or "emaG".
            for (int i = 0; i < word.length; i++)
                if (word [i] != scramWord [i] && word [i] != scramWord [word.length-1-i]){
                    // If the elements do not match, the variable CheckWordLevelOfDifficultity
                    // is set to false and the loop aborts.
                    checkWordLevelOfDifficultity = false;
                }
        }

        // Returns the array with the swapped elements (mixed array).
        return scramWord;
    }


    // Method gets the next word from the wordClues list.
    public void nextWord(int index){

        // Prevent the same word from being chosen as the next word.
        WordClue wc = wordsClues.get (index);
        word = wc.getWord();
        scramWord = scramble (word);
        lblClue.setText (HINWEIS + wc.getClue());

        // The Box container's BoxLayout manager requires a component's maximum
        // size to be set equal to its preferred size (for proper layout).
        setPreferredSize (new Dimension (word.length*TILE_SIZE, TILE_SIZE));
        setMaximumSize (new Dimension (word.length*TILE_SIZE, TILE_SIZE));

    }

    // Method swaps two elements in the array.
    public char[] swapTwoElementsInArray(char[] array, int index1, int index2){

        char singleCharacter = array [index1];
        array[index1] = array[index2];
        array[index2] = singleCharacter;

        return array;
    }
}




