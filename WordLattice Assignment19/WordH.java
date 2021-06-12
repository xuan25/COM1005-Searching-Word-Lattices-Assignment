/**
 * WordH.java
 *
 * A word in a word lattice
 *
 * @author <a href="mailto: "Phil Green</a>
 * 2013
 */

public class WordH{

    private String word;
    private int st;
    private int end;
    private int cost; // the logprob

    // constructor
    public WordH(String w, int s, int e, int p){
        word=w;
        st =s;
        end=e;
        cost = p;
    }

    // accessors
    public String getWord(){
        return word;
    }

    public int getStart(){
        return st;
    }

    public int getEnd(){
        return end;
    }

    public int getCost(){
        return cost;
    }

    public String toString(){
        return word + " " + st + " " + end + " " + cost;
    }

}
