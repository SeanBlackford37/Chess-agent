package ithaca.teamfour.player;

import java.util.List;
import java.util.Scanner;

import com.github.bhlangonijr.chesslib.Board;
import com.github.bhlangonijr.chesslib.Square;
import com.github.bhlangonijr.chesslib.move.Move;




public class HumanPlayer implements ChessPlayer{
    private Scanner keyboard = new Scanner(System.in);
    
    public Move chooseMove(Board curBoard, char yourSymbol){
        String locFrom = "from";
        System.out.println("Location from: ");
        locFrom = keyboard.nextLine();
        String locTo = "to";
        System.out.println("Location to: ");
        locTo = keyboard.nextLine();
        return new Move( Square.fromValue(locFrom.toUpperCase()),  Square.fromValue(locTo.toUpperCase()));
    }
}
