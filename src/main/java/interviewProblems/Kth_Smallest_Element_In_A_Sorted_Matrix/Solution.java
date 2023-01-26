package interviewProblems.Kth_Smallest_Element_In_A_Sorted_Matrix;


import java.util.Arrays;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // Holds the indexes of the current number
        int[] indexes = new int[matrix.length];
        Arrays.fill(indexes, -1);

        int minI = 0;
        for (int i = 0, min; i < k; i++) {
            min = Integer.MAX_VALUE;
            minI = -1;
            for (int j = 0; j < indexes.length; j++) {
                if (indexes[j] < matrix.length - 1 && matrix[j][indexes[j] + 1] < min) {
                    min = matrix[j][indexes[j] + 1];
                    minI = j;
                }
            }
            indexes[minI]++;
        }

        return matrix[minI][indexes[minI]];
    }
}