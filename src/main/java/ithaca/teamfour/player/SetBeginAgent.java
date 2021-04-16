package ithaca.teamfour.player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.github.bhlangonijr.chesslib.Board;
import com.github.bhlangonijr.chesslib.move.Move;

public class SetBeginAgent implements ChessPlayer{
    private int moveCount;
    private int setIndex;
    private List<List<String>> tatics;
    private static Random random = new Random();

    public SetBeginAgent(char symbol){
        moveCount = 0;
        tatics = new ArrayList<>();
        if (symbol == 'W'){
            List<String> berlinDefense= new ArrayList<>();
            berlinDefense.add("E2,E4");
            berlinDefense.add("G1,F3");
            berlinDefense.add("F1,B5");
            tatics.add(berlinDefense);

            List<String> albinCounterGambit= new ArrayList<>();
            albinCounterGambit.add("D2,D4");
            albinCounterGambit.add("E2,E4");
            albinCounterGambit.add("D4,D5");
            tatics.add(albinCounterGambit);

            List<String> budapestGambit= new ArrayList<>();
            budapestGambit.add("E2,E4");
            budapestGambit.add("G1,F3");
            budapestGambit.add("F3,G5");
            tatics.add(budapestGambit);

            List<String> queensGambit= new ArrayList<>();
            queensGambit.add("E2,E4");
            queensGambit.add("F2,F4");
            tatics.add(queensGambit);
        }
        else{
            List<String> albinCounterGambit= new ArrayList<>();
            albinCounterGambit.add("D7,D5");
            albinCounterGambit.add("E7,E5");
            albinCounterGambit.add("D5,D4");
            tatics.add(albinCounterGambit);

            List<String> budapestGambit= new ArrayList<>();
            budapestGambit.add("E7,E5");
            budapestGambit.add("G8,F6");
            budapestGambit.add("F6,G4");
            tatics.add(budapestGambit);

            List<String> queensGambit= new ArrayList<>();
            queensGambit.add("E7,E5");
            queensGambit.add("F7,F5");
            tatics.add(queensGambit);
        }
        
        setIndex = random.nextInt(tatics.size());

    }

    public Move chooseMove(Board curBoard, char yourSymbol){
        //TODO
        return null;
    }
    
    
}
