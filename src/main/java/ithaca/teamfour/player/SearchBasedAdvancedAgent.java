package ithaca.teamfour.player;

import java.util.ArrayList;
import java.util.List;

import com.github.bhlangonijr.chesslib.Board;
import com.github.bhlangonijr.chesslib.Piece;
import com.github.bhlangonijr.chesslib.move.Move;

import ithaca.teamfour.ChessGame;

public class SearchBasedAdvancedAgent implements ChessPlayer {
    
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
    public SearchBasedAdvancedAgent(int depthSize){
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
            //System.out.println(scoreLocationList.get(i).getScore());
            if(bestScoreMax < scoreLocationList.get(i).getScore()){
                bestScoreMax = scoreLocationList.get(i).getScore();
                bestMoveMax = scoreLocationList.get(i).getLocation();
            }
        }
        
       
        return bestMoveMax;
    }

    public int calcScoreForMove(Board curBoard, char curSymbolToMove, Move moveIn, char yourSymbol, int depthSize){
        Board tempBoard = curBoard.clone();
        Piece capturedPiece = tempBoard.getPiece(moveIn.getTo()); //If the location moving to has a piece
        tempBoard.doMove(moveIn);
        
        if(tempBoard.isMated() && curSymbolToMove != yourSymbol){ //Check mate not by you
            return -3;
        }
        else if(tempBoard.isMated() && curSymbolToMove == yourSymbol){ //Check mate by you
            return 11;
        }
        else if(tempBoard.isKingAttacked() && curSymbolToMove != yourSymbol){ //King in check not you
            return -1;
        }
        else if(tempBoard.isKingAttacked() && curSymbolToMove == yourSymbol){ //King in check by you
            return 10;
        }
        else if(capturedPiece != Piece.NONE){ //Capture any piece
            return pieceCaptureEval(curBoard, moveIn);
            //return 1;
        }
        else if(tempBoard.isDraw()){
            return -2;
        }
        else if(depthSize == 1) { //if the depth count reaches one
            return 0;
        }
        
        depthSize--;
        return calcScoreForMove(tempBoard, getOpposingSymbol(curSymbolToMove), chooseMove(tempBoard, getOpposingSymbol(curSymbolToMove), depthSize), yourSymbol, depthSize);
    }


    public int pieceCaptureEval(Board curBoard, Move moveIn){
        Piece curPiece = curBoard.getPiece(moveIn.getFrom()); 
        Piece capturedPiece = curBoard.getPiece(moveIn.getTo());
        int curPieceWeight = 0;
        int capturedPieceWeight = 0;
        if(capturedPiece != Piece.NONE){
            if(curPiece.equals(Piece.WHITE_PAWN)  || curPiece .equals(Piece.BLACK_PAWN)){
                curPieceWeight =  1;
            
            }else if (curPiece.equals(Piece.WHITE_KNIGHT)  || curPiece.equals(Piece.BLACK_KNIGHT)){
                curPieceWeight = 3;

            }else if (curPiece.equals(Piece.WHITE_BISHOP) || curPiece.equals( Piece.BLACK_BISHOP)){
                curPieceWeight = 3;

            }else if (curPiece.equals(Piece.WHITE_ROOK) || curPiece.equals(Piece.BLACK_ROOK)){
                curPieceWeight = 5;

            }else if (curPiece.equals(Piece.WHITE_QUEEN) || curPiece.equals(Piece.BLACK_QUEEN)){
                curPieceWeight = 9;
                
            }

            if(capturedPiece.equals(Piece.WHITE_PAWN)  || capturedPiece.equals(Piece.BLACK_PAWN)){
                capturedPieceWeight = 1;

            }else if(capturedPiece.equals(Piece.WHITE_KNIGHT)  || capturedPiece.equals(Piece.BLACK_KNIGHT)){
                capturedPieceWeight = 3;

            }else if(capturedPiece.equals(Piece.WHITE_BISHOP)  || capturedPiece.equals(Piece.BLACK_BISHOP)){
                capturedPieceWeight = 3;

            }else if(capturedPiece.equals(Piece.WHITE_ROOK)  || capturedPiece.equals(Piece.BLACK_ROOK)){
                capturedPieceWeight = 5;
            
            }else if(capturedPiece.equals(Piece.WHITE_QUEEN)  || capturedPiece.equals(Piece.BLACK_QUEEN)){
                capturedPieceWeight = 9;
            }
        }
        
        
        return capturedPieceWeight;
        // if(curPieceWeight <= capturedPieceWeight){
        //     return curPieceWeight;
        // }else{
        //     return -3;
        // }
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
