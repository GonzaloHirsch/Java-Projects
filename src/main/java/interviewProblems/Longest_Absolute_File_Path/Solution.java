package interviewProblems.Longest_Absolute_File_Path;

import java.util.Stack;

class Solution {
    public int lengthLongestPath(String input) {
        String[] paths = input.split("\n");
        Stack<String> stack = new Stack<>();
        int max = 0, depth = 0, curr = 0;
        // Iterate all paths
        for (String path : paths) {
            // Always account for length
            curr += path.length();
            // Find the current depth of the part
            depth = path.lastIndexOf("\t") + 1;
            // If we are less deep than the stack, we went up in the hierarchy, so we find the current parent
            while (depth < stack.size()) curr -= stack.pop().length();
            // If it's a file we check for length
            if (path.contains(".")) {
                // Remove \t (\t.length == 1) and add /
                max = Math.max(max, curr - ((depth * (depth + 1)) / 2) + depth);
                curr -= path.length();
            }
            else stack.push(path);
        }
        return max;
    }
}