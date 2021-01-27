package interviewProblems.Trapping_Rain_Water_2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static final int X = 0;
    public static final int Y = 1;
    public static final int H = 2;

    public int trapRainWater(int[][] heightMap) {
        int max = 0, n = heightMap.length, m = heightMap[0].length, total = 0;
        int[][] totals = new int[n][m];

        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return Integer.compare(a[H], b[H]);
            }
        });

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1){
                    heap.add(this.initArr(i, j, heightMap[i][j]));
                    totals[i][j] = 0;
                } else {
                    totals[i][j] = -1;
                }
            }
        }

        int[] curr;

        while (!heap.isEmpty()){
            curr = heap.poll();
            max = Math.max(curr[H], max);

            // If within range and not visited
            if (curr[X] < n - 1 && totals[curr[X] + 1][curr[Y]] < 0){
                total += this.processNext(curr[X] + 1, curr[Y], curr, heightMap, totals, max, heap);
            }

            if (curr[X] > 0 && totals[curr[X] - 1][curr[Y]] < 0){
                total += this.processNext(curr[X] - 1, curr[Y], curr, heightMap, totals, max, heap);
            }

            if (curr[Y] < m - 1 && totals[curr[X]][curr[Y] + 1] < 0){
                total += this.processNext(curr[X], curr[Y] + 1, curr, heightMap, totals, max, heap);
            }

            if (curr[Y] > 0 && totals[curr[X]][curr[Y] - 1] < 0){
                total += this.processNext(curr[X], curr[Y] - 1, curr, heightMap, totals, max, heap);
            }
        }

        return total;
    }

    private int processNext(int i, int j, int[] curr, int[][] hmap, int[][] totals, int max, PriorityQueue<int[]> heap){
        heap.add(this.initArr(i, j, hmap[i][j]));
        if (curr[H] + totals[curr[X]][curr[Y]] > hmap[i][j]){
            totals[i][j] = max - hmap[i][j];
            return totals[i][j];
        } else {
            totals[i][j] = 0;
            return 0;
        }
    }

    private int[] initArr(int x, int y, int h){
        int[] res = new int[3];
        res[X] = x;
        res[Y] = y;
        res[H] = h;
        return res;
    }
}
