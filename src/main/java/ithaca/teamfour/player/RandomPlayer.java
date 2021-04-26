package ithaca.teamfour.player;

import java.util.List;
import java.util.Random;
import com.github.bhlangonijr.chesslib.Board;
import com.github.bhlangonijr.chesslib.move.Move;

import ithaca.teamfour.ChessGame;


public class RandomPlayer implements ChessPlayer{
    private static Random random = new Random();

    public Move chooseMove(Board curBoard, char yourSymbol){
        Move randMove = null;
        List<Move> allValidMoves = ChessGame.getValidMoves(curBoard, yourSymbol);
        if (allValidMoves.isEmpty()){
            return null;
        }
        else{
            
            int index = random.nextInt(allValidMoves.size());
            randMove = allValidMoves.get(index);
            return (randMove);
        }
        
    }
    
}
