package chess;


import chess.actions.CheckHelper;
import chess.actions.Move;
import chess.actions.MoveHelper;
import chess.actions.MoveHelperFactory;
import chess.pieces.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Class that represents the current state of the game.  Basically, what pieces are in which positions on the
 * board.
 */
public class GameState {

    /**
     * The current player
     */
    private Player currentPlayer = Player.White;

    /**
     * A map of board positions to pieces at that position
     */
    private Map<Position, Piece> positionToPieceMap;

    /**
     * Create the game state.
     */
    public GameState() {
        positionToPieceMap = new HashMap<Position, Piece>();
    }

    public GameState(Map<Position, Piece> piecesToPlace) {
        positionToPieceMap = new HashMap<Position, Piece>();
        for (Map.Entry<Position, Piece> entry : piecesToPlace.entrySet()) {
            placePiece(entry.getValue(), entry.getKey());
        }
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Call to initialize the game state into the starting positions
     */
    public void reset() {
        // White Pieces
        placePiece(new Rook(Player.White), new Position("a1"));
        placePiece(new Knight(Player.White), new Position("b1"));
        placePiece(new Bishop(Player.White), new Position("c1"));
        placePiece(new Queen(Player.White), new Position("d1"));
        placePiece(new King(Player.White), new Position("e1"));
        placePiece(new Bishop(Player.White), new Position("f1"));
        placePiece(new Knight(Player.White), new Position("g1"));
        placePiece(new Rook(Player.White), new Position("h1"));
        placePiece(new Pawn(Player.White), new Position("a2"));
        placePiece(new Pawn(Player.White), new Position("b2"));
        placePiece(new Pawn(Player.White), new Position("c2"));
        placePiece(new Pawn(Player.White), new Position("d2"));
        placePiece(new Pawn(Player.White), new Position("e2"));
        placePiece(new Pawn(Player.White), new Position("f2"));
        placePiece(new Pawn(Player.White), new Position("g2"));
        placePiece(new Pawn(Player.White), new Position("h2"));

        // Black Pieces
        placePiece(new Rook(Player.Black), new Position("a8"));
        placePiece(new Knight(Player.Black), new Position("b8"));
        placePiece(new Bishop(Player.Black), new Position("c8"));
        placePiece(new Queen(Player.Black), new Position("d8"));
        placePiece(new King(Player.Black), new Position("e8"));
        placePiece(new Bishop(Player.Black), new Position("f8"));
        placePiece(new Knight(Player.Black), new Position("g8"));
        placePiece(new Rook(Player.Black), new Position("h8"));
        placePiece(new Pawn(Player.Black), new Position("a7"));
        placePiece(new Pawn(Player.Black), new Position("b7"));
        placePiece(new Pawn(Player.Black), new Position("c7"));
        placePiece(new Pawn(Player.Black), new Position("d7"));
        placePiece(new Pawn(Player.Black), new Position("e7"));
        placePiece(new Pawn(Player.Black), new Position("f7"));
        placePiece(new Pawn(Player.Black), new Position("g7"));
        placePiece(new Pawn(Player.Black), new Position("h7"));
    }

    /**
     * Get the piece at the position specified by the String
     *
     * @param colrow The string indication of position; i.e. "d5"
     * @return The piece at that position, or null if it does not exist.
     */
    public Piece getPieceAt(String colrow) {
        Position position = new Position(colrow);
        return getPieceAt(position);
    }

    /**
     * Get the piece at a given position on the board
     *
     * @param position The position to inquire about.
     * @return The piece at that position, or null if it does not exist.
     */
    public Piece getPieceAt(Position position) {
        return positionToPieceMap.get(position);
    }

    /**
     * Method to place a piece at a given position
     *
     * @param piece    The piece to place
     * @param position The position
     */
    private void placePiece(Piece piece, Position position) {
        positionToPieceMap.put(position, piece);
    }

    public List<Move> listAllMoves() {
        return listAllMoves(currentPlayer, true);
    }

    public List<Move> listAllMoves(Player p, boolean isCheck) {
        List<Move> moves = new LinkedList<Move>();
        for (Map.Entry<Position, Piece> entry : positionToPieceMap.entrySet()) {
            if (entry.getValue().getOwner() == p)
                moves.addAll(listAllMoves(entry.getValue(), entry.getKey(), isCheck));
        }
        return moves;
    }

    private List<Move> listAllMoves(Piece p, Position pos, boolean isCheck) {
        MoveHelperFactory factory = new MoveHelperFactory(this);
        MoveHelper helper = factory.getMoveHelper(p);
        return helper.getAllMoves(p, pos, isCheck);
    }

    public boolean doMove(Move move) {
        return doMove(move, true);
    }

    public boolean doMove(Move move, boolean isCheck) {
        Piece p = getPieceAt(move.getOrigin());
        if (p == null)
            return false;
        MoveHelperFactory factory = new MoveHelperFactory(this);
        if (factory.getMoveHelper(p).getAllMoves(p, move.getOrigin(), isCheck).contains(move)) {
            move(move, p);
            changePlayer();
            return true;
        } else {
            return false;
        }
    }

    public void move(Move move, Piece p) {
        positionToPieceMap.remove(move.getOrigin());
        positionToPieceMap.put(move.getDestination(), p);
    }

    public boolean isCheck(Player p) {
        CheckHelper helper = new CheckHelper(this);
        return helper.isCheck(p);
    }

    public Map<Position, Piece> getGameBoardImmutable() {
        Map<Position, Piece> newMap = new HashMap<Position, Piece>();
        newMap.putAll(positionToPieceMap);
        return newMap;
    }

    public void changePlayer() {
        currentPlayer = currentPlayer == Player.Black ? Player.White : Player.Black;
    }
}
