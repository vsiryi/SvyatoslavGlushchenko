package chess.actions;

import chess.GameState;
import chess.Player;
import chess.Position;
import chess.pieces.Rook;
import org.junit.Test;

import static chess.TestHelper.wrapToMoves;
import static org.junit.Assert.*;

public class RookMoveHelperTest {

    @Test
    public void testGetAllMoves(){
        MoveHelper testClass = new RookMoveHelper(new GameState());

        assertEquals(wrapToMoves("a1 a2,a1 a3,a1 a4,a1 a5,a1 a6,a1 a7,a1 a8,a1 b1,a1 c1,a1 d1,a1 e1,a1 f1,a1 g1,a1 h1"),
                testClass.getAllMoves(new Rook(Player.White), new Position("a1"), false));
    }
}