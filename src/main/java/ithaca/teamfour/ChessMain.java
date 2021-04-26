package ithaca.teamfour;

import com.github.bhlangonijr.chesslib.Board;

import ithaca.teamfour.player.HumanPlayer;
import ithaca.teamfour.player.RandomPlayer;
import ithaca.teamfour.player.SetBeginAgent;
import ithaca.teamfour.player.SimpleReflexAgent;
import ithaca.teamfour.player.SearchBasedAgent;

public class ChessMain {
    public static void main(String[] args){
    /** 
    // Load a FEN position into the chessboard
    String fen = "rnbqkbnr/pppppppp/8/8/4P3/8/PPPP1PPP/RNBQKBNR b KQkq e3 0 1";
    Board board = new Board();

    board.loadFromFen(fen);
    
    //Find the square locations of black bishops
    List<Square> blackBishopSquares = board.getPieceLocation(Piece.BLACK_BISHOP);

    //Get the piece at A1 square...
    Piece piece = board.getPiece(Square.A1);
    System.out.println(board.toString());

    board.movePiece(new Move(Square.A7, Square.A6), new MoveBackup());
    System.out.println(board.toString());

    board.movePiece(new Move(Square.D7, Square.D5), new MoveBackup());
    System.out.println(board.toString());
    board.movePiece(new Move(Square.E4, Square.D5), new MoveBackup());
    System.out.println(board.toString());
    */

    //ChessGame game = new ChessGame(new Board(), new RandomPlayer(), new SimpleReflexAgent());
    //ChessGame game = new ChessGame(new Board(), new SetBeginAgent(), new SimpleReflexAgent());
    //ChessGame game = new ChessGame(new Board(), new HumanPlayer(), new SimpleReflexAgent());
    // for(int i = 0; i < 20; i++){
    //     ChessGame game = new ChessGame(new Board(), new SearchBasedAgent(3), new SearchBasedAgent(3));
    //     game.play();
    // }
    ChessGame game = new ChessGame(new Board(), new SearchBasedAgent(3), new SearchBasedAgent(3));
    game.play();

    }
}
