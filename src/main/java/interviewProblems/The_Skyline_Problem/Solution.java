package interviewProblems.The_Skyline_Problem;

import java.util.*;

public class Solution {
    // Constants for more readability
    public static final int LI = 0;
    public static final int RI = 1;
    public static final int HI = 2;

    public List<List<Integer>> getSkyline(int[][] buildings) {
        // Solution list
        List<List<Integer>> res = new ArrayList<>();

        // Critical points, ordered by key
        Map<Integer, List<int[]>> cps = new TreeMap<>();

        // Adding the critical points for each building
        for (int[] b : buildings){
            // Adding the left and right points to the map
            cps.putIfAbsent(b[LI], new ArrayList<int[]>());
            cps.putIfAbsent(b[RI], new ArrayList<int[]>());
            cps.get(b[LI]).add(b);
            cps.get(b[RI]).add(b);
        }

        // Heap to mantain order of active buildings, it compares by height
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] b1, int[] b2){
                return Integer.compare(b2[HI], b1[HI]);
            }
        });

        // Iterating all critical points
        for (Map.Entry<Integer, List<int[]>> entry : cps.entrySet()){
            int k = entry.getKey();
            List<int[]> bs = entry.getValue();

            // Managing active buildings
            for (int[] b : bs){
                if (b[LI] == k){
                    heap.add(b);
                } else {
                    heap.remove(b);
                }
            }

            // If no building, the point is on the ground
            if (heap.isEmpty()){
                List<Integer> _res = new ArrayList<>();
                _res.add(k);
                _res.add(0);
                res.add(_res);
            } else {
                // Get the highest building for the point
                int h = heap.peek()[HI];
                if (res.isEmpty() || res.get(res.size() - 1).get(1) != h){
                    List<Integer> _res = new ArrayList<>();
                    _res.add(k);
                    _res.add(h);
                    res.add(_res);
                }
            }
        }

        return res;
    }
}
