
/**
 * WordLattice.java
 *
 * a word lattice
 * comprising a number of word hypotheses
 * each with the word, start time, and time and log prob
 *
 * @author <a href="mailto: "Phil Green</a>
 * 2013 version
 */

import sheffield.*;
import java.util.*;

public class WordLattice{

    private ArrayList<WordH> wordHSet; // all the words
    private int endTime; // the end time of the last word

    // accessors
    public ArrayList<WordH> getAllWordHs(){
        return wordHSet;
    }

    public int getEndTime(){
        return endTime;
    }

    // constructor - empty lattice
    public WordLattice(){
        wordHSet = new ArrayList<WordH>();
    }

    /**
    * latticeFromFile
    * reads a word lattice from file
    * file iterates word, start, end, logProb
    * until word is "done"
    * @param fname - the file name
    */
    public void latticeFromFile(String fname){
        EasyReader rdr = new EasyReader(fname);
        String c1 = rdr.readString();
        while(c1.compareTo("done") != 0){
            wordHSet.add(new WordH(c1, rdr.readInt(), rdr.readInt(), rdr.readInt()));
            c1 = rdr.readString();
        }
        findEndTime();
    }

    // find all words starting at a given time
    public ArrayList<WordH> wordsAtT(int t){
        ArrayList<WordH> wordsFound = new ArrayList<WordH>();
        for(WordH wh : wordHSet){
            if(wh.getStart() == t)
                wordsFound.add(wh);
        }
        return wordsFound;
    }

    // find the lattice end time
    private void findEndTime(){
        endTime = 0;
        for(WordH wh : wordHSet){
            if(wh.getEnd() > endTime)
                endTime = wh.getEnd();
        }
    }

    // toString
    public String toString(){
        StringBuffer buf = new StringBuffer("WORD LATTICE\n");
        for (WordH wh : wordHSet){
            String wstr = wh.toString();
            buf.append(wstr + "\n");
        }
        return buf.toString();
    }
}









