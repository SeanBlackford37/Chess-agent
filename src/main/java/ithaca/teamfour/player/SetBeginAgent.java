package ithaca.teamfour.player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.github.bhlangonijr.chesslib.Board;
import com.github.bhlangonijr.chesslib.Square;
import com.github.bhlangonijr.chesslib.move.Move;

import ithaca.teamfour.ChessGame;

public class SetBeginAgent implements ChessPlayer{
    private int moveCount;
    private int setIndex;
    private List<List<String>> tatics;
    private static Random random = new Random();

    public SetBeginAgent(){
        moveCount = 0;
        tatics = new ArrayList<>();
        setIndex = 0;       

    }

    public Move chooseMove(Board curBoard, char yourSymbol){
        List<Move> allValidMoves = ChessGame.getValidMoves(curBoard, yourSymbol);
        if (allValidMoves.isEmpty()){
            return null;
        }
        else{
            if (moveCount == 0){
                if (yourSymbol == 'W'){
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
            if (moveCount < tatics.get(setIndex).size()){
                Move temp = readAndVerifyCoords(tatics.get(setIndex).get(moveCount));
                if (allValidMoves.contains(temp)){
                    moveCount ++;
                    return temp;
                }
                else{
                    //if cant do specific open move
                    return null;
                }
            }
            else{
                //if cant do opener move at all
                
                return null;
            }
        }
    }

    public static Move readAndVerifyCoords(String coordString){
        String[] coords = coordString.split(",");
        Square to;
        Square from;
        try{
            to = Square.fromValue(coords[0].toUpperCase());
            from= Square.fromValue(coords[1].toUpperCase());

        }
        catch(Exception e){
            return null;
        }

        return (new Move(to,from));
    }
    
    
}
