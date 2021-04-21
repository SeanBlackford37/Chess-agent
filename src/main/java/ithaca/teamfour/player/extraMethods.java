package ithaca.teamfour.player;
import java.util.ArrayList;
import java.util.List;

import com.github.bhlangonijr.chesslib.Board;
import com.github.bhlangonijr.chesslib.Square;
import com.github.bhlangonijr.chesslib.move.Move;

public class extraMethods {
    public static List<Move> getValidMoves(Board curBoard, char symbol){
        List<Move> allValidMoves = curBoard.legalMoves();
        List<Move> forPlayer = new ArrayList<>();
        for (int i =0; i< allValidMoves.size(); i++){
            if (symbol==('W')){
                if (curBoard.getPiece(allValidMoves.get(i).getFrom()).getPieceSide().toString().contains("WHITE")){
                    forPlayer.add(allValidMoves.get(i));
                } 
            }
            else if(curBoard.getPiece(allValidMoves.get(i).getFrom()).getPieceSide().toString().contains("BLACK")){
                forPlayer.add(allValidMoves.get(i));
            }
        }
        return forPlayer;

    }
    
}
