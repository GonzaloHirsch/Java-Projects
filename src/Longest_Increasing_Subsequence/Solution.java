package Longest_Increasing_Subsequence;

import java.util.HashMap;
import java.util.List;

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int lis(final List<Integer> A) {
        int n = A.size();
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, A.get(0));
        int maxLevel = 0;
        int level;
        int actual;
        for (int i = 1; i < n; i++){
            level = maxLevel;
            actual = A.get(i);
            while(level >= 0 && map.get(level) >= actual){
                level--;
            }
            map.put(level + 1, actual);
            if (level == maxLevel){maxLevel++;}
        }
        return maxLevel + 1;
    }
}
