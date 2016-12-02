/**
 * Created by qale0001 on 02/12/2016.
 */
public enum Direction8Dir {
    N(-1,0),
    NE(-1,1),
    E(0,1),
    SE(1,1),
    S(1,0),
    SW(1,-1),
    W(0,-1),
    NW(-1,-1);

    int mx;
    int my;

    private Direction8Dir(int mx, int my) {
        this.mx = mx;
        this.my = my;
    }
}
