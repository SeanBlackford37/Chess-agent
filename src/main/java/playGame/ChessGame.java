package playGame;

import java.util.List;
import java.util.Random;

import com.github.bhlangonijr.chesslib.Board;
import com.github.bhlangonijr.chesslib.move.Move;

public class ChessGame {
   
        private static Random random = new Random();
    
        private Board board;
        private ChessPlayer WPlayer;
        private ChessPlayer BPlayer;
        private char turn;
    
        public ChessGame(Board board, ChessPlayer WPlayer, ChessPlayer BPlayer){
            this.board = board;
            this.WPlayer = WPlayer;
            this.BPlayer = BPlayer;
            
            if (random.nextInt(2) == 1){
                turn = 'W';
            }
            else {
                turn='B';
            }
        }
    

        public void play(){
            while (!board.isKingAttacked() || !board.isDraw() || !board.isStaleMate()){
                System.out.println(board.toString());
                takeTurn();
            }
            System.out.println(board.toString());
        }
    
        public boolean takeTurn(){
            if (turn == 'W'){
                boolean turnTaken = makeMove(WPlayer, turn);
                turn = 'B';
                return turnTaken;
            }
            else if (turn == 'B'){
                boolean turnTaken = makeMove(BPlayer, turn);
                turn = 'W';
                return turnTaken;
            }
            else {
                throw new RuntimeException("Bad value for turn:"  + turn);
            }
        }
    
        private boolean makeMove(ChessPlayer player, char symbol){
            List<Move> allValidMoves = board.legalMoves();
            if (allValidMoves.size() > 0){
                Move square = player.chooseMove(board, symbol);
                if(allValidMoves.contains(square)){
                    board.doMove(square);
                    return true;
                }
                else {
                    return false;
                }
            }
            else {
                return false;
            }
        }
    
    }
    

