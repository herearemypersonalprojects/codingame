import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class War {
    static Map<String, Integer> VALUES = new HashMap<>();
    static {
        String[] cards = "2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A".split(", ");
        for (int i = 0; i < cards.length; i++) {
            VALUES.put(cards[i], i);
        }
    }


    private static String getWinner(Queue<String> player1, Queue<String> player2) {
        Queue<String> war1 = new LinkedList<>();
        Queue<String> war2 = new LinkedList<>();

        int round = 0;

        while (!player1.isEmpty() && !player2.isEmpty()) {
            String card1 = player1.poll();
            war1.add(card1);

            String card2 = player2.poll();
            war2.add(card2);

            if (VALUES.get(card1) > VALUES.get(card2)) {
                while (!war1.isEmpty()) {
                    player1.add(war1.poll());
                }
                while (!war2.isEmpty()) {
                    player1.add(war2.poll());
                }
                round++;
            } else
            if (VALUES.get(card1) < VALUES.get(card2)) {
                while (!war1.isEmpty()) {
                    player2.add(war1.poll());
                }
                while (!war2.isEmpty()) {
                    player2.add(war2.poll());
                }
                round++;
            } else {
                for (int i = 0; i < 3; i++) {
                    if (!player1.isEmpty() && !player2.isEmpty()) {
                        war1.add(player1.poll());
                        war2.add(player2.poll());
                    } else {
                        return "PAT";
                    }
                }
            }

        }
        return (player1.isEmpty() ? "2 " : "1 ") + round;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        Queue<String> queue1 = new LinkedList<>();
        int n = in.nextInt(); // the number of cards for player 1

        for (int i = 0; i < n; i++) {
            String cardp1 = in.next(); // the n cards of player 1
            queue1.add(cardp1.substring(0, cardp1.length() - 1));
            System.err.print(cardp1.substring(0, cardp1.length() - 1).concat(" "));
        }
        System.err.println();
        Queue<String> queue2 = new LinkedList<>();
        int m = in.nextInt(); // the number of cards for player 2

        for (int i = 0; i < m; i++) {
            String cardp2 = in.next(); // the m cards of player 2
            queue2.add(cardp2.substring(0, cardp2.length() - 1));
            System.err.print(cardp2.substring(0, cardp2.length() - 1).concat(" "));
        }
        System.err.println();


        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(getWinner(queue1, queue2));
    }
}
/*
The Goal

Let's go back to basics with this simple card game: war!

Your goal is to write a program which finds out which player is the winner for a given card distribution of the "war" game.
 	Rules

War is a card game played between two players. Each player gets a variable number of cards of the beginning of the game: that's the player's deck. Cards are placed face down on top of each deck.

Step 1 : the fight
At each game round, in unison, each player reveals the top card of their deck – this is a "battle" – and the player with the higher card takes both the cards played and moves them to the bottom of their stack. The cards are ordered by value as follows, from weakest to strongest:
2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A.

Step 2 : war
If the two cards played are of equal value, then there is a "war". First, both players place the three next cards of their pile face down. Then they go back to step 1 to decide who is going to win the war (several "wars" can be chained). As soon as a player wins a "war", the winner adds all the cards from the "war" to their deck.

Special cases:
If a player runs out of cards during a "war" (when giving up the three cards or when doing the battle), then the game ends and both players are placed equally first.
The test cases provided in this puzzle are built in such a way that a game always ends (you do not have to deal with infinite games)
Each card is represented by its value followed by its suit: D, H, C, S. For example: 4H, 8C, AS.

When a player wins a battle, they put back the cards at the bottom of their deck in a precise order. First the cards from the first player, then the one from the second player (for a "war", all the cards from the first player then all the cards from the second player).

For example, if the card distribution is the following:
Player 1 : 10D 9S 8D KH 7D 5H 6S
Player 2 : 10H 7H 5C QC 2C 4H 6D
Then after one game turn, it will be:
Player 1 : 5H 6S 10D 9S 8D KH 7D 10H 7H 5C QC 2C
Player 2 : 4H 6D

Victory Conditions
A player wins when the other player no longer has cards in their deck.
 	Game Input

Input
Line 1: the number N of cards for player one.

N next lines: the cards of player one.

Next line: the number M of cards for player two.

M next lines: the cards of player two.

Output
If players are equally first: PAT
Otherwise, the player number (1 or 2) followed by the number of game rounds separated by a space character. A war or a succession of wars count as one game round.
Constraints
0 < N, M < 1000
Example
Input
3
AD
KC
QC
3
KH
QS
JC
Output
1 3
 */