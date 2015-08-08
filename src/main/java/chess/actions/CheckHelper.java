package chess.actions;

import chess.GameState;
import chess.Player;
import chess.Position;
import chess.pieces.King;
import chess.pieces.Piece;

import java.util.List;
import java.util.Map;

public class CheckHelper {
    private GameState gameState;

    public CheckHelper(GameState gameState) {
        this.gameState = gameState;
    }

    public boolean isMoveLeadsToCheck(Player p, GameState g, Move m) {
        Map<Position, Piece> board = g.getGameBoardImmutable();
        gameState = new GameState(board);
        gameState.move(m, g.getPieceAt(m.getOrigin()));
        return isCheck(p);
    }

    public boolean isCheck(Player p) {
        Position position = null;
        for (int i = Position.MAX_ROW; i >= Position.MIN_ROW; i--) {
            for (char c = Position.MIN_COLUMN; c <= Position.MAX_COLUMN; c++) {
                Piece piece = gameState.getPieceAt(String.valueOf(c) + i);
                if (piece != null && piece.getClass().equals(King.class) && piece.getOwner() == p) {
                    position = new Position(c, i);
                    break;
                }
            }
        }

        List<Move> moves = gameState.listAllMoves(p == Player.Black ? Player.White : Player.Black, false);
        for (Move move : moves) {
            if (move.getDestination().equals(position)) {
                return true;
            }
        }
        return false;
    }
}
