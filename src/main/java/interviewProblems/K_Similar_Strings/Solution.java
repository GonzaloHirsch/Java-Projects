package interviewProblems.K_Similar_Strings;


import java.util.*;

class Solution {
    public int kSimilarity(String s1, String s2) {
        int k = 0, size = 0;

        Queue<String> pending = new LinkedList<>();
        pending.add(s1);

        Set<String> visited = new HashSet<>();

        String curr;
        while (!pending.isEmpty()) {
            size = pending.size();
            for (int i = 0; i < size; i++) {
                curr = pending.poll();
                // Check if found solution
                if (curr.equals(s2)) return k;
                // Iterate all similar
                for (String similar : this.getSimilar(curr, s2)) {
                    if (!visited.contains(similar)) {
                        visited.add(similar);
                        pending.add(similar);
                    }
                }
            }
            k++;
        }

        return -1;
    }

    private List<String> getSimilar(String a, String b) {
        List<String> result = new ArrayList<>();

        // Convert to array for easier manipulation
        char[] charA = a.toCharArray(), charB = b.toCharArray();
        int i = 0;

        // Look for first different char
        for (; i < charA.length && charA[i] == charB[i]; i++);

        for (int j = i; j < charA.length; j++) {
            if (charA[j] == charB[i]) {
                this.swap(charA, i, j);
                result.add(new String(charA));
                this.swap(charA, i, j);
            }
        }

        return result;
    }

    private void swap(char[] arr, int a, int b) {
        char tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}