import java.util.*;

public class LatticeState extends SearchState{

    // word for this state
    private WordH wordH;

    // constructor
    public LatticeState(WordH wordH, int lc){
        this.wordH = wordH;
        localCost = lc;
    }

    // accessor
    public WordH getWordH(){
        return wordH;
    }

    // goalP
    public boolean goalP(Search searcher){
        LatticeSearch lsearcher = (LatticeSearch)searcher;
        int tar = lsearcher.getGoal(); // get target city
        return (wordH.getEnd() == tar);
    }

    // getSuccessors
    public ArrayList<SearchState> getSuccessors (Search searcher){
        LatticeSearch lsearcher = (LatticeSearch)searcher;
        WordLattice latt = lsearcher.getWordLattice();
        LM lm = lsearcher.getLM();

        ArrayList<WordH> words = latt.wordsAtT(wordH.getEnd());
        ArrayList<SearchState> succs = new ArrayList<SearchState>();

        for (WordH w : words){
            int cost = w.getCost() + lm.getCost(wordH.getWord(), w.getWord());
            succs.add((SearchState)new LatticeState(w, cost));
        }
        return succs;
    }

    // sameState
    public boolean sameState(SearchState s2){
        LatticeState ls2 = (LatticeState)s2;
        return (wordH.getWord().compareTo(ls2.getWordH().getWord()) == 0);
    }

    // toString
    public String toString() {
        return ("Lattice State: " + wordH.getWord());
    }

    public static void main(String[] args) {
        // Create samples
        WordLattice latt = new WordLattice();
        latt.latticeFromFile("latt1.txt");
        String [] vocab = {"please", "lettuce", "know", "flea", "use", "throw", "freeze", "let", "useless", "us"};
        int [][] costs = {{500, 100,  80, 120,  20,  40,  60,  20, 120,  30},
                          { 50, 500, 100, 120,  90,  60,  90,  70, 110, 120},
                          { 50,  80, 500,  90, 100,  80,  70,  80, 100,  40},
                          { 60, 120, 110, 500, 100,  90,  80,  60, 100, 100},
                          { 30,  70,  80,  90, 500,  50, 100,  70,  90,  40},
                          { 50,  60,  90,  80,  80, 500, 120,  90, 100,  40},
                          { 60,  80, 120, 100, 110, 100, 500,  70, 120,  70},
                          { 70,  50,  70,  60,  40,  80,  90, 500,  90,  20},
                          {100,  90,  80,  60,  80,  40,  90,  80, 500,  90},
                          { 20, 100,  60, 100,  70,  60,  80,  40,  90, 500}};
        LM bg = new LM(vocab, costs);
        LatticeSearch lsearch = new LatticeSearch(latt, bg);

        SearchState sample1 = (SearchState)new LatticeState(new WordH("A", 0, 10, 5), 0);
        SearchState sample2 = (SearchState)new LatticeState(new WordH("A", 0, 10, 5), 0);
        SearchState sample3 = (SearchState)new LatticeState(new WordH("B", 10, 36, 15), 10);


        System.out.println("Identical states: " + sample1.sameState(sample2));
        System.out.println("Different states: " + sample1.sameState(sample3));
        System.out.println("A goal state: " + sample3.goalP(lsearch));
        System.out.println("A non-goal state: " + sample1.goalP(lsearch));
    }

}
