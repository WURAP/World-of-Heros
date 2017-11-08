import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class WordClue {

    private char [] word;
    private String clue;

    public WordClue() {
    }

    public WordClue(char[] word, String clue) {
        this.word = word;
        this.clue = clue;
    }

    public char[] getWord() {
        return word;
    }

    public void setWord(char[] word) {
        this.word = word;
    }

    public String getClue() {
        return clue;
    }

    public void setClue(String clue) {
        this.clue = clue;
    }


    public List<WordClue> readFromInputFile(String path){
        List<WordClue> wordClues = new ArrayList<>();
        
        // Read the words and clues text file's contents into the wordsClues
        // ArrayList. The file must exist.
        InputStreamReader isr = null;
        BufferedReader br = null;

        try
        {
            InputStream is = getClass().getResourceAsStream (path);
            if (is == null) {
                System.err.println (path + " does not exist");
            }
            isr = new InputStreamReader (is);
            br = new BufferedReader (isr);

            String line;
            while ((line = br.readLine ()) != null)
            {
                // Each line contains two parts separated by a colon character.
                String [] parts = line.toUpperCase ().split (":");

                // parts.length returns 1 for blank lines. This if statement
                // prevents an exception that occurs if you accidentally insert a
                // blank line into the file (typically at the end of the file).
                if (parts.length != 2)
                    break;
                
                // Constructor in which the instance variables word and clue are initialized directly.
                // 1st parameter initialization of instance variable word.
                // 2nd parameter initialization of instance variable clue.
                WordClue wc = new WordClue(parts [0].trim ().toCharArray (), parts [1].trim ());
                wordClues.add (wc);
            }
        }
        catch (IOException ioe)
        {
            System.err.println ("Exception class WordClue: " + ioe.getMessage());

        }
        finally
        {
            try
            {
                if(br != null){
                    br.close();
                }
                if(isr != null){
                    isr.close();
                }
            }
            catch (IOException ioe)
            {
                System.err.println("Exception class WordClue: " + ioe.getMessage());
            }
        }
        return wordClues;
    }

}
