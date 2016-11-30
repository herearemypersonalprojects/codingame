import java.util.ArrayList;
import java.util.List;

/**
 * Created by qale0001 on 30/11/2016.
 */
public class Node<T> {
    List<Node> children;

    T value;

    boolean visited = false;

    public Node() {
        children = new ArrayList<Node>();
    }

    public List<Node> getChildren() {
        return children;
    }

    public void addChild(Node child) {
        children.add(child);
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
