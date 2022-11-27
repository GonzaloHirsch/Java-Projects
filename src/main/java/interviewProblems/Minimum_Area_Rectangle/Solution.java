package interviewProblems.Minimum_Area_Rectangle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int minAreaRect(int[][] points) {
        // Fill the map
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] p : points) {
            if (!map.containsKey(p[0])) map.put(p[0], new HashSet<>());
            map.get(p[0]).add(p[1]);
        }
        // Find pairs of diagonal points that match
        int min = Integer.MAX_VALUE;
        int[] p1, p2;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                p1 = points[i];
                p2 = points[j];
                // Check that are diagonal
                if (p1[0] == p2[0] || p1[1] == p2[1]) continue;
                // Check if there are other points that match them
                if (map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1])) {
                    min = Math.min(min, Math.abs(p1[0] - p2[0]) * Math.abs(p1[1] - p2[1]));
                }
            }
        }
        return min < Integer.MAX_VALUE ? min : 0;
    }
}
