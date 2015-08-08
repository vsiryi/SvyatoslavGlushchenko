package chess.actions;

import chess.GameState;
import chess.Player;
import chess.Position;
import chess.pieces.King;
import org.junit.Test;

import static chess.TestHelper.wrapToMoves;
import static org.junit.Assert.*;

public class KingMoveHelperTest {

    @Test
    public void testGetAllMoves(){
        MoveHelper testClass = new KingMoveHelper(new GameState());

        assertEquals(wrapToMoves("e1 f2,e1 d2,e1 e2,e1 f1,e1 d1"),
                testClass.getAllMoves(new King(Player.White), new Position("e1"), false));
    }
}