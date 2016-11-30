import java.util.ArrayList;
import java.util.List;

/**
 * Created by qale0001 on 30/11/2016.
 */
public class Tools {
    public static <T> List<Node<T>> convertToNodes(T[][] matrix, int x, int y) {
        List<Node<T>> lstNodes = new ArrayList<Node<T>>();



        return lstNodes;
    }

    public static void main(String[]  args) {
        int R = 8;
        int C = 14;
        char[][] matrix = new char[R][C];
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

        List<Node> lstNodes = Tools.convertToNodes(matrix<char>);
    }
}
