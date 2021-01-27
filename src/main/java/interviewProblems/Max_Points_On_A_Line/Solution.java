package interviewProblems.Max_Points_On_A_Line;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static final int X = 0;
    public static final int Y = 1;
    public static final int SELF = 1;
    public static final int OFFSET = 1000000;

    public int maxPoints(int[][] points) {
        int n = points.length, max = 0, verticals = 0, tempMax = 0, self_extra = 0;

        // Map to store increments
        Map<Double, Integer> map = new HashMap<>();

        int[] curr, next;

        double key;

        for (int i = 0; i < n; i++){
            curr = points[i];
            for (int j = i + 1; j < n; j++){
                next = points[j];
                if (next[X] == curr[X]){
                    if (next[Y] == curr[Y]){
                        self_extra++;
                        tempMax = findMax(map);
                        if (tempMax + self_extra + SELF > max){
                            max = tempMax + self_extra + SELF;
                        }
                        if (self_extra + 1 > max){
                            max = self_extra + 1;
                        }
                    } else {
                        verticals++;
                        if (verticals + self_extra + SELF > max){
                            max = verticals + self_extra + SELF;
                        }
                    }

                } else {
                    key = (0.0 + (((double)next[Y] - (double)curr[Y]) * OFFSET / ((double)next[X] - (double)curr[X])));
                    System.out.println(key);
                    map.computeIfAbsent(key, k -> 0);
                    map.put(key, map.get(key) + 1);
                    if (map.get(key) + self_extra + SELF > max){
                        max = map.get(key) + self_extra + SELF;
                    }
                }
            }
            verticals = 0;
            self_extra = 0;
            map.clear();
        }

        return points.length > 0 ? Math.max(max, SELF) : 0;
    }

    private int findMax(Map<Double, Integer> m){
        Integer max = 0;
        for(Integer n : m.values()){
            if (n > max){
                max = n;
            }
        }
        return max;
    }
}
