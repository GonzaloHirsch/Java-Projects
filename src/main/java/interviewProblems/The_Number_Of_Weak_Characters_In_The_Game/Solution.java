package interviewProblems.The_Number_Of_Weak_Characters_In_The_Game;
class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        // Size is 10^5 + 2 to account for 0 and checking the next one
        int[] maxDefenses = new int[100002];
        // Find largest value per defense
        for (int[] c : properties) maxDefenses[c[0]] = Math.max(maxDefenses[c[0]], c[1]);
        // Update defenses to show the largest value that beats them, if the next one is larger
        // Replace the current one with the next one. This propagates backwards.
        for (int i = 100000; i >= 0; i--) {
            maxDefenses[i] = Math.max(maxDefenses[i],maxDefenses[i + 1]);
        }
        // Check each item against the max value of the next defense
        int total = 0;
        for (int[] c : properties) if (maxDefenses[c[0] + 1] > c[1]) total++;
        return total;
    }
}