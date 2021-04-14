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
            String coordString = keyboard.nextLine();
            while (readAndVerifyCoords(coordString) == null){
                System.out.print("bad coordinates, try again, format x,y:");
                coordString = keyboard.nextLine();
            }
            return readAndVerifyCoords(coordString);
    }

    public static Move readAndVerifyCoords(String coordString){
        String[] coords = coordString.split(",");
        
        Square to = null;
        Square from = null;

        //A
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
        else if(coords[0].equals("B5")){
            to = Square.B5;
        }
        else if(coords[0].equals("B6")){
            to = Square.B6;
        }
        else if(coords[0].equals("B7")){
            to = Square.B7;
        }
        else if(coords[0].equals("B8")){
            to = Square.B8;
        }

        //C
        if (coords[0].equals("C1")){
            to = Square.C1;
        }
        else if(coords[0].equals("C2")){
            to = Square.C2;
        }
        else if(coords[0].equals("C3")){
            to = Square.C3;
        }
        else if(coords[0].equals("C4")){
            to = Square.C4;
        }
        else if(coords[0].equals("C5")){
            to = Square.C5;
        }
        else if(coords[0].equals("C6")){
            to = Square.C6;
        }
        else if(coords[0].equals("C7")){
            to = Square.C7;
        }
        else if(coords[0].equals("C8")){
            to = Square.C8;
        }

        //D
        if (coords[0].equals("D1")){
            to = Square.D1;
        }
        else if(coords[0].equals("D2")){
            to = Square.D2;
        }
        else if(coords[0].equals("D3")){
            to = Square.D3;
        }
        else if(coords[0].equals("D4")){
            to = Square.D4;
        }
        else if(coords[0].equals("D5")){
            to = Square.D5;
        }
        else if(coords[0].equals("D6")){
            to = Square.D6;
        }
        else if(coords[0].equals("D7")){
            to = Square.D7;
        }
        else if(coords[0].equals("D8")){
            to = Square.D8;
        }

        //E
        if (coords[0].equals("E1")){
            to = Square.E1;
        }
        else if(coords[0].equals("E2")){
            to = Square.E2;
        }
        else if(coords[0].equals("E3")){
            to = Square.E3;
        }
        else if(coords[0].equals("E4")){
            to = Square.E4;
        }
        else if(coords[0].equals("E5")){
            to = Square.E5;
        }
        else if(coords[0].equals("E6")){
            to = Square.E6;
        }
        else if(coords[0].equals("E7")){
            to = Square.E7;
        }
        else if(coords[0].equals("E8")){
            to = Square.E8;
        }

        //F
        if (coords[0].equals("F1")){
            to = Square.F1;
        }
        else if(coords[0].equals("F2")){
            to = Square.F2;
        }
        else if(coords[0].equals("F3")){
            to = Square.F3;
        }
        else if(coords[0].equals("F4")){
            to = Square.F4;
        }
        else if(coords[0].equals("F5")){
            to = Square.F5;
        }
        else if(coords[0].equals("F6")){
            to = Square.F6;
        }
        else if(coords[0].equals("F7")){
            to = Square.F7;
        }
        else if(coords[0].equals("F8")){
            to = Square.F8;
        }

        //G
        if (coords[0].equals("G1")){
            to = Square.G1;
        }
        else if(coords[0].equals("G2")){
            to = Square.G2;
        }
        else if(coords[0].equals("G3")){
            to = Square.G3;
        }
        else if(coords[0].equals("G4")){
            to = Square.G4;
        }
        else if(coords[0].equals("G5")){
            to = Square.G5;
        }
        else if(coords[0].equals("G6")){
            to = Square.G6;
        }
        else if(coords[0].equals("G7")){
            to = Square.G7;
        }
        else if(coords[0].equals("G8")){
            to = Square.G8;
        }

        //H
        if (coords[0].equals("H1")){
            to = Square.H1;
        }
        else if(coords[0].equals("H2")){
            to = Square.H2;
        }
        else if(coords[0].equals("H3")){
            to = Square.H3;
        }
        else if(coords[0].equals("H4")){
            to = Square.H4;
        }
        else if(coords[0].equals("H5")){
            to = Square.H5;
        }
        else if(coords[0].equals("H6")){
            to = Square.H6;
        }
        else if(coords[0].equals("H7")){
            to = Square.H7;
        }
        else if(coords[0].equals("H8")){
            to = Square.H8;
        }

        //A
       if (coords[1].equals("A1")){
        from = Square.A1;
        }
        else if(coords[1].equals("A2")){
            from = Square.A2;
        }
        else if(coords[1].equals("A3")){
            from = Square.A3;
        }
        else if(coords[1].equals("A4")){
            from = Square.A4;
        }
        else if(coords[1].equals("A5")){
            from = Square.A5;
        }
        else if(coords[1].equals("A6")){
            from = Square.A6;
        }
        else if(coords[1].equals("A7")){
            from = Square.A7;
        }
        else if(coords[1].equals("A8")){
            from = Square.A8;
        }

        //B
        if (coords[1].equals("B1")){
            from = Square.B1;
        }
        else if(coords[1].equals("B2")){
            from = Square.B2;
        }
        else if(coords[1].equals("B3")){
            from = Square.B3;
        }
        else if(coords[1].equals("B4")){
            from = Square.B4;
        }
        else if(coords[1].equals("B5")){
            from = Square.B5;
        }
        else if(coords[1].equals("B6")){
            from = Square.B6;
        }
        else if(coords[1].equals("B7")){
            from = Square.B7;
        }
        else if(coords[1].equals("B8")){
            from = Square.B8;
        }

        //C
        if (coords[1].equals("C1")){
            from = Square.C1;
        }
        else if(coords[1].equals("C2")){
            from = Square.C2;
        }
        else if(coords[1].equals("C3")){
            from = Square.C3;
        }
        else if(coords[1].equals("C4")){
            from = Square.C4;
        }
        else if(coords[1].equals("C5")){
            from = Square.C5;
        }
        else if(coords[1].equals("C6")){
            from = Square.C6;
        }
        else if(coords[1].equals("C7")){
            from = Square.C7;
        }
        else if(coords[1].equals("C8")){
            from = Square.C8;
        }

        //D
        if (coords[1].equals("D1")){
            from = Square.D1;
        }
        else if(coords[1].equals("D2")){
            from = Square.D2;
        }
        else if(coords[1].equals("D3")){
            from = Square.D3;
        }
        else if(coords[1].equals("D4")){
            from = Square.D4;
        }
        else if(coords[1].equals("D5")){
            from = Square.D5;
        }
        else if(coords[1].equals("D6")){
            from = Square.D6;
        }
        else if(coords[1].equals("D7")){
            from = Square.D7;
        }
        else if(coords[1].equals("D8")){
            from = Square.D8;
        }

        //E
        if (coords[1].equals("E1")){
            from = Square.E1;
        }
        else if(coords[1].equals("E2")){
            from = Square.E2;
        }
        else if(coords[1].equals("E3")){
            from = Square.E3;
        }
        else if(coords[1].equals("E4")){
            from = Square.E4;
        }
        else if(coords[1].equals("E5")){
            from = Square.E5;
        }
        else if(coords[1].equals("E6")){
            from = Square.E6;
        }
        else if(coords[1].equals("E7")){
            from = Square.E7;
        }
        else if(coords[1].equals("E8")){
            from = Square.E8;
        }

        //F
        if (coords[1].equals("F1")){
            from = Square.F1;
        }
        else if(coords[1].equals("F2")){
            from = Square.F2;
        }
        else if(coords[1].equals("F3")){
            from = Square.F3;
        }
        else if(coords[1].equals("F4")){
            from = Square.F4;
        }
        else if(coords[1].equals("F5")){
            from = Square.F5;
        }
        else if(coords[1].equals("F6")){
            from = Square.F6;
        }
        else if(coords[1].equals("F7")){
            from = Square.F7;
        }
        else if(coords[1].equals("F8")){
            from = Square.F8;
        }

        //G
        if (coords[1].equals("G1")){
            from = Square.G1;
        }
        else if(coords[1].equals("G2")){
            from = Square.G2;
        }
        else if(coords[1].equals("G3")){
            from = Square.G3;
        }
        else if(coords[1].equals("G4")){
            from = Square.G4;
        }
        else if(coords[1].equals("G5")){
            from = Square.G5;
        }
        else if(coords[1].equals("G6")){
            from = Square.G6;
        }
        else if(coords[1].equals("G7")){
            from = Square.G7;
        }
        else if(coords[1].equals("G8")){
            from = Square.G8;
        }

        //H
        if (coords[1].equals("H1")){
            from = Square.H1;
        }
        else if(coords[1].equals("H2")){
            from = Square.H2;
        }
        else if(coords[1].equals("H3")){
            from = Square.H3;
        }
        else if(coords[1].equals("H4")){
            from = Square.H4;
        }
        else if(coords[1].equals("H5")){
            from = Square.H5;
        }
        else if(coords[1].equals("H6")){
            from = Square.H6;
        }
        else if(coords[1].equals("H7")){
            from = Square.H7;
        }
        else if(coords[1].equals("H8")){
            from = Square.H8;
        }
    
        if (to == null || from == null){
            return null;
        }
        else{
            return new Move(to,from);
        }
    }
    
}
