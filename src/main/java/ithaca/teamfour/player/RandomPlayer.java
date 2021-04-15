package ithaca.teamfour.player;

import java.util.List;
import java.util.Random;

import com.github.bhlangonijr.chesslib.Board;
import com.github.bhlangonijr.chesslib.move.Move;





public class RandomPlayer implements ChessPlayer{
    private static Random random = new Random();

    public Move chooseMove(Board curBoard, char yourSymbol){
        Move randMove = null;
        List<Move> allValidMoves = curBoard.legalMoves();
        if (allValidMoves.isEmpty()){
            return null;
        }
        else{
            int good = 0;
            
            while (good != 1){
                int index = random.nextInt(allValidMoves.size());
                randMove = allValidMoves.get(index);
                
                if (yourSymbol==('W')){
                    if (curBoard.getPiece(randMove.getFrom()).getPieceSide().toString().contains("WHITE")){
                        good = 1;
                    } 
                }
                else if(curBoard.getPiece(randMove.getFrom()).getPieceSide().toString().contains("BLACK")){
                    good = 1;
                }
            }
            return (randMove);
        }
        
    }
    
}
