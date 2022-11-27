package interviewProblems.Rotated_Digits;


class Solution {
    public int rotatedDigits(int n) {
        int total = 0;
        for (int i = 0; i <= n; i++) total += (this.isGood(i) ? 1 : 0);
        return total;
    }

    private boolean isGood(int x) {
        boolean good = false;
        int num;
        while (x > 0) {
            num = x % 10;
            x /= 10;
            if (num == 2 || num == 5 || num == 6 || num == 9) good = true;
            else if (num == 3 || num == 4 || num == 7) return false;
        }
        return good;
    }
}