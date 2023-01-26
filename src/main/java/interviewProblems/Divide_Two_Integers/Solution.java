package interviewProblems.Divide_Two_Integers;

class Solution {
    public int divide(int dividend, int divisor) {
        // Edge case that breaks all
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == 1) return Integer.MIN_VALUE;
        // Get the sign and the abs of each one
        int sign = (int)(Math.signum(dividend) * Math.signum(divisor)), q = 0, m, tmp;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        while (dividend - divisor >= 0) {
            m = 0;
            // Iterate until we find the power of 2 that fits
            // The substraction is to take care of the overflow
            while (dividend - (divisor << (m + 1)) >= 0) m++;
            q += (1 << m);
            dividend = dividend - (divisor << m);
        }
        return q * sign;
    }
}