package Board;

import Pieces.Piece;
import com.google.common.collect.ImmutableMap;
import java.util.HashMap;
import java.util.Map;

public abstract class Tile {

    protected final int tileCoordinate;
    private static final Map<Integer, EmptyTile> EMPTY_TILES_CACHE = createAllPossibleEmptyTiles();

    /*
    A method to create an a Map of 64 EmptyTile objects
     */
    private static Map<Integer, EmptyTile> createAllPossibleEmptyTiles() {
        final Map<Integer, EmptyTile> emptyTileMap = new HashMap();

        for(int i = 0; i < 64; i++) {
            emptyTileMap.put(i, new EmptyTile(i));
        }
        return ImmutableMap.copyOf(emptyTileMap);
    }

    /*
    A method to create a new tile
    If you want a new empty tile, it will take a cached empty tile so a new empty tile is not created
     */
    public static Tile createTile(final int tileCoordinate, final Piece piece) {
        return piece != null ? new OccupiedTile(tileCoordinate, piece) : EMPTY_TILES_CACHE.get(tileCoordinate);
    }

    /*
    Constructor for Board.Tile that takes a coordinate as an argument
     */
    private Tile(int tileCoordinate) {
        this.tileCoordinate = tileCoordinate;
    }

    /*
    A method that determines if the tile is occupied with a piece
     */
    public abstract boolean isTileOccupied();

    /*
    A method that will get the current piece
     */
    public abstract Piece getPiece();

    /*
    A Tile subclass for an empty tile
     */
    public static final class EmptyTile extends Tile {

        private EmptyTile(final int coordinate) {
            super(coordinate);
        }

        @Override
        public boolean isTileOccupied() {
            return false;
        }

        @Override
        public Piece getPiece() {
            return null;
        }
    }

    /*
    A Tile subclass for an occupied tile that has a piece on it
    Constructor takes coordinate as well as a Piece
     */
    public static final class OccupiedTile extends Tile {

        private final Piece pieceOnTile;

        private OccupiedTile(int coordinate, Piece pieceOnTile) {
            super(coordinate);
            this.pieceOnTile = pieceOnTile;
        }

        @Override
        public boolean isTileOccupied() {
            return true;
        }

        @Override
        public Piece getPiece() {
            return this.pieceOnTile;
        }
    }
}
