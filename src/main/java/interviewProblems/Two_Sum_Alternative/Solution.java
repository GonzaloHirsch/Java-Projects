package interviewProblems.Two_Sum_Alternative;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> twoSum(final List<Integer> A, int B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Pair> pairs = new ArrayList<>();
        ArrayList<Integer> sol = new ArrayList<>();
        for (int i = 0; i < A.size(); i++){
            if (map.containsKey(B - A.get(i))){
                pairs.add(new Pair(map.get(B - A.get(i)), i));
            }
            if (!map.containsKey(A.get(i))){
                map.put(A.get(i), i);
            }
        }
        if (pairs.size() >= 1){
            Collections.sort(pairs);
            Pair pair = pairs.get(0);
            sol.add(pair.left + 1);
            sol.add(pair.right + 1);
        }
        return sol;
    }

    public class Pair implements Comparable<Pair>{
        Integer left;
        Integer right;

        public Pair(Integer left, Integer right){
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.right.compareTo(o.right) == 0){
                return this.left.compareTo(o.left);
            }
            return this.right.compareTo(o.right);
        }
    }
}
