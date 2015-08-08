package chess.actions;

import chess.GameState;
import chess.Player;
import chess.Position;
import chess.pieces.Knight;
import org.junit.Test;

import static chess.TestHelper.wrapToMoves;
import static org.junit.Assert.*;

public class KnightMoveHelperTest {

    @Test
    public void testGetAllMoves(){
        MoveHelper testClass = new KnightMoveHelper(new GameState());

        assertEquals(wrapToMoves("b1 d2,b1 c3,b1 a3"),
                testClass.getAllMoves(new Knight(Player.White), new Position("b1"), false));
    }
}