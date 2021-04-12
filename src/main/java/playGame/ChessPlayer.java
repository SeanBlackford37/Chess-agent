package playGame;

import com.github.bhlangonijr.chesslib.Board;
import com.github.bhlangonijr.chesslib.move.Move;

public interface ChessPlayer {
    /**
     * @param curBoard a copy of the current board for the player to use to choose a square
     * @param yourSymbol the symbol of the player that needs to choose a square
     * @throws IllegalArgumentException if there is no available squares to choose
     * @return a Pair of (x,y) coordinates representing the square chosen
     */
    public Move chooseMove(Board curBoard, char yourSymbol);
    
}



