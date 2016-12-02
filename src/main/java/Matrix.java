import java.util.ArrayList;
import java.util.List;

/**
 * Created by qale0001 on 02/12/2016.
 */
public class Matrix {

    private static <T> Point getNeighbour(Point point, int h, int w, T v, Direction4Dir dir) {
        int x = point.getX() + dir.getMx();
        int y = point.getY() + dir.getMy();

        if (0 <= x && x < h && 0 <= y && y < w && ( point.getValue() == null || v.equals(point.getValue()))) {
            Point neighbour = new Point(x, y, null);
        }

        return null;
    }

    public static <T> List<Point> getNeighbours4Dir(Point point, int h, int w, T v) {
        List<Point> lstPoints = new ArrayList<>();
        for (Direction4Dir dir : Direction4Dir.values()) {
            Point neighbour = getNeighbour(point, h, w, v, dir);
            lstPoints.add(neighbour);
        }
        return lstPoints;
    }

    public static Direction4Dir getDirection(Point start, Point end) {
        Direction4Dir dir = null;
        for (Direction4Dir tmp : Direction4Dir.values()) {

        }
        return dir;
    }

    public static Point getNextMove(Point start, Direction4Dir direction) {

    }
}
