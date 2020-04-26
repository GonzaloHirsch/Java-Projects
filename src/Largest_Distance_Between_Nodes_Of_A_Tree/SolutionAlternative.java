package Largest_Distance_Between_Nodes_Of_A_Tree;

import java.util.ArrayList;

public class SolutionAlternative {
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        // Array for node and largest path
        int[][] parents = new int[n][];
        for (int i = 0; i < n; i++){
            parents[i] = new int[2];
        }
        int elem;
        int[] parent;
        int max = 0;
        int currMax = 0;
        for (int i = n - 1; i > 0; --i){
            elem = A.get(i);
            parent = parents[elem];
            currMax = parents[i][0] + 1;
            parent[1] = Math.max(parent[1], currMax + parent[0]);
            parent[0] = Math.max(parent[0], currMax);
            max = Math.max(max, parent[1]);
        }
        return max;
    }
}
