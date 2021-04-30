package ithaca.teamfour.player;

import java.util.ArrayList;
import java.util.List;

import com.github.bhlangonijr.chesslib.Board;
import com.github.bhlangonijr.chesslib.Piece;
import com.github.bhlangonijr.chesslib.move.Move;

import ithaca.teamfour.ChessGame;

public class WorseSearchBasedAgent implements ChessPlayer {
    
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
    public WorseSearchBasedAgent(int depthSize){
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
        try{
            tempBoard.doMove(moveIn);
        }
        catch(Exception e){
            return -20;
        }
        int yourPiece = 0;
        int opponentPiece =0;
        Piece board[] = tempBoard.boardToArray();
        for (int i=0; i < 64; i++){
            if (yourSymbol == 'W' && board[i].toString().equals(board[i].toString().toUpperCase())){
                yourPiece++;
            }
            else if (yourSymbol == 'B' && board[i].toString().equals(board[i].toString().toUpperCase())){
                opponentPiece ++;
            }
            else if (yourSymbol == 'B' && board[i].toString().equals(board[i].toString().toLowerCase())){
                yourPiece ++;
            }
            else if (yourSymbol == 'W' && board[i].toString().equals(board[i].toString().toLowerCase())){
                opponentPiece ++;
            }
            
        }
        if(depthSize == 1) {
            return yourPiece-opponentPiece;
        }
    
        
        depthSize--;
        return calcScoreForMove(tempBoard.clone(), getOpposingSymbol(curSymbolToMove), chooseMove(tempBoard.clone(), getOpposingSymbol(curSymbolToMove), depthSize), yourSymbol, depthSize);
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
