package interviewProblems.Simplify_Path;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        StringBuilder result = new StringBuilder();

        // Build the queue of
        Deque<String> q = new LinkedList<>();
        for (String part : parts) {
            // Ignore if not empty or if the same directory
            if (!part.isEmpty() && !part.equals(".")) {
                // Ignore if there is no place to go back to
                if (part.equals("..") && !q.isEmpty()) q.removeLast();
                else if (!part.equals("..")) q.add(part);
            }
        }

        // Build the result
        while (!q.isEmpty()) result.append("/").append(q.pollFirst());
        String res = result.toString();
        return res.isEmpty() ? "/" : result.toString();
    }
}