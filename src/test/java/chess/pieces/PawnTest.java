package chess.pieces;

import chess.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class PawnTest {
    @Test
    public void testGetCharactersForBlackPlayer(){
        Piece testClass = new Pawn(Player.Black);

        assertEquals('P', testClass.getIdentifier());
        assertEquals('p', testClass.getIdentifyingCharacter());
        assertEquals(Player.Black, testClass.getOwner());
    }

    @Test
    public void testGetCharactersForWhitePlayer(){
        Piece testClass = new Pawn(Player.White);

        assertEquals('p', testClass.getIdentifier());
        assertEquals('p', testClass.getIdentifyingCharacter());
        assertEquals(Player.White, testClass.getOwner());
    }
}