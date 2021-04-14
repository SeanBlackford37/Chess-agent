package ithaca.teamfour.player;

import java.util.List;
import java.util.Random;

import com.github.bhlangonijr.chesslib.Board;
import com.github.bhlangonijr.chesslib.move.Move;





public class RandomPlayer implements ChessPlayer{
    private static Random random = new Random();

    public Move chooseMove(Board curBoard, char yourSymbol){
        List<Move> allValidMoves = curBoard.legalMoves();
        if (allValidMoves.isEmpty()){
            return null;
        }
        else{
            int index = random.nextInt(allValidMoves.size());
            return (allValidMoves.get(index));
        }
        
    }
    
}
