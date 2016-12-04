/**
 * Created by quocanh on 04/12/2016.
 */
public enum Direction {
    U(0,-1),
    UR(1,-1),
    R(1, 0),
    DR(1,1),
    D(0, 1),
    DL(-1,1),
    L(-1,0),
    UL(-1,-1);

    int mx;
    int my;

    private Direction(int mx, int my) {
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
