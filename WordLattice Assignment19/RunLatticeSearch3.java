 /**
   * RunLatticeSearch.java
   *
   * @author <a href="mailto: "Phil Green</a>
   * 2019 version
   *
   * run a word lattice search
   *
 */

import sheffield.*;
import java.util.*;

public class RunLatticeSearch3{

    public static void main(String[] arg){
        // create an EasyWriter
        EasyWriter screen = new EasyWriter();
        // create a WordLattice
        WordLattice latt = new WordLattice();
        // download the word lattice data from file
        latt.latticeFromFile("latt3.txt");

        // LM2
        String [] tVocab= {"TV","radio","channel","volume","up","down","on","off","record","playback",
                   "one","two","three","four","five","six","seven","eight","nine"};
        int [][] tCosts ={
         {500,  200,   20,   25,  100,   80,   30,   30,   70,   90,  150,  140,  150,  145,   55,  140,  160,  110,  120},
         {180,  500,   25,   15,  100,  120,   35,   30,   100,  100,  80,   70,   90,   50,   60,   90,   80,  100,  120},
         {200,  150,  500,  150,   40,   40,  110,  120,   70,   60,   30,   30,   40,   20,   30,   60,   60,   70,   60},
         {150,  120,  180,  500,   30,   40,  100,  120,   80,   90,  100,   90,   80,  110,   90,  120,  130,   80,   70},
         {150,  160,   90,   80,  500,   90,  200,  180,  100,   90,  120,  130,  100,  140,  120,  110,  120,  150,  160},
         {140,  140,   80,   90,  200,  500,  170,  180,   70,   90,   70,   80,   90,   70,   90,   60,   80,   70,  100},
         { 90,   80,  120,  130,  220,  300,  500,  100,   80,   70,  120,  110,  130,  140,  120,  130,  120,  110,  150},
         { 80,   90,  130,  120,  200,  180,  170,  500,   70,   80,  130,  120,  140,  150,  100,  120,  110,  140,  130},
         { 40,   60,   30,  100,   60,   80,   50,   60,  500,  200,   90,   80,   70,   80,   90,   70,   60,  100,   90},
         { 50,   70,   40,  120,  140,  150,  100,  110,  200,  500,  100,   80,   90,   70,  100,   80,   70,  110,   80},
         {120,  140,   90,  130,  140,   90,  200,  120,   90,   80,  110,  110,  110,  110,  110,  110,  110,  110,  110},
         {130,  130,   80,  140,  150,   80,  180,  170,  100,  110,  110,  110,  110,  110,  110,  110,  110,  110,  110},
         {130,  130,   80,  140,  150,   80,  180,  170,  100,  110,  110,  110,  110,  110,  110,  110,  110,  110,  110},
         {130,  130,   80,  140,  150,   80,  180,  170,  100,  110,  110,  110,  110,  110,  110,  110,  110,  110,  110},
         {130,  130,   80,  140,  150,   80,  180,  170,  100,  110,  110,  110,  110,  110,  110,  110,  110,  110,  110},
         {130,  130,   80,  140,  150,   80,  180,  170,  100,  110,  110,  110,  110,  110,  110,  110,  110,  110,  110},
         {130,  130,   80,  140,  150,   80,  180,  170,  100,  110,  110,  110,  110,  110,  110,  110,  110,  110,  110},
         {130,  130,   80,  140,  150,   80,  180,  170,  100,  110,  110,  110,  110,  110,  110,  110,  110,  110,  110},
         {130,  130,   80,  140,  150,   80,  180,  170,  100,  110,  110,  110,  110,  110,  110,  110,  110,  110,  110}};

        // Sample2
        LM bg = new LM(tVocab, tCosts);
        LatticeSearch lsearch = new LatticeSearch(latt, bg);
        SearchState initState = (SearchState)new LatticeState(new WordH("*start*", 0, 0, 0), 0);

        String res_df = lsearch.runSearch(initState, "depthFirst");
        screen.println(res_df);
        screen.println("################################");
        String res_bf = lsearch.runSearch(initState, "breadthFirst");
        screen.println(res_bf);
        screen.println("################################");
        String res_bb = lsearch.runSearch(initState, "branchAndBound");
        screen.println(res_bb);
    }
}
