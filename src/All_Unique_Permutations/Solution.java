package All_Unique_Permutations;

import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        HashSet<ArrayList<Integer>> sol = new HashSet<>();
        this.ps(sol, A, 0);
        return new ArrayList<>(sol);
    }

    /*
        ts -> index to be swapped with
    */
    public void ps(HashSet<ArrayList<Integer>> sol, ArrayList<Integer> A, int ts){
        if (ts < A.size()){
            sol.add((ArrayList<Integer>)A.clone());
            for (int i = 0; i < A.size(); i++){
                this.swap(A, ts, i);
                this.ps(sol, A, ts + 1);
                this.swap(A, i, ts);
            }
        }
    }

    public void swap(ArrayList<Integer> A, int a, int b){
        int tmp = A.get(a);
        A.set(a, A.get(b));
        A.set(b, tmp);
    }
}
