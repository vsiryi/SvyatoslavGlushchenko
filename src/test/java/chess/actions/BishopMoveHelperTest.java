package chess.actions;

import chess.GameState;
import chess.Player;
import chess.Position;
import chess.pieces.Bishop;
import org.junit.Test;

import static chess.TestHelper.wrapToMoves;
import static org.junit.Assert.*;

public class BishopMoveHelperTest {

    @Test
    public void testGetAllMoves(){
        MoveHelper testClass = new BishopMoveHelper(new GameState());

        assertEquals(wrapToMoves("c1 d2,c1 e3,c1 f4,c1 g5,c1 h6,c1 b2,c1 a3"),
                testClass.getAllMoves(new Bishop(Player.White), new Position("c1"), false));
    }
}