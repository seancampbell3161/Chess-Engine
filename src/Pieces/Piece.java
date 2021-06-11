package Pieces;
import Board.Board;
import Board.Move;

import java.util.Collection;
import java.util.List;

public abstract class Piece {

    protected final int piecePosition;
    protected final Team pieceTeam;

    /*
    Constructor with position of piece and piece color as arguments
     */
    Piece(final int piecePosition, final Team pieceTeam) {
        this.pieceTeam = pieceTeam;
        this.piecePosition = piecePosition;
    }

    /*
    A method that returns the color of the piece
     */
    public Team getPieceTeam() {
        return this.pieceTeam;
    }

    /*
    Method to calculate how a Piece moves
     */
    public abstract List<Move> calculateLegalMoves(final Board board);
}
