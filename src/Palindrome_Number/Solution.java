package Palindrome_Number;

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        } else {
            int first;
            int last;
            int level = 0;
            while (Math.log10(x) > level){
                first = getFirst(x, level);
                last = getLast(x, level);
                if (first != last){
                    return false;
                }
                level++;
            }
            return true;
        }
    }

    public int getFirst(int x, int level){
        int pw = (int)Math.log10(x) - level;
        return (int)((double)x / Math.pow(10, pw)) % 10;
    }

    public int getLast(int x, int level){
        return (x / (int)Math.pow(10, level)) % 10;
    }
}