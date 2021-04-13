package ithaca.teamfour.chesslib.playGame;

import java.util.List;
import java.util.Random;

import ithaca.teamfour.chesslib.Board;
import ithaca.teamfour.chesslib.move.Move;


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
    

