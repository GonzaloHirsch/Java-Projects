package interviewProblems.Count_And_Say;
class Solution {
    public String countAndSay(int n) {
        // Base case
        if (n == 1) return "1";
        // Get to the base case
        String s = this.countAndSay(n - 1);
        // Compute the new String
        StringBuilder sb = new StringBuilder();
        char c = 0, curr = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if ((c = s.charAt(i)) != curr) {
                // Add the character say
                sb.append(count).append(curr);
                // Update count
                count = 0;
                curr = c;
            }
            count++;
        }
        // Add the outstanding one
        sb.append(count).append(curr);
        return sb.toString();
    }
}