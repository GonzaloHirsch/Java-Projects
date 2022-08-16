package interviewProblems.Grid_Illumination;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        int[][] dirs = {{1,0},{1,1},{1,-1},{0,0},{0,1},{0,-1},{-1,0},{-1,1},{-1,-1}};
        Map<Integer, Integer> horizontal = new HashMap<>(); // X positions
        Map<Integer, Integer> vertical = new HashMap<>();   // Y positions
        Map<Integer, Integer> diagPos = new HashMap<>();    // Diagonal, y = mx + b, m = 1, so b = y - x
        Map<Integer, Integer> diagNeg = new HashMap<>();    // Diagonal, y = mx + b, m = -1, so b = y + x
        Map<Long, Integer> status = new HashMap<>();     // On/off status
        // Duplicate check
        Set<String> set = new HashSet<>();
        // Add all lamps
        int x, y;
        String s;
        for (int i = 0; i < lamps.length; i++) {
            x = lamps[i][0];
            y = lamps[i][1];
            s = x + "##" + y;
            // Check if duplicate
            if (!set.contains(s)) {
                set.add(s);
                horizontal.put(x, horizontal.getOrDefault(x, 0) + 1);
                vertical.put(y, vertical.getOrDefault(y, 0) + 1);
                diagPos.put(y - x, diagPos.getOrDefault(y - x, 0) + 1);
                diagNeg.put(y + x, diagNeg.getOrDefault(y + x, 0) + 1);
                status.put((long)n * (long)x + (long)y, status.getOrDefault((long)n * (long)x + (long)y, 0) + 1);
            }
        }
        // Calculate the results
        int[] results = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            x = queries[q][0];
            y = queries[q][1];
            results[q] = (horizontal.getOrDefault(x, 0) > 0 || vertical.getOrDefault(y, 0) > 0 || diagPos.getOrDefault(y - x, 0) > 0 || diagNeg.getOrDefault(y + x, 0) > 0) ? 1 : 0;
            for (int[] dir : dirs) {
                x = queries[q][0] + dir[0];
                y = queries[q][1] + dir[1];
                // Check if lamp is on
                if (x >= 0 && y >= 0 && status.getOrDefault((long)n * (long)x + (long)y, 0) > 0) {
                    horizontal.put(x, horizontal.getOrDefault(x, 1) - 1);
                    vertical.put(y, vertical.getOrDefault(y, 1) - 1);
                    diagPos.put(y - x, diagPos.getOrDefault(y - x, 1) - 1);
                    diagNeg.put(y + x, diagNeg.getOrDefault(y + x, 1) - 1);
                    status.put((long)n * (long)x + (long)y, status.getOrDefault((long)n * (long)x + (long)y, 1) - 1);
                }
            }
        }

        return results;
    }
}