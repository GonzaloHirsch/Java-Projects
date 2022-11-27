package interviewProblems.Interval_List_Intersections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int f = 0, s = 0, fn = firstList.length, sn = secondList.length, targetStart = 0, targetEnd = 0;
        List<int[]> res = new ArrayList<>();
        // Iterate to find all
        while (f < fn && s < sn) {
            // Find list intersection
            targetStart = Math.max(firstList[f][0], secondList[s][0]);
            targetEnd = Math.min(firstList[f][1], secondList[s][1]);
            // If a valid intersection, add to result
            if (targetEnd >= targetStart) {
                res.add(new int[]{targetStart, targetEnd});
                // Advancing the indexes given which is the one that ends earlier
                if (secondList[s][1] > firstList[f][1]) f++;
                else s++;
            }
            else {
                if (secondList[s][0] > firstList[f][0]) f++;
                else s++;
            }
        }
        return res.toArray(new int[0][]);
    }
}
