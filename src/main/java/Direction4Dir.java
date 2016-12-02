/**
 * Created by qale0001 on 02/12/2016.
 */
public enum Direction4Dir {
    UP(-1,0) ,
    DOWN(1,0),
    RIGHT(0,1),
    LEFT(0,-1);

    private int mx;
    private int my;

    private Direction4Dir(int mx, int my) {
        this.mx = mx;
        this.my = my;
    }

    public int getMx() {
        return mx;
    }

    public int getMy() {
        return my;
    }
}
