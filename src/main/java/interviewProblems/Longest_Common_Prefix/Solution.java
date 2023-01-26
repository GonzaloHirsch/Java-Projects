package interviewProblems.Longest_Common_Prefix;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        // StringBuilder will build the solution
        StringBuilder sb = new StringBuilder("");
        int i = 0;
        char c;
        // Iterate until we find the break condition, which will set the i to a high negative number
        // Check that we are below the first one as a check to avoid invalid indexing
        // Cannot be more than the shortest one
        while (i >= 0 && i < strs[0].length()) {
            c = strs[0].charAt(i);
            // Check the specific character on each one until we find (or not) a match
            for (int j = 0; j < strs.length && i >= 0; j++)
                if (i >= strs[j].length() || c != strs[j].charAt(i)) i = Integer.MIN_VALUE;
            // Append the char if it's a valid index (make sure to use lower number to avoid ++ trouble)
            if (i++ >= 0) sb.append(c);
        }

        return sb.toString();
    }
}