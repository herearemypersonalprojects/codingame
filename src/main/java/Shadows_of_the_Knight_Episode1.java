import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Shadows_of_the_Knight_Episode1 {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
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
    }

    enum Direction {
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

    private static Point getNextMove(Point start, Direction direction, int minW, int maxW, int minH, int maxH) {
        /*
        int step = 0;

        int x = start.getX();
        int y = start.getY();

        while (minW <= x && x < maxW && minH <= y && y < maxH) {
            x = x + direction.getMx();
            y = y + direction.getMy();
            step++;
        }

        step = step / 2;
        x = start.getX();
        y = start.getY();
        for (int k = 0; k < step; k++) {
            x = x + direction.getMx();
            y = y + direction.getMy();
        }
        */
        int x = minW + (maxW - minW)/2;
        int y = minH + (maxH - minH)/2;
        System.err.println(minW + ":" + maxW + " - " + minH + ":" + maxH + "--" + x + ":" + y);
        return new Point(x, y);
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); System.err.println(W); // width of the building.
        int H = in.nextInt(); System.err.println(H);// height of the building.
        int N = in.nextInt(); System.err.println(N);// maximum number of turns before game over.
        int X0 = in.nextInt();System.err.println(X0);
        int Y0 = in.nextInt();System.err.println(Y0);

        Point point = new Point(X0, Y0);
        int minW = 0;
        int minH = 0;
        int maxW = W-1;
        int maxH = H-1;
        // game loop
        while (true) {
            String bombDir = in.next(); // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)
            System.err.println(bombDir);
            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");


            // the location of the next window Batman should jump to.
            Direction dir = Direction.valueOf(bombDir);

            switch (dir) {
                case U:
                    minH = minH;
                    maxH = point.getY() - 1;
                    minW = maxW = point.getX();
                    break;
                case UR:
                    minW = point.getX() + 1;
                    maxH = point.getY() - 1;
                    break;
                case R:
                    minH = maxH = point.getY();
                    minW = point.getX() + 1;
                    break;
                case DR:
                    minH = point.getY() + 1;
                    minW = point.getX() + 1;
                    break;
                case D:
                    minW = maxW = point.getX();
                    minH = point.getY() + 1;
                    break;
                case DL:
                    minH = point.getY() + 1;
                    maxW = point.getX() - 1;
                    break;
                case L:
                    minH = maxH = point.getY();
                    maxW = point.getX() - 1;
                    break;
                case UL:
                    maxW = point.getX() - 1;
                    maxH = point.getY() - 1;
                    break;
            }

            point = getNextMove(point, dir, minW, maxW, minH, maxH);
            System.out.println(point.getX() + " " + point.getY());
        }
    }
}
/*
 	The Goal

Batman will look for the hostages on a given building by jumping from one window to another using his grapnel gun. Batman's goal is to jump to the window where the hostages are located in order to disarm the bombs. Unfortunately he has a limited number of jumps before the bombs go off...
 	Rules

Before each jump, the heat-signature device will provide Batman with the direction of the bombs based on Batman current position:
U (Up)
UR (Up-Right)
R (Right)
DR (Down-Right)
D (Down)
DL (Down-Left)
L (Left)
UL (Up-Left)

Your mission is to program the device so that it indicates the location of the next window Batman should jump to in order to reach the bombs' room as soon as possible.

Buildings are represented as a rectangular array of windows, the window in the top left corner of the building is at index (0,0).
 	Note

For some tests, the bombs' location may change from one execution to the other: the goal is to help you find the best algorithm in all cases.

The tests provided are similar to the validation tests used to compute the final score but remain different.
 	Game Input

The program must first read the initialization data from standard input. Then, within an infinite loop, read the device data from the standard input and provide to the standard output the next movement instruction.
Initialization input
Line 1 : 2 integers W H. The (W, H) couple represents the width and height of the building as a number of windows.

Line 2 : 1 integer N, which represents the number of jumps Batman can make before the bombs go off.

Line 3 : 2 integers X0 Y0, representing the starting position of Batman.

Input for one game turn
The direction indicating where the bomb is.
Output for one game turn
A single line with 2 integers X Y separated by a space character. (X, Y) represents the location of the next window Batman should jump to. X represents the index along the horizontal axis, Y represents the index along the vertical axis. (0,0) is located in the top-left corner of the building.
Constraints
1 ≤ W ≤ 10000
1 ≤ H ≤ 10000
2 ≤ N ≤ 100
0 ≤ X, X0 < W
0 ≤ Y, Y0 < H
Response time per turn ≤ 150ms
Response time per turn ≤ 150ms
Example
Initialization input
10 10     Building has 100 windows (10x10)
6         Batman has 6 jumps to find the bombs
2 5       Batman starts at position (2,5)

No output expected
Input for turn 1
UR
Hostages are in the upward-right direction

Output for turn 1
5 4
Batman jumps to window (5,4)
Input for turn 2
R
Hostages are located to the right of Batman

Output for turn 2
7 4
Batman jumps to window (7,4)

Batman found the hostages. He can defuse the bombs in time. You win!
Synopsis

Batman: “Come on Joker, give it up, I know you're hiding in here somewhere, you can't escape from me.”
Joker: “Oh, but I think I can Batman! Just look behind you. See these buildings over there? In each one of them there is a room full of hostages trapped with my sweet little Joker-BOMBS. They are about to go off any minute now in a marvellous firework! KA-BOOOM!!!”
Batman: “Damn you Joker, you won't get away with this.”
Joker: “So what will it be Batman? Do you want to waste time chasing me or will you try to save the poor, poor hostages? I'd hurry if I were you...Ha-ha-ha”
Batman: “Alfred, I don't have time to check all the buildings' windows: I need a gadget to help me.”
Alfred: “Certainly sir. I have the perfect device: it can track the bombs heat signature. I'm sending it to you as soon as I'm done reprogramming it.”
Joker: “So long Batman! Ha-ha-ha OH-OH-OH...”
 */