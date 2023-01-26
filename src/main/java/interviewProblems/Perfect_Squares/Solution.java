package interviewProblems.Perfect_Squares;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int numSquares(int n) {
        // Compute the squares
        int[] squares = this.findSquares(n);
        // Define the BFS
        Queue<Integer> pending = new LinkedList<>();
        for (int j = squares.length - 1; j >= 0; j--) pending.add(squares[j]);
        Set<Integer> visited = new HashSet<>();
        int depth = 0, curr, size, next;
        while (!pending.isEmpty()) {
            size = pending.size();
            depth++;
            // Iterate all the pending items
            for (int i = 0; i < size; i++) {
                curr = pending.poll();
                // Check if solution is found
                if (curr == n) return depth;
                // Add to visited if no solution
                visited.add(curr);
                for (int j = squares.length - 1; j >= 0; j--) {
                    next = squares[j] + curr;
                    if (next == n) return depth + 1;
                    if (!visited.contains(next) && next <= n) pending.add(next);
                }
            }
        }
        return -1;
    }

    private int[] findSquares(int n) {
        int[] squares = new int[(int)Math.sqrt(n)];
        for (int i = 1; i <= squares.length; i++) squares[i - 1] = (i * i);
        return squares;
    }
}