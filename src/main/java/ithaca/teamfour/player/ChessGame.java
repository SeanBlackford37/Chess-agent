package ithaca.teamfour.player;

import java.util.ArrayList;
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
            turn = 'W';
            
            if (random.nextInt(2) == 1){
                this.WPlayer = WPlayer;
                this.BPlayer = BPlayer;
            }
            else {
                this.WPlayer = BPlayer;
                this.BPlayer = WPlayer;
            }
        }
    

        public void play(){
            while (!board.isMated() && !board.isDraw() && !board.isStaleMate()){
                
                System.out.println(board.toString());
                takeTurn();
            }

            System.out.println(board.toString());
            if (board.isStaleMate()){
                System.out.println("Stalemate!");
            }
            else if(board.isDraw()){
                System.out.println("Draw!");
            }
            else{
                if(turn == 'B'){
                    turn = 'W';
                }
                else{
                    turn = 'B';
                }
                System.out.println("Checkmate!");
                System.out.println(turn + " wins");
            }
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
            if (!allValidMoves.isEmpty()){
                Move square = player.chooseMove(board.clone(), symbol);
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
    

