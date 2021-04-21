package ithaca.teamfour.player;

import java.util.List;
import java.util.Scanner;

import com.github.bhlangonijr.chesslib.Board;
import com.github.bhlangonijr.chesslib.Square;
import com.github.bhlangonijr.chesslib.move.Move;




public class HumanPlayer implements ChessPlayer{
    private Scanner keyboard = new Scanner(System.in);
    
    public Move chooseMove(Board curBoard, char yourSymbol){
        Move temp = null;
        int good = 0;
        //System.out.println(curBoard.legalMoves());
        while (good != 1){
        System.out.print(yourSymbol + ", enter coorinates for your next move x,y:");
            String coordString = keyboard.nextLine();
            while (readAndVerifyCoords(coordString, curBoard) == null){
                System.out.print("bad coordinates, try again, format x,y:");
                coordString = keyboard.nextLine();
            }
            
            temp = readAndVerifyCoords(coordString, curBoard);
        
            if (yourSymbol==('W')){
                if (curBoard.getPiece(temp.getFrom()).getPieceSide().toString().contains("WHITE")){
                    good = 1;
                } 
            }
            else if(curBoard.getPiece(temp.getFrom()).getPieceSide().toString().contains("BLACK")){
                good = 1;
            }
            else{
                System.out.println("Please move your own piece");
            }
        }
        return temp;
    }

    public static Move readAndVerifyCoords(String coordString, Board curBoard){
        String[] coords = coordString.split(",");
        Square to;
        Square from;
        Board tempBoard = curBoard.clone();
        try{
            to = Square.fromValue(coords[0].toUpperCase());
            from= Square.fromValue(coords[1].toUpperCase());
            tempBoard.doMove(new Move(to,from));

        }
        catch(Exception e){
            return null;
        }

        return (new Move(to,from));
    }
}
