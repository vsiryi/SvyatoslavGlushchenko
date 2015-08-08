package chess.actions;

import chess.GameState;
import chess.Player;
import chess.Position;
import chess.pieces.Pawn;
import org.junit.Test;

import static chess.TestHelper.wrapToMoves;
import static org.junit.Assert.assertEquals;

public class PawnMoveHelperTest {

    @Test
    public void testGetAllMoves(){
        MoveHelper testClass = new PawnMoveHelper(new GameState());

        assertEquals(wrapToMoves("b2 b3,b2 b4"),
                testClass.getAllMoves(new Pawn(Player.White), new Position("b2"), false));
    }
}