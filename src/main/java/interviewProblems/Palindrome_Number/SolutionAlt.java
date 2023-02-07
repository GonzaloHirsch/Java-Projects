package interviewProblems.Palindrome_Number;

public class SolutionAlt {
    public boolean isPalindrome(int x) {
        // Negative numbers will never be palindrome with these rules
        if (x < 0) return false;
        long normal = x, reversed = 0;
        // Add all digits
        while (x > 0) {
            reversed = (10 * reversed) + (x % 10);
            x /= 10;
        }
        return normal == reversed;
    }

    /*

    public boolean isPalindrome(int x) {
        // Negative numbers will never be palindrome with these rules
        if (x < 0) return false;
        // Stores digits in order of pushing them
        Deque<Integer> digits = new LinkedList<>();
        // Add all digits
        while (x > 0) {
            digits.push(x % 10);
            x /= 10;
        }
        // Iterate while popping the first & last
        while (digits.size() > 1) if (digits.pollFirst() != digits.pollLast()) return false;
        return true;
    }
     */
}