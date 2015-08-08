package chess.actions;

import chess.GameState;
import chess.Position;
import chess.pieces.Piece;

import java.util.List;

public abstract class MoveHelper {
    private GameState gameState;

    public MoveHelper(GameState gameState) {
        this.gameState = gameState;
    }

    protected GameState getGameState() {
        return gameState;
    }

    public abstract List<Move> getAllMoves(Piece piece, Position position, boolean isCheck);
}
