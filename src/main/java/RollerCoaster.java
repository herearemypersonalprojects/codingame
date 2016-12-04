import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class RollerCoaster {

    private static String getKey(Queue<Integer> queue) {
        StringBuilder key = new StringBuilder();
        for (Integer n : queue) {
            key.append(n + ":");
        }
        return key.toString();
    }

    private static void nextRound(List<Long> dirhamRound, Queue<Integer> queue, int nPlaces) {

        int nPersons = 0;
        Queue<Integer> nextQueue = new LinkedList<>();
        while (!queue.isEmpty() && nPersons + queue.peek() <= nPlaces) {
            nPersons = nPersons + queue.peek();
            nextQueue.add(queue.remove());
        }
        dirhamRound.add(dirhamRound.size (), (long)nPersons);
        // add into original queue
        while (!nextQueue.isEmpty()) {
            queue.add(nextQueue.remove());
        }
    }

    private static int getNRound(Map<String, Integer> visited, int value) {
        int total = 0;
        for (Map.Entry<String, Integer> entry : visited.entrySet()) {
            if (entry.getValue() == value) {
                total++;
            }
        }
        return total;
    }

    private static long getDirham(int nPlaces, int nRounds, int nGroups, int[] nPIG) {
        Map<String, Integer> visited = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        // init queue
        for (int numberP : nPIG) {
            queue.add(numberP);
        }
        List<Long> dirhamRound = new ArrayList<>();

        int round = 0;
        String key = getKey(queue);//System.err.println(key);
        visited.put(key, 1);
        boolean repeated = false;
        do {
            nextRound(dirhamRound, queue, nPlaces);
            key = getKey(queue);

            if (visited.get(key) == null) {
                visited.put(key, 1);
            } else {
                visited.put(key, visited.get(key) + 1);
            }
            repeated = (visited.get(key) != null && visited.get(key) > 2);
            round++;
        } while (round < nRounds && !repeated);

        if (repeated) {
            dirhamRound.remove(dirhamRound.size()-1);
            System.err.println(getKey(queue));
            int notRepeatedRounds = getNRound(visited, 1);
            int repeatedRounds = getNRound(visited, 2) + 1;

            int nr = (nRounds - notRepeatedRounds) / repeatedRounds;
            int rem = (nRounds - notRepeatedRounds) % repeatedRounds;

            long total = 0;
            for (int i = 0; i < notRepeatedRounds; i++) {
                total = total + dirhamRound.get(i);
            }

            for (int j = notRepeatedRounds; j < rem + notRepeatedRounds; j++ ) {
                total = total + dirhamRound.get(j);
            }

            long totalOne = 0;
            for (int k = notRepeatedRounds; k < dirhamRound.size(); k++) {
                totalOne = totalOne + dirhamRound.get(k);
            }
            total = total + totalOne*nr;

            return total;

        } else {
            long total = 0;
            for (long dir : dirhamRound) {
                total = total + dir;
            }
            return total;
        }
    }

    public static void test(String[] args) {
        int nPlaces = 10000;// in.nextInt();
        int nRounds = 10;// in.nextInt();
        int nGroups = 5;// in.nextInt();
        int[] nPersonInGroup = new int[nGroups];
        nPersonInGroup[0] = 100;
        nPersonInGroup[1] = 200;
        nPersonInGroup[2] = 300;
        nPersonInGroup[3] = 400;
        nPersonInGroup[4] = 500;
        /*
        for (int i = 0; i < nGroups; i++) {
            int pi = in.nextInt();
            nPersonInGroup[i] = pi;
        }
        */
        // 2 3 2 2 => nP = 4
        // R1: 2 2 => 2 2 2 3
        // R2: 3 => 3 2 2 2
        // R3: 2 2 => 2 2 3 2
        // R4: 2 => 2 2 2 3
        // R5: 3 => 3 2 2 2
        // R6: 2 2 => 2 2 3 2
        // R7: 2 => 2 2 2 3
        // R8: 3 => 3 2 2 2
        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(getDirham(nPlaces, nRounds, nGroups, nPersonInGroup));
    }


    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int nPlaces = in.nextInt();System.err.println("nPlace: " + nPlaces);
        int nRounds = in.nextInt();System.err.println("nRounds: " + nRounds);
        int nGroups = in.nextInt();System.err.println("nGroups: " + nGroups);
        int[] nPersonInGroup = new int[nGroups];
        for (int i = 0; i < nGroups; i++) {
            int pi = in.nextInt();
            nPersonInGroup[i] = pi;
        }

        // 2 3 2 2 => nP = 4
        // R1: 2 2 => 2 2 2 3
        // R2: 3 => 3 2 2 2
        // R3: 2 2 => 2 2 3 2
        // R4: 2 => 2 2 2 3
        // R5: 3 => 3 2 2 2
        // R6: 2 2 => 2 2 3 2
        // R7: 2 => 2 2 2 3
        // R8: 3 => 3 2 2 2
        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(getDirham(nPlaces, nRounds, nGroups, nPersonInGroup));
    }

}

