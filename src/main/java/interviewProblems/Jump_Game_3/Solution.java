package interviewProblems.Jump_Game_3;

import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Integer, Integer> cache = new HashMap<>();
    private int[] ns;
    private int n;

    public boolean canReach(int[] arr, int start) {
        this.ns = arr;
        this.n = arr.length;
        return this.recReach(start);
    }

    public boolean recReach(int curr){
        int currCache = this.cache.containsKey(curr) ? this.cache.get(curr) : 0;
        if (this.ns[curr] == 0){
            return true;
        } else if (currCache  == 3){
            return false;
        }

        boolean res = false;
        if (curr + this.ns[curr] < n && currCache != 2){
            this.cache.put(curr, currCache == 0 ? 2 : 3);
            res = res || this.recReach(curr + this.ns[curr]);
        }
        if (curr - this.ns[curr] >= 0 && currCache != 1){
            this.cache.put(curr, currCache == 0 ? 1 : 3);
            res = res || this.recReach(curr - this.ns[curr]);
        }
        return res;
    }
}