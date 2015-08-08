package chess.pieces;

import chess.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueenTest {

    @Test
    public void testGetCharactersForBlackPlayer(){
        Piece testClass = new Queen(Player.Black);

        assertEquals('Q', testClass.getIdentifier());
        assertEquals('q', testClass.getIdentifyingCharacter());
        assertEquals(Player.Black, testClass.getOwner());
    }

    @Test
    public void testGetCharactersForWhitePlayer(){
        Piece testClass = new Queen(Player.White);

        assertEquals('q', testClass.getIdentifier());
        assertEquals('q', testClass.getIdentifyingCharacter());
        assertEquals(Player.White, testClass.getOwner());
    }
}