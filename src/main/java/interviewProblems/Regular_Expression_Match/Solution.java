package interviewProblems.Regular_Expression_Match;

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int isMatch(final String A, final String B) {
        boolean[][] dp = new boolean[A.length() + 1][B.length() + 1];
        for (int i = 0; i <= A.length(); i++){
            for (int j = 0; j <= B.length(); j++){
                if (j == 0 && i == 0){
                    dp[i][j] = true;
                } else if (j > 0 && B.charAt(j - 1) == '*'){
                    dp[i][j] = dp[i][j - 1] || (i > 0 && dp[i - 1][j]);
                } else if (i > 0 && j > 0 && match(A.charAt(i - 1), B.charAt(j - 1))) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[A.length()][B.length()] ? 1 : 0;

    }

    private boolean match(char a, char b){
        return b == '?' || b == a;
    }
}
