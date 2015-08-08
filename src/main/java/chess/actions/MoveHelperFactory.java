package chess.actions;

import chess.GameState;
import chess.pieces.Piece;

public class MoveHelperFactory {
    private GameState gameState;

    public MoveHelperFactory(GameState gameState) {
        this.gameState = gameState;
    }

    public MoveHelper getMoveHelper(Piece p) {
        switch (Character.toLowerCase(p.getIdentifier())) {
            case 'r':
                return new RookMoveHelper(gameState);
            case 'n':
                return new KnightMoveHelper(gameState);
            case 'b':
                return new BishopMoveHelper(gameState);
            case 'q':
                return new QueenMoveHelper(gameState);
            case 'k':
                return new KingMoveHelper(gameState);
            case 'p':
                return new PawnMoveHelper(gameState);
        }
        return null;
    }

}
