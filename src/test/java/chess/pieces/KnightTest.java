package chess.pieces;

import chess.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class KnightTest {

    @Test
    public void testGetCharactersForBlackPlayer(){
        Piece testClass = new Knight(Player.Black);

        assertEquals('N', testClass.getIdentifier());
        assertEquals('n', testClass.getIdentifyingCharacter());
        assertEquals(Player.Black, testClass.getOwner());
    }

    @Test
    public void testGetCharactersForWhitePlayer(){
        Piece testClass = new Knight(Player.White);

        assertEquals('n', testClass.getIdentifier());
        assertEquals('n', testClass.getIdentifyingCharacter());
        assertEquals(Player.White, testClass.getOwner());
    }
}