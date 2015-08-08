package chess.actions;

import chess.Position;
import org.junit.Test;

import static org.junit.Assert.*;

public class MoveTest {

    @Test
    public void testConstructor(){
        Position origin = new Position("e2");
        Position destination = new Position("e4");

        Move testClass = new Move(origin, destination);

        assertEquals(origin, testClass.getOrigin());
        assertEquals(destination, testClass.getDestination());
    }
}