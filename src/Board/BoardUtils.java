package Board;

public class BoardUtils {

    /*
    Constructor
     */
    private BoardUtils() throws Exception {
        throw new Exception("You cannot instantiate me");
    }

    /*
    Array of booleans representing their respective columns on the board
     */
    public static final boolean[] FIRST_COLUMN = initColumn(0);
    public static final boolean[] SECOND_COLUMN = initColumn(1);
    public static final boolean[] SEVENTH_COLUMN = initColumn(6);
    public static final boolean[] EIGHT_COLUMN = initColumn(7);

    public static final int NUM_TILES = 64;
    public static final int NUM_TILES_PER_ROW = 8;

    /*
    A method to create a column on the board
     */
    private static boolean[] initColumn(int columnNumber) {
        final boolean[] column = new boolean[NUM_TILES];
        do {
            column[columnNumber] = true;
            columnNumber += NUM_TILES_PER_ROW;
        } while(columnNumber < NUM_TILES);
        return column;
    }

    /*
    A method that returns if coordinate is on the board
     */
    public static boolean isValidTileCoordinate(int coordinate) {
        return coordinate >=0 && coordinate < 64;
    }
}
