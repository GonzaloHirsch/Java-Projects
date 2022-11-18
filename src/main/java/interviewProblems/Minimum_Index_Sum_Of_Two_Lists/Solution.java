package interviewProblems.Minimum_Index_Sum_Of_Two_Lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        // Populate initial indexes
        Map<String, Integer> indexes = new HashMap<>();
        List<String> response = new ArrayList<>();
        for (int i = 0; i < list1.length; i++) indexes.put(list1[i], i);
        // Populate the rest of the indexes and check the sums
        int minimum = Integer.MAX_VALUE, curr = 0;
        String s;
        for (int i = 0; i < list2.length; i++) {
            s = list2[i];
            if (indexes.containsKey(s)) {
                // Get the current index value
                curr = indexes.get(s) + i;
                // Compute and put it back
                indexes.put(s, curr);
                // Keep track of the minimum and restore the list if it's a new one
                if (curr < minimum) {
                    minimum = curr;
                    response.clear();
                }
                if (curr == minimum) response.add(s);
            }
        }
        return response.toArray(new String[0]);
    }
}
