import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class SuperComputer {
    private final static Integer MAX_N = 100000;
    private final static Integer MAX_J = 1000000;
    private final static Integer MAX_D = 1000;

    private static List<Integer> getNextTasks(Integer task, List<Integer> lstTasks, Map<Integer, Integer> finishes) {
        int finish = finishes.get(task);
        List<Integer> nextTasks = new ArrayList<>();
        lstTasks.stream()
                .filter(t -> finish <= t)
                .forEach(t -> nextTasks.add(t));
        return nextTasks;
    }

    private static Map<Integer, Integer> getLongestPath1(int n, List<Integer> lstTasks, Map<Integer, Integer> times) {
        Stack<Integer> stack = new Stack();
        Map<Integer, Integer> labels = new HashMap<>();
        int loop = 0;
        for (Integer task : lstTasks) {
            stack.push(task);
            labels.put(task, 1);
        }

        while (!stack.isEmpty() && loop < MAX_N) {
            loop ++;
            int task = stack.pop();
            List<Integer> nextTasks = getNextTasks(task, lstTasks, times);
            for (Integer nextTask : nextTasks) {
                stack.push(nextTask);
                labels.put(nextTask, labels.get(task) + 1);
            }
        }
        return labels;
    }

    private static int getLongestPath2(List<Integer> lstTasks, Map<Integer, Integer> times) {
        int number = 1;
        int task = 0;
        int i = 0;
        boolean found = false;
        do {
            task = lstTasks.get(i);
            found = false;
            for (int j = i+1; j < lstTasks.size(); j++) {
                if (times.get(lstTasks.get(j)) >= task) {
                    found = true;
                    number++;
                    i = j;
                    break;
                }
            }
        } while (found);
        return number;
    }

    private static int getMax(Map<Integer, Integer> longestPathes, List<Integer> lstTasks) {
        int longestPath = 0;
        for (Map.Entry<Integer, Integer> lp : longestPathes.entrySet()) {
            if (longestPath < lp.getValue()) {
                longestPath = lp.getValue();
            }
        }
        return longestPath;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt(); System.err.println("Number: " + N);
        List<Integer> lstTasks = new ArrayList<>();
        Map<Integer, Integer> times = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int J = in.nextInt();
            int D = in.nextInt();
            lstTasks.add(J);
            times.put(J, J + D);
        }
        lstTasks.stream().forEach(p -> System.err.print(p + " "));
        Collections.sort(lstTasks);
        System.err.println();
        lstTasks.stream().forEach(p -> System.err.print(p + " "));
        System.err.println();
        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        int result = 0;
        if (N < 1000) {
            result = getMax(getLongestPath1(N, lstTasks, times), lstTasks);
        } else {
            result = getLongestPath2(lstTasks, times);
        }

        System.out.println(result);
    }
}

/*
	The Goal

In the Computer2000 data center, you are responsible for planning the usage of a supercomputer for scientists. ​Therefore you've decided to organize things a bit by planning everybody’s tasks. The logic is simple: the higher the number of calculations which can be performed, the more people you can satisfy.
 	Rules

Scientists give you the starting day of their calculation and the number of consecutive days they need to reserve the calculator.

For example:
Calculation	Starting Day	Duration
A	2	5
B	9	7
C	15	6
D	9	3
Calculation A starts on day 2 and ends on day 6

Calculation B starts on day 9 and ends on day 15

Calculation starts on day 15 and ends on day 20

Calculation D starts on day 9 and ends on day 11

In this example, it’s not possible to carry out all the calculations because the periods for B and C overlap. 3 calculations maximum can be carried out: A, D and C.
 	Game Input

Input
Line 1: The number N of calculations

The N following lines: on each line, the starting day J and the duration D of reservation, separated by a blank space.

Output
The maximum number of calculations that can be carried out.
Constraints
0 < N < 100000
0 < J < 1000000
0 < D < 1000
Examples
Input
4
2 5
9 7
15 6
9 3
Output
3
Input
5
3 5
9 2
24 5
16 9
11 6
Output
4
 */