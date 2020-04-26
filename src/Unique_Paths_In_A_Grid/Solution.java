package Unique_Paths_In_A_Grid;

import java.util.ArrayList;

public class Solution {
    public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {
        int m = A.size();
        int n = A.get(0).size();
        int[][] paths = new int[m][];
        for (int i = 0; i < m; i++){
            paths[i] = new int[n];
        }
        paths[0][0] = m == n && n == 1 && A.get(0).get(0) == 1 ? 0 : 1;
        int right;
        int bottom;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (A.get(i).get(j) == 0 && paths[i][j] > 0){
                    if (j + 1 < n && A.get(i).get(j + 1) == 0){
                        right = paths[i][j + 1];
                    } else {
                        right = -1;
                    }
                    // bottom
                    if (i + 1 < m && A.get(i + 1).get(j) == 0){
                        bottom = paths[i + 1][j];
                    } else {
                        bottom = -1;
                    }
                    if (right > 0) {
                        paths[i][j + 1] += paths[i][j];
                    } else if (right == 0){
                        paths[i][j + 1] = paths[i][j];
                    }
                    if (bottom > 0) {
                        paths[i + 1][j] += paths[i][j];
                    } else if (bottom == 0){
                        paths[i + 1][j] = paths[i][j];
                    }
                }
            }
        }
        return paths[m - 1][n - 1];
    }
}

