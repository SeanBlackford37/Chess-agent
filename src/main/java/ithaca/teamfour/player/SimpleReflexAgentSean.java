package ithaca.teamfour.player;

import java.util.List;
import java.util.Random;

import com.github.bhlangonijr.chesslib.Board;
import com.github.bhlangonijr.chesslib.Piece;
import com.github.bhlangonijr.chesslib.move.Move;

public class SimpleReflexAgentSean implements ChessPlayer {
    private static Random random = new Random();

    public Move chooseMove(Board curBoard, char yourSymbol){
        
        Move randMove = null;
        List<Move> allValidMoves = curBoard.legalMoves();
        if (allValidMoves.isEmpty()){
            return null;
        }else{
            int good = 0;
        
        String yourSide ="";
        if(yourSymbol == 'W'){
            yourSide = "WHITE";
        }else if(yourSymbol == 'B'){
            yourSide = "BLACK";
        }
       
        for(int i = 0; i < allValidMoves.size();i++){
            Board copyBoard = curBoard.clone();
            if(copyBoard.getPiece(allValidMoves.get(i).getFrom()).getPieceSide().toString().equalsIgnoreCase(yourSide)){
                Piece capturedPiece = copyBoard.getPiece(allValidMoves.get(i).getTo());
                
                copyBoard.doMove(allValidMoves.get(i));
                
                if(copyBoard.isMated()){
                    return allValidMoves.get(i);
                }else if(copyBoard.isKingAttacked()){
                    return allValidMoves.get(i);
                }
                else if(capturedPiece != Piece.NONE && !copyBoard.isDraw()){
                    return allValidMoves.get(i);
                }
            }
        }
            
        //Will only go to this while loop if all valid moves can't take a piece
        while (good != 1){
            int index = random.nextInt(allValidMoves.size());
            randMove = allValidMoves.get(index);
            
            if (curBoard.getPiece(randMove.getFrom()).getPieceSide().toString().equalsIgnoreCase(yourSide)){
                    good = 1;
            } 
        }
        return (randMove);
        }
    }
}   

