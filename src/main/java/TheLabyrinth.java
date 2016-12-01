import java.awt.*;
import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class TheLabyrinth {

    private static class TraceablePoint extends Point {
        TraceablePoint previous;
        String dir;

        public TraceablePoint(int r, int c) {
            super(r, c);
        }

        public TraceablePoint getPrevious() {
            return previous;
        }

        public void setPrevious(TraceablePoint previous) {
            this.previous = previous;
        }

        public String getDir() {
            return dir;
        }

        public void setDir(String dir) {
            this.dir = dir;
        }
    }

    private static String getDir(int k) {
        switch (k) {
            case 0: return "DOWN";
            case 1: return "UP";
            case 2: return "RIGHT";
            case 3: return "LEFT";
        }
        return "";
    }

    private static TraceablePoint getNotVisitedNeighbour(TraceablePoint point, int R, int C, char[][] matrix) {
        int[] mr = {1, -1, 0, 0};
        int[] mc = {0, 0, 1, -1};

        for (int k = 0; k < 4; k++) {
            int r = mr[k] + (int) point.getX();
            int c = mc[k] + (int) point.getY();
            if (0 <= r && r < R && 0 <= c && c < C && (matrix[r][c] == '?' || matrix[r][c] == 'C')) {
                TraceablePoint traceablePoint = new TraceablePoint(r, c);
                traceablePoint.setDir(getDir(k));
                return traceablePoint;
            }
        }

        return null;
    }

    private static String getTraces(TraceablePoint startPoint, TraceablePoint endPoint) {
        while (endPoint != null && !(endPoint.getPrevious().getX() == startPoint.getX() && endPoint.getPrevious().getY() == startPoint.getY())) {

            System.out.println(endPoint.getDir());
            endPoint = endPoint.getPrevious();
        }
        return endPoint.getDir();
    }

    private static String getNextMove(int R, int C, int A, int KR, int KC, char[][] matrix) {
        Queue<TraceablePoint> queue = new LinkedList<>();
        TraceablePoint kPoint = new TraceablePoint(KR, KC);
        queue.add(kPoint);
        matrix[KR][KC] = '.';
        TraceablePoint controlPoint = null;

        while (!queue.isEmpty()) {
            TraceablePoint point = queue.remove();
            TraceablePoint np = null;
            while ((np = getNotVisitedNeighbour(point, R, C, matrix)) != null) {
                int r = (int) np.getX();
                int c = (int) np.getY();
                np.setPrevious(point);
                queue.add(np);
                if (matrix[r][c] == 'C') {
                    System.out.println(r + ":" + c);
                    controlPoint = np;
                    queue.clear();
                }
                matrix[r][c] = '.';
            }
        }

        return getTraces(kPoint, controlPoint);
    }

    public static void main(String args[]) {
        //Scanner in = new Scanner(System.in);
        int R = 10; //in.nextInt(); // number of rows.
        int C = 30;//in.nextInt(); // number of columns.
        int A = 23;//in.nextInt(); // number of rounds between the time the alarm countdown is activated and the time the alarm goes off.

        // game loop
        while (true) {
            int KR = 3;//in.nextInt(); // row where Kirk is located.
            int KC = 6;//in.nextInt(); // column where Kirk is located.
            char[][] matrix = new char[R][C];
            String[] lines = new String[R];

            lines[0] = "??????????????????????????????";
            lines[1] = "#?????????????????????????????";
            lines[2] = "#.#############???????????????";
            lines[3] = "#?????T???????????????????????";
            lines[4] = "#?????.?????????????????#?#??#";
            lines[5] = "#.#######################?#..#";
            lines[6] = "#.....##......##......#..??###";
            lines[7] = "#...####..##..##..##..#..#?..#";
            lines[8] = "#.........##......##.....#?C.#";
            lines[9] = "##############################";

            for (int i = 0; i < R; i++) {
                //String ROW = in.next(); // C of the characters in '#.TC?' (i.e. one line of the ASCII maze).
                for (int j = 0; j < C; j++) {
                    matrix[i][j] = lines[i].charAt(j);
                }
            }

            if (R <= 0 || C <=0)
                return;
            String nextMove = getNextMove(R, C, A, KR, KC, matrix);

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            // System.out.println(nextMove); // Kirk's next move (UP DOWN LEFT or RIGHT).
            break;
        }
    }
}