package chess;

import chess.actions.Move;

import java.util.LinkedList;
import java.util.List;

public class TestHelper {
    public static List<Move> wrapToMoves(String s){
        List<Move> result = new LinkedList<Move>();

        String[] position = s.split(",");
        for(String p : position){
            String[] colrow = p.split(" ");
            result.add(new Move(new Position(colrow[0]), new Position(colrow[1])));
        }

        return result;
    }
}
