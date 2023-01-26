package interviewProblems.Longest_Palindromic_Substring;

class SolutionAlternative {
    public String longestPalindrome(String s) {
        // Convert to array
        char[] chars = s.toCharArray();
        for (int ws = s.length(); ws > 0; ws--) {
            for (int i = 0; i < s.length() - ws + 1; i++) {
                if (this.isPalindrome(chars, i, i + ws - 1)) return s.substring(i, i + ws);
            }
        }
        return String.valueOf(chars[0]);
    }

    private boolean isPalindrome(char[] chars, int left, int right) {
        while (left < right && chars[left] == chars[right]) {
            left++;
            right--;
        }
        return left >= right;
    }
}