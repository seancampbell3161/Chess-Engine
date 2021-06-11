package Pieces;

import Board.*;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {

    /*
    A fixed offset of move possibilities for the Knight
     */
    private static final int[] POSSIBLE_MOVE_COORDINATES = { -17, -15, -10, -6, 6, 10, 15, 17};

    Knight(int piecePosition, Team pieceTeam) {
        super(piecePosition, pieceTeam);
    }

    /*
    A method to calculate if the move for the Knight is occupied by a teammate or out of the board layout
     */
    @Override
    public List<Move> calculateLegalMoves(Board board) {
        int possibleDestinationCoordinate;
        List<Move> legalMoves = new ArrayList<>();

        for(final int currentPossibleMove : POSSIBLE_MOVE_COORDINATES) {
            possibleDestinationCoordinate = this.piecePosition + currentPossibleMove;
            if(BoardUtils.isValidTileCoordinate(possibleDestinationCoordinate)) {
                if(isFirstColumnExclusion(this.piecePosition, currentPossibleMove) ||
                        isSecondColumnExclusion(this.piecePosition, currentPossibleMove) ||
                        isSeventhColumnExclusion(this.piecePosition, currentPossibleMove) ||
                        isEighthColumnExclusion(this.piecePosition, currentPossibleMove)) {
                    continue;
                }
                final Tile possibleDestinationTile = board.getTile(possibleDestinationCoordinate);
                if(!possibleDestinationTile.isTileOccupied()) {
                    legalMoves.add(new Move());
                } else {
                    final Piece pieceAtDestination = possibleDestinationTile.getPiece();
                    final Team pieceTeam = pieceAtDestination.getPieceTeam();
                    if(this.pieceTeam != pieceTeam) {
                        legalMoves.add(new Move());
                    }
                }
            }
        }
        return ImmutableList.copyOf(legalMoves);
    }

    /*
    Method that checks if Knight is in column 1 for broken movement edge case
     */
    private static boolean isFirstColumnExclusion(final int currentPosition, final int candidateOffset) {
        return BoardUtils.FIRST_COLUMN[currentPosition] && (candidateOffset == -17 || candidateOffset == -10 ||
                candidateOffset == 6 || candidateOffset == 15);
    }

    /*
    Method that checks if Knight is in column 2 for broken edge case
     */
    private static boolean isSecondColumnExclusion(final int currentPosition, final int candidateOffset) {
        return BoardUtils.SECOND_COLUMN[currentPosition] && (candidateOffset == -10 || (candidateOffset == 6);
    }

    /*
    Method that checks if Knight is in column 7 for broken edge case
     */
    private static boolean isSeventhColumnExclusion(final int currentPosition, final int candidateOffset) {
        return BoardUtils.SEVENTH_COLUMN[currentPosition] && (candidateOffset == -6 || candidateOffset == 10);
    }

    /*
    Method that checks if Knight is in column 8 for broken edge case
     */
    private static boolean isEighthColumnExclusion(final int currentPosition, final int candidateOffset) {
        return BoardUtils.EIGTH_COLUMN[currentPosition] && (candidateOffset == -15 || candidateOffset == -6 ||
                candidateOffset == 10 || candidateOffset == 17);
    }
}
