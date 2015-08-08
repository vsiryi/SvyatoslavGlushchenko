package chess.actions;

import chess.GameState;
import chess.Player;
import chess.Position;
import chess.pieces.Piece;

import java.util.LinkedList;
import java.util.List;

public class PawnMoveHelper extends MoveHelper {
    Position checkSpace;

    public PawnMoveHelper(GameState gameState) {
        super(gameState);
    }

    @Override
    public List<Move> getAllMoves(Piece piece, Position position, boolean isCheck) {
        List<Move> moves = new LinkedList<Move>();
        Player player = piece.getOwner();
        int playerMult = 1;
        if (player == Player.Black)
            playerMult = -1;

        CheckHelper helper = new CheckHelper(super.getGameState());

        if (canMoveOneAhead(position, playerMult))
            if (!isCheck || !helper.isMoveLeadsToCheck(piece.getOwner(), super.getGameState(), new Move(position, checkSpace)))
                moves.add(new Move(position, checkSpace));

        if (canMoveTwoAhead(position, playerMult))
            if (!isCheck || !helper.isMoveLeadsToCheck(piece.getOwner(), super.getGameState(), new Move(position, checkSpace)))
                moves.add(new Move(position, checkSpace));

        if (canMoveDiagonal(position, player, playerMult, 1))
            if (!isCheck || !helper.isMoveLeadsToCheck(piece.getOwner(), super.getGameState(), new Move(position, checkSpace)))
                moves.add(new Move(position, checkSpace));

        if (canMoveDiagonal(position, player, playerMult, -1))
            if (!isCheck || !helper.isMoveLeadsToCheck(piece.getOwner(), super.getGameState(), new Move(position, checkSpace)))
                moves.add(new Move(position, checkSpace));
        return moves;
    }

    private boolean canMoveOneAhead(Position position, int playerMult) {
        if (playerMult > 0 && position.getRow() == Position.MAX_ROW)
            return false;
        if (playerMult < 0 && position.getRow() == Position.MIN_ROW)
            return false;
        return getGameState().getPieceAt(checkSpace = new Position(position.getColumn(), position.getRow() + 1 * playerMult)) == null;
    }

    private boolean canMoveTwoAhead(Position position, int playerMult) {
        if (!isOriginRow(playerMult, position))
            return false;
        return getGameState().getPieceAt(checkSpace) == null
                && getGameState().getPieceAt(checkSpace = new Position(position.getColumn(), position.getRow() + 2 * playerMult)) == null;
    }

    private boolean canMoveDiagonal(Position position, Player player, int playerMult, int diagDirection) {
        Piece p = getGameState().getPieceAt(checkSpace = new Position((char) (position.getColumn() + diagDirection), position.getRow() + 1 * playerMult));
        return p != null && p.getOwner() != player;
    }

    private boolean isOriginRow(int p, Position pos) {
        return (p < 0 && pos.getRow() == 7) || (p > 0 && pos.getRow() == 2);
    }

}
