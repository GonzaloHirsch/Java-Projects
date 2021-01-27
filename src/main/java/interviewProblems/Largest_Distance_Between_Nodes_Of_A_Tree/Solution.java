package interviewProblems.Largest_Distance_Between_Nodes_Of_A_Tree;

import java.util.ArrayList;
import java.util.Collections;
public class Solution {
    public int solve(ArrayList<Integer> A) {
        ArrayList<Integer> paths = new ArrayList<>();
        Integer[] nodePaths = new Integer[1];
        nodePaths[0] = 0;
        for (int i = 1; i < A.size(); i++){
            if (A.get(i) == 0){
                paths.add(run(A, nodePaths, i) + 1);
            }
        }
        Collections.sort(paths);
        int max = getMaxSum(paths, paths.size());
        return max > nodePaths[0] ? max : nodePaths[0];
    }

    public int run(ArrayList<Integer> A, Integer[] paths, int idx){
        ArrayList<Integer> allPaths = new ArrayList<>();
        int i = idx;
        while(i < A.size()){
            if (A.get(i) == idx){
                allPaths.add(run(A, paths, i) + 1);
            }
            i++;
        }
        int n = allPaths.size();
        if (n > 0){
            if (n > 1){
                Collections.sort(allPaths);
            }
            int max = getMaxSum(allPaths, n);
            if (max > paths[0]){
                paths[0] = max;
            }
            return allPaths.get(n - 1);
        }
        return 0;
    }

    public int getMaxSum(ArrayList<Integer> paths, int n){
        if (n > 1){
            return paths.get(n - 1) + paths.get(n - 2);
        } else if (n == 1){
            return paths.get(0);
        } else {
            return 0;
        }
    }
}









