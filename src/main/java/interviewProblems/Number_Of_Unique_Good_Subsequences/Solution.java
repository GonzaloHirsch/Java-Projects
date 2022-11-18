package interviewProblems.Number_Of_Unique_Good_Subsequences;
class Solution {
    public int numberOfUniqueGoodSubsequences(String binary) {
        // Ends0 counts all subseq that end in 0
        // Ends1 counts all subseq that end in 1
        int MOD = (int)1e9 + 7, ends0 = 0, ends1 = 0, has0 = 0, n = binary.length();
        for (int i = 0; i < n; i++) {
            // Basically adds a 0 to all subseq ending in 1 or 0
            if (binary.charAt(i) == '0') {
                ends0 = (ends0 + ends1) % MOD;
                has0 = 1;
            }
            // Adds a 1 to all subseq, but the lone 1 is missing then, so we add it
            else ends1 = (ends0 + ends1 + 1) % MOD;
        }
        return (ends0 + ends1 + has0) % MOD;
    }
}