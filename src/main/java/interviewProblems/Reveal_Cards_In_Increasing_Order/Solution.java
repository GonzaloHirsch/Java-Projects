package interviewProblems.Reveal_Cards_In_Increasing_Order;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        // Sort the array ascending to have the proper ordering
        Arrays.sort(deck);

        // Initialize the response with zeros
        int[] res = new int[deck.length];

        // A queue for a simulation
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < deck.length; i++) q.add(i);

        int index = 0;
        while (!q.isEmpty()) {
            res[q.poll()] = deck[index++];
            if (!q.isEmpty()) q.add(q.poll());
        }

        return res;
    }
}