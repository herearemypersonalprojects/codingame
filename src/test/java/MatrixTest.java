import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by quocanh on 02/12/2016.
 */
public class MatrixTest extends TestCase {

    @Test
    public void testGetNeighbours4Dir_case1() throws Exception {
        Point point = new Point(0, 0, null);
        int h = 10;
        int w = 10;
        List<Point> lstNeighbours = Matrix.getNeighbours4Dir(point, h, w, null);
        Assert.assertTrue(lstNeighbours.size() == 2);
    }

    @Test
    public void testGetNeighbours4Dir_case2() throws Exception {
        Point point = new Point(1, 0, null);
        int h = 10;
        int w = 10;
        List<Point> lstNeighbours = Matrix.getNeighbours4Dir(point, h, w, null);
        Assert.assertTrue(lstNeighbours.size() == 3);
    }

    @Test
    public void testGetNeighbours4Dir_case3() throws Exception {
        Point point = new Point(0, 1, null);
        int h = 10;
        int w = 10;
        List<Point> lstNeighbours = Matrix.getNeighbours4Dir(point, h, w, null);
        Assert.assertTrue(lstNeighbours.size() == 3);
    }

    @Test
    public void testGetNeighbours4Dir_case4() throws Exception {
        int h = 10;
        int w = 10;
        Point point = new Point(h, w, null);
        List<Point> lstNeighbours = Matrix.getNeighbours4Dir(point, h, w, null);
        Assert.assertTrue(lstNeighbours.size() == 0);
    }

    @Test
    public void testGetDirection_case1() throws Exception {
        Point start = new Point(0, 0, null);
        Point end = new Point(1, 0, null);
        Direction4Dir dir = Matrix.getDirection(start, end);
        Assert.assertTrue(dir.equals(Direction4Dir.DOWN));
    }

    @Test
    public void testGetNextMove() throws Exception {
        Point start = new Point(0, 0, null);
        Point end = Matrix.getNextMove(start, Direction4Dir.DOWN);
        Assert.assertTrue(end.getX() == 1);
        Assert.assertTrue(end.getY() == 0);
    }
}