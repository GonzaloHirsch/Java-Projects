package Longest_Palindromic_Substring;

// ---------------------------------- SOLVED ----------------------------------
// --------------------------- FACEBOOK / April 2020 --------------------------
/**
 * Original problem: https://leetcode.com/problems/longest-palindromic-substring/
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 */
class Main {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println("Executing solution");
        System.out.println(sol.longestPalindrome("babad"));
    }
}