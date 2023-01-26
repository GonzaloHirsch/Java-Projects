package interviewProblems.Minimum_Window_Substring;

class Solution {
    public String minWindow(String s, String t) {
        // Fill the target with all the character counts we need
        char[] target = new char[('z' - 'a' + 1) * 2], curr = new char[('z' - 'a' + 1) * 2];
        char[] chars = t.toCharArray();
        for (char c : chars) target[getKey(c)]++;

        // Iterate and find the window
        int l = 0, r = -1, n = s.length();
        chars = s.toCharArray();
        String res = null;
        while (r <= n && l <= n) {
            if (!isContained(target, curr)) {
                r++;
                if (r < n) curr[getKey(chars[r])]++;
            } else {
                if (res == null || (l <= r && r - l + 1 < res.length())) res = s.substring(l, r + 1);
                l++;
                if (l < n) curr[getKey(chars[l - 1])]--;
            }
        }
        return res == null ? "" : res;
    }

    public int getKey(char c) {
        return c > 'Z' ? c - 'a' : c - 'A' + 26;
    }

    public boolean isContained(char[] source, char[] target) {
        for (int i = 0; i < source.length; i++) if (target[i] < source[i]) return false;
        return true;
    }
}