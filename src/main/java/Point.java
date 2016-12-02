import java.util.ArrayList;
import java.util.List;

/**
 * Created by qale0001 on 02/12/2016.
 */
public class Point<T> {
    private int x;
    private int y;
    private T value;
    Point previous;
    List<Point> neighbours;

    public Point(int x, int y, T value) {
        this.x = x;
        this.y = y;
        this.value = value;
        neighbours = new ArrayList<>();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Point getPrevious() {
        return previous;
    }

    public void setPrevious(Point previous) {
        this.previous = previous;
    }

    public List<Point> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<Point> neighbours) {
        this.neighbours = neighbours;
    }
}
