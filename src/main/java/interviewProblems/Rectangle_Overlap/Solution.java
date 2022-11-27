package interviewProblems.Rectangle_Overlap;

class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int[] overlap = new int[4];
        overlap[0] = Math.max(rec1[0], rec2[0]);
        overlap[1] = Math.max(rec1[1], rec2[1]);
        overlap[2] = Math.min(rec1[2], rec2[2]);
        overlap[3] = Math.min(rec1[3], rec2[3]);
        return (overlap[2] - overlap[0]) > 0 && (overlap[3] - overlap[1]) > 0;
    }
}



