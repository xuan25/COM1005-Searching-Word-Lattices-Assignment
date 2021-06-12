import java.util.*;

public class LatticeSearch extends Search{

    private WordLattice latt; // word lattice we're searching
    private LM lm; // lm

    public WordLattice getWordLattice(){
        return latt;
    }

    public LM getLM(){
        return lm;
    }

    public int getGoal(){
        return latt.getEndTime();
    }

    public LatticeSearch(WordLattice latt, LM lm){
        this.latt = latt;
        this.lm = lm;
    }

    public static void main(String[] args) {
        // Create a sample
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

        // Testting
        System.out.println("--------");
        System.out.println(lsearch.getWordLattice());
        System.out.println("--------");
        LM lm = lsearch.getLM();
        for(String row : vocab){
            for(String col : vocab){
                System.out.print(lm.getCost(row, col) + ", ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("--------");
        System.out.println("Goal: " + lsearch.getGoal());
    }

}