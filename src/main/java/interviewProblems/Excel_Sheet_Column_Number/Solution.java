package interviewProblems.Excel_Sheet_Column_Number;

class Solution {
    public int titleToNumber(String columnTitle) {
        char[] chars = columnTitle.toCharArray();
        int total = 0;
        for (int i = chars.length - 1; i >= 0; i--) total += (Math.pow(26, chars.length - 1 - i) * (chars[i] - 'A' + 1));
        return total;
    }
}