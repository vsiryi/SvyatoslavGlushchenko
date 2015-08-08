package chess.pieces;

import chess.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class KingTest {

    @Test
    public void testGetCharactersForBlackPlayer(){
        Piece testClass = new King(Player.Black);

        assertEquals('K', testClass.getIdentifier());
        assertEquals('k', testClass.getIdentifyingCharacter());
        assertEquals(Player.Black, testClass.getOwner());
    }

    @Test
    public void testGetCharactersForWhitePlayer(){
        Piece testClass = new King(Player.White);

        assertEquals('k', testClass.getIdentifier());
        assertEquals('k', testClass.getIdentifyingCharacter());
        assertEquals(Player.White, testClass.getOwner());
    }
}