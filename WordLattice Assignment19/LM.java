/**
 * LM.java
 *
 * a bigram language model
 * consisting of
 *    vocab - String Array
 *    costMatrix [i][j] element is cost of word j following word i
 *
 * @author <a href="mailto: "Phil Green</a>
 * 2013
 */

import sheffield.*;
import java.util.*;

public class LM{

    private String[] vocab; // vocabulary
    private int[][] costMatrix; // costs
    private int vsize; // number of words in vocab

    // constructor - given vocab & costMatrix
    public LM(String[] v, int[][] c){
       vocab = v;
       costMatrix = c;
       vsize = vocab.length;
    }

    // find the cost for given word pair
    // assumes initial state has *start* as its 'word'
    // no error checking!

    public int getCost(String w1, String w2) {
        int i = 0;
        int j = 0;
        boolean found = false;

        // first word - cost is 0
        if(w1.equals("*start*")){
            return 0;
        }

        //find indices in vocab of w1 and w2
        while(i < vsize && !found){
       	    if(vocab[i].equals(w1)){
                found = true;
            }
            else{
                i = i + 1;
            }
       	}

        found = false;
        while(j < vsize && !found){
       	    if(vocab[j].equals(w2)){
                found = true;
            }
            else{
                j = j + 1;
            }
       	}

        return (costMatrix[i][j]);
    }

}