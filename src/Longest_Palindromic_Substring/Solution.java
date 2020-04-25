package Longest_Palindromic_Substring;

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int longest = 0;
        String longestS = "";
        int w = n - 1;
        int offset = 0;
        while(w >= 1){
            for (int i = 0; i < n - w; i++){
                // Check if equal edge characters
                offset = 0;
                while(i + offset <= i + w - offset && s.charAt(i + offset) == s.charAt(i + w - offset)){
                    offset++;
                }
                // Found!
                if (i + offset > i + w - offset){
                    longestS = s.substring(i, i + w + 1);
                    longest = longestS.length();
                    break;
                }
            }
            if (longest != 0){
                break;
            }
            w--;
        }
        if (longest == 0){
            if (s.length() >= 1){
                return s.substring(0, 1);
            } else {
                return longestS;
            }
        }
        return longestS;
    }
}
