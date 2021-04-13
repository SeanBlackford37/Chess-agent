package ithaca.teamfour.chesslib.playGame;

import java.util.List;
import java.util.Random;



import ithaca.teamfour.chesslib.Board;
import ithaca.teamfour.chesslib.move.Move;

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
