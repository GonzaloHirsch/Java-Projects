package interviewProblems.Swim_In_Rising_Water;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    private static final int X = 0;
    private static final int Y = 1;
    private static final int H = 2;

    private static final Comparator<int[]> COMP = Comparator.comparingInt(a -> a[H]);

    private int[][] memory;

    public int swimInWater(int[][] grid) {
        int[] curr;
        int max = 0, n = grid.length;

        this.memory = new int[n][n];

        // Create PQ
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(COMP);
        // Init with initial value
        heap.add(this.initArr(0, 0, grid[0][0]));
        this.memory[0][0] = 1;

        while (heap.peek() != null){
            curr = heap.poll();
            if (curr[H] > max){
                max = curr[H];
            }
            if (curr[X] == n - 1 && curr[Y] == n - 1){
                break;
            }
            this.fillNeighbours(curr[X], curr[Y], n, grid, heap);
        }

        return Math.max(grid[0][0], max);
    }

    private void fillNeighbours(int x, int y, int n, int[][] grid, PriorityQueue<int[]> heap){
        if (x + 1 < n && this.memory[x + 1][y] == 0){
            heap.add(this.initArr(x + 1, y, grid[x + 1][y]));
            this.memory[x + 1][y] = 1;
        }
        if (y + 1 < n && this.memory[x][y + 1] == 0){
            heap.add(this.initArr(x, y + 1, grid[x][y + 1]));
            this.memory[x][y + 1] = 1;
        }
        if (x - 1 >= 0 && this.memory[x - 1][y] == 0){
            heap.add(this.initArr(x - 1, y, grid[x - 1][y]));
            this.memory[x - 1][y] = 1;
        }
        if (y - 1 >= 0 && this.memory[x][y - 1] == 0){
            heap.add(this.initArr(x, y - 1, grid[x][y - 1]));
            this.memory[x][y - 1] = 1;
        }

    }

    private int[] initArr(int x, int y, int h){
        return new int[]{x, y, h};
    }
}
