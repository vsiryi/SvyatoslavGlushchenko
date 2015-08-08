package chess.pieces;

import chess.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class BishopTest {
    @Test
    public void testGetCharactersForBlackPlayer(){
        Piece testClass = new Bishop(Player.Black);

        assertEquals('B', testClass.getIdentifier());
        assertEquals('b', testClass.getIdentifyingCharacter());
        assertEquals(Player.Black, testClass.getOwner());
    }

    @Test
    public void testGetCharactersForWhitePlayer(){
        Piece testClass = new Bishop(Player.White);

        assertEquals('b', testClass.getIdentifier());
        assertEquals('b', testClass.getIdentifyingCharacter());
        assertEquals(Player.White, testClass.getOwner());
    }
}