package interviewProblems.Longest_Substring_Without_Repeating_Characters;

// ---------------------------------- SOLVED ----------------------------------
// --------------------------- FACEBOOK / April 2020 --------------------------
// ----------------------- BLOCKCHAIN.COM / December 2022 ---------------------
/**
 * Original problem: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
class Main {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println("Executing solution");
        System.out.println(sol.lengthOfLongestSubstring("pwwkew"));
    }
}