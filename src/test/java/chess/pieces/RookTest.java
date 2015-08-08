package chess.pieces;

import chess.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class RookTest {

    @Test
    public void testGetCharactersForBlackPlayer(){
        Piece testClass = new Rook(Player.Black);

        assertEquals('R', testClass.getIdentifier());
        assertEquals('r', testClass.getIdentifyingCharacter());
        assertEquals(Player.Black, testClass.getOwner());
    }

    @Test
    public void testGetCharactersForWhitePlayer(){
        Piece testClass = new Rook(Player.White);

        assertEquals('r', testClass.getIdentifier());
        assertEquals('r', testClass.getIdentifyingCharacter());
        assertEquals(Player.White, testClass.getOwner());
    }
}