package interviewProblems.Number_Of_Boomerangs;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        Map<Integer, Integer> pointDistance;
        int res = 0, dist = 0;
        for (int i = 0; i < points.length; i++) {
            pointDistance = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                // Calculate distance between all pairs, distance i-j is same as distance j-i
                dist = distance(points[i], points[j]);
                // Count number of points that share distance
                pointDistance.put(dist, pointDistance.getOrDefault(dist, 0) + 1);
            }
            res += reduceMap(pointDistance);
        }
        return res;
    }

    private int reduceMap(Map<Integer, Integer> distances) {
        int res = 0;
        for (Integer count : distances.values()) {
            if (count >= 2) res += (count * (count - 1));
        }
        return res;
    }

    private int distance(int[] p1, int[] p2) {
        return ((p2[0] - p1[0]) * (p2[0] - p1[0])) + ((p2[1] - p1[1]) * (p2[1] - p1[1]));
    }
}