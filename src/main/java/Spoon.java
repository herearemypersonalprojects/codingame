import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Don't let the machines win. You are humanity's last hope...
 **/
class Spoon {

    private static void calculate(int w, int h, char[][] matrix) {
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++) {
                if (matrix[i][j] == '0') {
                    System.out.print(j + " " + i);

                    int k = j+1;
                    while (k < w && matrix[i][k] != '0') k++;

                    if (k < w && matrix[i][k] == '0') {
                        System.out.print(" " + k + " " + i);
                    } else {
                        System.out.print(" -1 -1");
                    }

                    k = i+1;
                    while (k < h && matrix[k][j] != '0') k++;

                    if (k < h && matrix[k][j] == '0') {
                        System.out.print(" " + j + " " + k);
                    } else {
                        System.out.print(" -1 -1");
                    }
                    System.out.println();
                }

            }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt(); // the number of cells on the X axis
        int height = in.nextInt(); // the number of cells on the Y axis
        in.nextLine();
        char[][] matrix = new char[height][width];
        for (int i = 0; i < height; i++) {
            String line = in.nextLine(); // width characters, each either 0 or .
            //System.err.println("Debug messages..." + line);
            if (line != null && line.length() >= width) {
                for (int j=0;j<width;j++) {
                    matrix[i][j] = line.charAt(j);
                }
            }

        }
        //...0.0
        //......
        //...0.0
        calculate(width, height, matrix);

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");


        // Three coordinates: a node, its right neighbor, its bottom neighbor
        //System.out.println("0 0 1 0 0 1");
    }
}