package interviewProblems.Largest_Rectangle_In_Histogram;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Solution {
    public int largestRectangleArea(ArrayList<Integer> A) {
        int n = A.size();
        int max = 0;
        int num;
        int left;
        // Add to add at end
        // PeekLast to peek at end
        // PollLast to remove at end
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++){
            while(!stack.isEmpty() && A.get(stack.peekLast()) > A.get(i)){
                num = A.get(stack.pollLast());
                left = stack.peekLast() == null ? -1 : stack.peekLast();
                max = Math.max(max, num * (i - left - 1));
            }
            stack.add(i);
        }
        while(!stack.isEmpty()){
            num = A.get(stack.pollLast());
            left = stack.peekLast() == null ? -1 : stack.peekLast();
            max = Math.max(max, num * (n - left - 1));
        }
        return max;
    }
}