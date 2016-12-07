import java.util.*;
import java.io.*;
import java.math.*;
/**
 * Created by quocanh on 07/12/2016.
 */
public class Temperatures {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of temperatures to analyse

        System.err.println(n);
        in.nextLine();
        String temps = in.nextLine(); // the n temperatures expressed as integers ranging from -273 to 5526
        System.err.println(temps);


        String[] str = temps.split(" ");

        int output;
        if (n <= 0) {
            output = 0;
        } else {
            int[] ints = new int[n];

            int abs = Integer.MAX_VALUE;
            for (int i= 0; i < n && str[i].length() > 0; i++) {
                int so = Integer.valueOf(str[i]);

                if (Math.abs(abs) > Math.abs(so) || (Math.abs(abs) == Math.abs(so) && so > 0)) {
                    abs = so;
                }
            }
            output = abs;
        }

        System.out.println(output);
    }
}
/*
Write a program that prints the temperature closest to 0 among input data. If two numbers are equally close to zero, positive integer has to be considered closest to zero (for instance, if the temperatures are -5 and 5, then display 5).
 	Game Input

Your program must read the data from the standard input and write the result on the standard output.
Input
Line 1: N, the number of temperatures to analyze

Line 2: A string with the N temperatures expressed as integers ranging from -273 to 5526

Output
Display 0 (zero) if no temperatures are provided. Otherwise, display the temperature closest to 0.
Constraints
0 ≤ N < 10000
Example
Input
5
1 -2 -8 4 5
Output
1
 */