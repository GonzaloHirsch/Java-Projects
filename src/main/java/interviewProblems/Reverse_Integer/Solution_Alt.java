package interviewProblems.Reverse_Integer;

import java.util.ArrayDeque;

class Solution_Alt {
    public int reverse(int x) {
        int sign = x > 0 ? 1 : -1;
        int num = 0, curr = x * sign;
        while (curr > 0) {
            // Check before overlflow
            if (num > 0 && Integer.MAX_VALUE / num < 10) return 0;
            num = num * 10 + (curr % 10);
            curr = curr / 10;
        }
        return num * sign;
    }
}
