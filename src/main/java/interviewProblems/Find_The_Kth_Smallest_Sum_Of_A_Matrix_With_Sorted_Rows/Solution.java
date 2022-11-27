package interviewProblems.Find_The_Kth_Smallest_Sum_Of_A_Matrix_With_Sorted_Rows;

import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int n = mat[0].length;
        // Keep from largest to smallest to only poll the first item at the end
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        for (int[] row : mat) {
            PriorityQueue<Integer> currPq = new PriorityQueue<>(Collections.reverseOrder());
            for (int num : pq) {
                for (int i = 0; i < n; i++) {
                    currPq.add(num + row[i]);
                    // Keep the size of the pq within k
                    while (currPq.size() > k) currPq.poll();
                }
            }
            pq = currPq;
        }
        return pq.poll();
    }
}