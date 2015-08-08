package chess.actions;

import chess.GameState;
import chess.Player;
import chess.Position;
import chess.pieces.Queen;
import org.junit.Test;

import static chess.TestHelper.wrapToMoves;
import static org.junit.Assert.*;

public class QueenMoveHelperTest {

    @Test
    public void testGetAllMoves(){
        MoveHelper testClass = new QueenMoveHelper(new GameState());

        assertEquals(wrapToMoves("d1 e2,d1 f3,d1 g4,d1 h5,d1 c2,d1 b3,d1 a4,d1 d2,d1 d3,d1 d4,d1 d5,d1 d6,d1 d7,d1 d8,d1 e1,d1 f1,d1 g1,d1 h1,d1 c1,d1 b1,d1 a1"),
                testClass.getAllMoves(new Queen(Player.White), new Position("d1"), false));
    }
}