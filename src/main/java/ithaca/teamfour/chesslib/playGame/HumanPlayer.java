package ithaca.teamfour.chesslib.playGame;

import java.util.List;
import java.util.Scanner;

import ithaca.teamfour.chesslib.Board;
import ithaca.teamfour.chesslib.Square;
import ithaca.teamfour.chesslib.move.Move;


public class HumanPlayer implements ChessPlayer{
    private Scanner keyboard = new Scanner(System.in);
    
    public Move chooseMove(Board curBoard, char yourSymbol){
        System.out.print("Enter coorinates for your next move x,y:");
        String locFrom = "from";
        System.out.println("Location from: ");
        locFrom = keyboard.nextLine();
        String locTo = "to";
        System.out.println("Location to: ");
        locTo = keyboard.nextLine();
        return new Move( Square.fromValue(locFrom.toUpperCase()),  Square.fromValue(locTo.toUpperCase()));
    }
}
