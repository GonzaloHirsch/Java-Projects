package interviewProblems.String_To_Integer_Atoi;

class Solution_Alt {
    public int myAtoi(String s) {
        // Remove the leading spaces to avoid taking care of that
        char[] chars = s.trim().toCharArray();
        int result = 0, sign = 1, n = 0;
        boolean numberStarted = false;
        for (char c : chars) {
            // Add the number
            if ('0' <= c && c <= '9') {
                n = c - '0';
                // In case there is no sign
                if (!numberStarted) numberStarted = true;
                // Check for overflow
                if (sign > 0 && result > (Integer.MAX_VALUE - n * sign) / 10) return Integer.MAX_VALUE;
                    // Check for underflow
                else if (sign < 0 && result < (Integer.MIN_VALUE - n * sign) / 10) return Integer.MIN_VALUE;
                    // Not doing overflow
                else result = result * 10 + n * sign;
            } else if ((c == '-' || c == '+') && !numberStarted) {
                numberStarted = true;
                sign = c == '-' ? -1 : 1;
            }
            // Anything else, we should just finish
            else return result;
        }

        return result;
    }
}