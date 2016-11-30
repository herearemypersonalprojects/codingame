import java.util.ArrayList;
import java.util.List;

/**
 * Created by qale0001 on 30/11/2016.
 */
public class Node<T> {
    List<Node> children;

    T value;

    boolean visited = false;

    Node previous;

    public Node(T value) {
        children = new ArrayList<Node>();
        this.value = value;
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

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }
}
