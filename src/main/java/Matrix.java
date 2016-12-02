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
            return new Point(x, y, null);
        }

        return null;
    }

    public static <T> List<Point> getNeighbours4Dir(Point point, int h, int w, T v) {
        List<Point> lstPoints = new ArrayList<>();
        for (Direction4Dir dir : Direction4Dir.values()) {
            Point neighbour = getNeighbour(point, h, w, v, dir);
            if (neighbour != null)
                lstPoints.add(neighbour);
        }
        return lstPoints;
    }

    public static Direction4Dir getDirection(Point start, Point end) {
        Direction4Dir dir = null;
        for (Direction4Dir tmp : Direction4Dir.values()) {
            int x = end.getX() - start.getX();
            int y = end.getY() - start.getY();
            if (x == tmp.getMx() && y == tmp.getMy()) {
                dir = tmp;
                break;
            }
        }
        return dir;
    }

    public static Point getNextMove(Point start, Direction4Dir direction) {
        int x = start.getX() + direction.getMx();
        int y = start.getY() + direction.getMy();
        return new Point(x, y, null);
    }
}
