package interviewProblems.Maximum_Compatibility_Score_Sum;
class Solution {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        // Compute all scores
        int[][] scores = new int[students.length][mentors.length];
        for (int i = 0; i < students.length; i++) {
            for (int j = 0; j < students.length; j++) {
                scores[i][j] = getScore(students[i], mentors[j]);
            }
        }
        // Create an array of taken mentors, not taken = 0; taken = 1
        return getMaxScore(0, 0, scores, new int[mentors.length]);
    }

    private int getMaxScore (int student, int mentor, int[][] scores, int[] takenMentors) {
        // Base case
        if (student >= scores.length || mentor >= scores.length) return 0;
        // Choice section, go for the next mentor or take this one
        // Go for the next just increases the mentor id
        int nextMentor = this.getMaxScore(student, mentor + 1, scores, takenMentors);
        int takeMentor = -1;
        // Going to take the mentor simulates choosing the mentor by setting the flag for the branch
        if (takenMentors[mentor] == 0) {
            takenMentors[mentor] = 1;
            // Increase student, reset mentor and account for score
            takeMentor = scores[student][mentor] + this.getMaxScore(student + 1, 0, scores, takenMentors);
            takenMentors[mentor] = 0;
        }
        return Math.max(nextMentor, takeMentor);
    }

    public int getScore(int[] resp1, int[] resp2) {
        int total = 0;
        for (int i = 0; i < resp1.length; i++) total += (resp1[i] == resp2[i] ? 1 : 0);
        return total;
    }
}