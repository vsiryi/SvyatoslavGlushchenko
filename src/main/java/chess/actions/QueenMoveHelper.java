package chess.actions;

import chess.GameState;
import chess.Position;
import chess.pieces.Piece;

import java.util.LinkedList;
import java.util.List;

public class QueenMoveHelper extends MoveHelper {

    public QueenMoveHelper(GameState gameState) {
        super(gameState);
    }

    @Override
    public List<Move> getAllMoves(Piece piece, Position position, boolean isCheck) {
        List<Move> moves = new LinkedList<Move>();
        int[][] coords = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] i : coords) {
            int x = position.getRow() + i[0];
            char y = (char) (position.getColumn() + i[1]);
            while (x <= Position.MAX_ROW && x >= Position.MIN_ROW && y <= Position.MAX_COLUMN && y >= Position.MIN_COLUMN) {
                Piece p = getGameState().getPieceAt(new Position(y, x));
                CheckHelper helper = new CheckHelper(super.getGameState());
                if (p != null && p.getOwner() == piece.getOwner())
                    break;
                if (!isCheck || !helper.isMoveLeadsToCheck(piece.getOwner(), super.getGameState(), new Move(position, new Position(y, x))))
                    moves.add(new Move(position, new Position(y, x)));
                if (p != null)
                    break;
                x += i[0];
                y += i[1];
            }
        }

        return moves;
    }

}
