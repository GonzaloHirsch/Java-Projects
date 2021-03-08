package interviewProblems.Tallest_Billboard;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int tallestBillboard(int[] rods) {
        // Map to store current sums
        Map<Integer, Integer> sums = new HashMap<>(), temp = null;
        sums.put(0, 0);

        // For each rod
        for (int rod : rods){
            temp = new HashMap<>();

            // Add rod to each sum
            for (Map.Entry<Integer, Integer> sum : sums.entrySet()) {
                temp.put(sum.getKey() + rod, Math.max(sum.getValue() + rod, temp.getOrDefault(sum.getKey() + rod, 0)));
                temp.put(sum.getKey() - rod, Math.max(sum.getValue(), temp.getOrDefault(sum.getKey() - rod, 0)));
                temp.put(sum.getKey(), Math.max(sum.getValue(), temp.getOrDefault(sum.getKey(), 0)));
            }

            sums = temp;
        }

        return sums.getOrDefault(0, 0);
    }
}
