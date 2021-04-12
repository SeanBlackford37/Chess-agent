package playGame;

import java.util.Scanner;

import com.github.bhlangonijr.chesslib.Board;
import com.github.bhlangonijr.chesslib.Square;
import com.github.bhlangonijr.chesslib.move.Move;

public class HumanPlayer implements ChessPlayer{
    private Scanner keyboard = new Scanner(System.in);

    public Move chooseMove(Board curBoard, char yourSymbol){
        System.out.print(yourSymbol + ", enter coorinates for your next move x,y:");
            String coordString = keyboard.nextLine();
            while (readAndVerifyCoords(coordString) == null){
                System.out.print("bad coordinates, try again, format x,y:");
                coordString = keyboard.nextLine();
            }
            return readAndVerifyCoords(coordString);
        
        
    }

    public static Move readAndVerifyCoords(String coordString){
        //TODO: needs error checking, shoud return null if input is invalid
        String[] coords = coordString.split(",");
        
        Square to;
        Square from;
        if (coords[0].equals("A1")){
            to = Square.A1;
        }
        else if(coords[0].equals("A2")){
            to = Square.A2;
        }
        else if(coords[0].equals("A3")){
            to = Square.A3;
        }
        else if(coords[0].equals("A4")){
            to = Square.A4;
        }
        else if(coords[0].equals("A5")){
            to = Square.A5;
        }
        else if(coords[0].equals("A6")){
            to = Square.A6;
        }
        else if(coords[0].equals("A7")){
            to = Square.A7;
        }
        else if(coords[0].equals("A8")){
            to = Square.A8;
        }

        //B
        if (coords[0].equals("B1")){
            to = Square.B1;
        }
        else if(coords[0].equals("B2")){
            to = Square.B2;
        }
        else if(coords[0].equals("B3")){
            to = Square.B3;
        }
        else if(coords[0].equals("B4")){
            to = Square.B4;
        }
        else if(coords[0].equals("A5")){
            to = Square.A5;
        }
        else if(coords[0].equals("A6")){
            to = Square.A6;
        }
        else if(coords[0].equals("A7")){
            to = Square.A7;
        }
        else if(coords[0].equals("A8")){
            to = Square.A8;
        }


        return new Move(to,from);
    }
    
}
