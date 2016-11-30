import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qale0001 on 30/11/2016.
 */
public class Tools {
    private static boolean isValidated(int x, int y, int R, int C) {
        if (R < 0 || C < 0)
            return false;
        if (x < 0 || x >= R || y < 0 || y >= C)
            return false;
        return true;
    }

    public static <T> List<Node> convertToNodes(T[][] matrix, int x, int y, int R, int C, T empty, T wall) {
        List<Node> lstNodes = new ArrayList<Node>();

        if (!isValidated(x, y, R, C)) {
            return lstNodes;
        }

        lstNodes.add(new Node(matrix[x][y]));

        int[] mr = {1, 0, 0, -1};
        int[] mc = {0, -1, 1, 0};
        boolean[][] visited = new boolean[R][C];
        Arrays.fill(visited, false);

        int i = x;
        int j = y;
        for (int k = 0; k < 4; k++) {
            int newX = i + mr[k];
            int newY = j + mr[k];
            if (0<=newX && newX <R && 0<=newY && newY<C) {
                T value = matrix[newX][newY];
                if (value.equals(empty) && !visited[newX][newY]) {
                    lstNodes.add(new Node(value));
                    visited[newX][newY] = true;
                }
            }
        }

        return lstNodes;
    }

    public static void main(String[]  args) {
        int R = 8;
        int C = 14;
        int x = 2;
        int y = 5;
        Character[][] matrix = new Character[R][C];
        String[] lines = new String[R];
        lines[0] = "##############";
        lines[1] = "##############";
        lines[2] = "###..K...#####";
        lines[3] = "###..###.#####";
        lines[4] = "####.###.#####";
        lines[5] = "##...###.#####";
        lines[6] = "####.....C####";
        lines[7] = "##############";

        for (int r = 0; r < R; r++) {
            System.out.println();
            for (int c = 0; c < C; c++) {
                matrix[r][c] = lines[r].charAt(c); System.out.print(matrix[r][c] + " ");
            }
        }

        List<Node> lstNodes = Tools.<Character>convertToNodes(matrix, x, y, R, C, '.', '#');
        System.out.println(lstNodes.get(0).getValue());
    }
}
