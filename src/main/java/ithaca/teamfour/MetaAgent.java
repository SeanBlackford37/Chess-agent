package ithaca.teamfour;

import java.util.List;

import com.github.bhlangonijr.chesslib.Board;
import com.github.bhlangonijr.chesslib.move.Move;

import ithaca.teamfour.player.ChessPlayer;

public class MetaAgent implements ChessPlayer{
    private List<ChessPlayer> agents;

    public MetaAgent(List<ChessPlayer> agents){
        this.agents = agents;
    }

    public Move chooseMove(Board curBoard, char yourSymbol){
        for (int i =0; i< agents.size(); i++){
            Move temp = agents.get(i).chooseMove(curBoard.clone(), yourSymbol);
            if (temp != null){
                return temp;
            }
        }
        return null;
    }
}