/*
PROBLEM
	The Goal

You have recently been assigned to a new amusement park’s center of analysis and supervision. Your mission is to estimate each day what the earnings will be for each ride that day. You start by looking at the roller coaster.
 	Rules

You notice that people like the roller coaster so much that as soon as they have finished a ride, they cannot help but go back for another one.
People queue up in front of the attraction
They can either be alone or in a group. When groups are in the queue, they necessarily want to ride together, without being separated.
People never overtake each other in the queue.
When there isn’t enough space in the attraction for the next group in the queue, the ride starts (so it is not always full).
As soon as the ride is finished, the groups that come out, go back into the queue in the same order.
The attraction contains a limited number L of places.
The attraction can only function C number of times per day.
The queue contains a number N of groups.
Each group contains a number Pi of people.
Each person spends 1 dirham per ride.

 	Example

With L=3, C=3 and 4 groups (N=4) of the following sizes [3,1,1,2]:

Ride 1: for the first roller coaster ride, only the first group can get on and takes all the places. At the end of the ride, this group returns to the back of the queue that now looks as follows [1,1,2,3].
Earnings of the ride : 3 dirhams.

Ride 2 : on the second ride, the following two single-person groups can get on, leaving one place empty (the group of 2 people that follows cannot be separated) At the end of the ride, they return to the back of the queue: [2,3,1,1]
Earnings of the ride : 2 dirhams.

Ride 3: for the last ride (C=3), only the group of 2 people can get on, leaving one place empty. Earnings of the ride : 2 dirhams.

Total earnings: 3+2+2 = 7 dirhams

 	Game Input

Input
Line 1: The integers L, C and N separated by a space.

N following lines: Each line contains an integer Pi representing the number of people in a group. The lines are ordered in the same way as the queue. (The first lines correspond to the first groups that can get on the ride).

Output
An integer representing the number of dirhams earned at the end of the day on the roller coaster (after C roller coaster rides)
Constraints
Pi ≤ L
1 ≤ L ≤ 10^7
1 ≤ C ≤ 10^7
1 ≤ N ≤ 1000
1 ≤ Pi ≤ 10^6
Examples
Input
3 3 4
3
1
1
2
Output
7
Input
5 3 4
2
3
5
4
Output
14
Input
10 100 1
1
Output
100
 */

/*
Validators

The following validators differ from the puzzle test cases to prevent hard coded solutions. This is why you can have some fails here even if all of the tests provided in the IDE have been successfully passed.
01
Simple case
02
2 spot, 1 ride, 1 group
03
The same groups go on the ride several times during the day
04
1000 groups of a few people
05
All the people get on the roller coaster at least once
06
All the people get on the roller coaster before dawn
07
Sequence of groups of complementary people
08
High earnings during the day (> 2^32)
09
Works with a large dataset
10
Works with a very large dataset
 */