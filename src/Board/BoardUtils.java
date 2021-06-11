package Board;

public class BoardUtils {

    public static final boolean[] FIRST_COLUMN = null;
    public static final boolean[] SECOND_COLUMN = null;
    public static final boolean[] SEVENTH_COLUMN = null;
    public static final boolean[] EIGTH_COLUMN = null;

    private BoardUtils() throws Exception {
        throw new Exception("You cannot instantiate me");
    }

    public static boolean isValidTileCoordinate(int coordinate) {
        return coordinate >=0 && coordinate < 64;
    }
}
