import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class PowerOfThor {

    static class Point<T> {
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
    static class Matrix {

        private <T> Point getNeighbour(Point point, int h, int w, T v, Direction8Dir dir) {
            int x = point.getX() + dir.getMx();
            int y = point.getY() + dir.getMy();

            if (0 <= x && x < w && 0 <= y && y < h && ( point.getValue() == null || v.equals(point.getValue()))) {
                return new Point(x, y, null);
            }

            return null;
        }

        public <T> List<Point> getNeighbours(Point point, int h, int w, T v) { // h = y; w = x;
            List<Point> lstPoints = new ArrayList<>();
            for (Direction8Dir dir : Direction8Dir.values()) {
                Point neighbour = getNeighbour(point, h, w, v, dir);
                if (neighbour != null)
                    lstPoints.add(neighbour);
            }
            return lstPoints;
        }

        public Direction8Dir getDirection(Point start, Point end) {
            Direction8Dir dir = null;
            for (Direction8Dir tmp : Direction8Dir.values()) {
                int x = end.getX() - start.getX();
                int y = end.getY() - start.getY();
                if (x == tmp.getMx() && y == tmp.getMy()) {
                    dir = tmp;
                    break;
                }
            }
            return dir;
        }

        public Point getNextMove(Point start, Direction8Dir direction) {
            int x = start.getX() + direction.getMx();
            int y = start.getY() + direction.getMy();
            return new Point(x, y, null);
        }
    }
    static enum Direction8Dir {
        N(0,-1),
        NE(1,-1),
        E(1,0),
        SE(1,1),
        S(0,1),
        SW(-1,1),
        W(-1,0),
        NW(-1,-1);

        int mx;
        int my;

        private Direction8Dir(int mx, int my) {
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

    private static Point getNextMove(Point startPoint, Point endPoint) {
        List<Point> lstNeighbours = new Matrix().getNeighbours(startPoint, 18, 40, null);
        double distance = Double.MAX_VALUE;
        Point rem = null;
        //System.err.println("Diem dau..." + lstNeighbours.size() + "->" + startPoint.getX() +":"+startPoint.getY());
        for (Point point : lstNeighbours) {
            double tmp = Math.sqrt((endPoint.getX()-point.getX())*(endPoint.getX()-point.getX()) +
                    (endPoint.getY()-point.getY())*(endPoint.getY()-point.getY()));
            //System.err.println("xq " + point.getX() + ":" + point.getY() + ": " + tmp);
            if (tmp < distance) {
                distance = tmp;
                rem = point;
            }
        }
        return rem;
    }

    private static Direction8Dir nextDir(Direction8Dir dir) {
        boolean ok = false;
        for (Direction8Dir d : Direction8Dir.values()) {
            if (ok) {
                return d;
            }
            if (dir.equals(d)) {
                ok = true;
            }
        }
        return Direction8Dir.N;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int lightX = in.nextInt(); // the X position of the light of power
        int lightY = in.nextInt(); // the Y position of the light of power
        int initialTX = in.nextInt(); // Thor's starting X position
        int initialTY = in.nextInt(); // Thor's starting Y position

        Point startPoint = new Point(initialTX, initialTY, null);
        Point endPoint = new Point(lightX, lightY, null);
        Point temp = null;
        // game loop
        int remain = Integer.MAX_VALUE;
        Direction8Dir dir = Direction8Dir.N;
        while (!(startPoint.getX() == endPoint.getX() && startPoint.getY() == endPoint.getY())) {
            int remainingTurns = in.nextInt(); // The remaining amount of turns Thor can move. Do not remove this line.


            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            temp = startPoint;
            startPoint = getNextMove(startPoint, endPoint);
            // A single line providing the move to be made: N NE E SE S SW W or NW
            System.out.println(new Matrix().getDirection(temp, startPoint));
            remain = remainingTurns;

        }
    }
}
