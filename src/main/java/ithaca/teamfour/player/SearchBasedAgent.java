package ithaca.teamfour.player;

import java.util.ArrayList;
import java.util.List;

import com.github.bhlangonijr.chesslib.Board;
import com.github.bhlangonijr.chesslib.Piece;
import com.github.bhlangonijr.chesslib.move.Move;

import ithaca.teamfour.ChessGame;

public class SearchBasedAgent implements ChessPlayer {
    
    public class ScoreLoc{
        private int score;
        private Move location;
        public ScoreLoc(int score, Move location){
            this.score = score;
            this.location = location;
        }
        public int getScore(){
            return score;
        }
        public Move getLocation(){
            return location;
        }
    }
    private int depthSize;
    public SearchBasedAgent(int depthSize){
        this.depthSize = depthSize;
    }
    @Override
    public Move chooseMove(Board curBoard, char yourSymbol) {
        return chooseMove(curBoard, yourSymbol, depthSize);
    }
    
    
    
    public Move chooseMove(Board curBoard, char yourSymbol, int depthSize) {
        List<ScoreLoc> scoreLocationList = new ArrayList<>();
        List<Move> allValidMoves = ChessGame.getValidMoves(curBoard, yourSymbol);
        
        if(allValidMoves.isEmpty()){
            return null;
        }

        for(int i = 0; i < allValidMoves.size(); i++){
            int scoreForMove = calcScoreForMove(curBoard, yourSymbol, allValidMoves.get(i), yourSymbol, depthSize);
            scoreLocationList.add(new ScoreLoc(scoreForMove, allValidMoves.get(i)));
        }

        Move bestMoveMax = scoreLocationList.get(0).getLocation();
        int bestScoreMax = scoreLocationList.get(0).getScore();
        for(int i = 1; i < scoreLocationList.size(); i++){
            
            if(bestScoreMax < scoreLocationList.get(i).getScore()){
                bestScoreMax = scoreLocationList.get(i).getScore();
                bestMoveMax = scoreLocationList.get(i).getLocation();
            }
        }
        //System.out.println(curBoard.toString());
       
        return bestMoveMax;
    }

    public int calcScoreForMove(Board curBoard, char curSymbolToMove, Move moveIn, char yourSymbol, int depthSize){
        Board tempBoard = curBoard.clone();
        Piece capturedPiece = tempBoard.getPiece(moveIn.getTo()); //If the location moving to has a piece
        tempBoard.doMove(moveIn);
        
        if(tempBoard.isMated() && curSymbolToMove != yourSymbol){ //Check mate not by you
            return -2;
        }else if(tempBoard.isMated() && curSymbolToMove == yourSymbol){ //Check mate by you
            return 3;
        }
        else if(tempBoard.isKingAttacked() && curSymbolToMove != yourSymbol){ //King in check not you
            return -1;
        }
        else if(tempBoard.isKingAttacked() && curSymbolToMove == yourSymbol){ //King in check by you
            return 2;
        }
        else if(capturedPiece != Piece.NONE && !tempBoard.isDraw()){ //Capture any piece
            return 1;
        }
        else if(tempBoard.isDraw()){
            return -3;
        }else if(depthSize == 1) {
            return 0;
        }
        
        depthSize--;
        return calcScoreForMove(tempBoard, getOpposingSymbol(curSymbolToMove), chooseMove(tempBoard, getOpposingSymbol(curSymbolToMove), depthSize), yourSymbol, depthSize);
    }

    public static char getOpposingSymbol(char aSymbol){
        if(aSymbol == 'W'){
            return 'B';
        }else if( aSymbol == 'B'){
            return 'W';
        }else {
            throw new IllegalArgumentException("Bad symbol given: " + aSymbol);
        }
    }
    
}
