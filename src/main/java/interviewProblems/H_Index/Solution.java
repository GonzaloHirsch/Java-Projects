package interviewProblems.H_Index;

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length, limit = 0;
        int[] citationsCount = new int[1001];
        // Fill the citation count
        for (int i = 0; i < n; i++) {
            citationsCount[citations[i]]++;
            if (citations[i] >= limit) limit = citations[i];
        }
        limit++;
        int[] cumulativeCount = new int[limit];
        // Compute the cumulative count
        for (int i = 0; i < limit; i++)
            cumulativeCount[i] = citationsCount[i] + ((i == 0) ? 0 : cumulativeCount[i - 1]);
        // Start computing from the end of the list
        for (int h = limit - 1; h > 0; h--) {
            // Checking there are at least h papers with h citations
            if (h <= n - cumulativeCount[h - 1] && cumulativeCount[h] >= n - h) return h;
        }
        return 0;
    }
}