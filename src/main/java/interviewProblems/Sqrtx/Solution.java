package interviewProblems.Sqrtx;


class Solution {
    public int mySqrt(int x) {
        if (x <= 1) return x;
        int l = 0, r = x, mid = 0;
        while (true) {
            mid = (l + r) / 2;
            // Division avoids overflow
            // Mid is larger than number, should reduce from right
            if (mid > x / mid) r = mid - 1;
            else {
                if (mid + 1 > x / (mid + 1)) return mid;
                l = mid + 1;
            }
        }
    }
}