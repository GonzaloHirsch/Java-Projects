package interviewProblems.Walking_Robot_Simulation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    private final int[][] directions = new int[][]{new int[]{0,1}, new int[]{1,0}, new int[]{0,-1}, new int[]{-1, 0}};

    public int robotSim(int[] commands, int[][] obstacles) {
        // Populate the obstacle map
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> tmp;
        for (int i = 0; i < obstacles.length; i++) {
            tmp = map.getOrDefault(obstacles[i][0], new HashSet<>());
            tmp.add(obstacles[i][1]);
            map.put(obstacles[i][0], tmp);
        }
        // State variables
        boolean stuck = false;
        int direction = 0, max = Integer.MIN_VALUE, x = 0, y = 0;
        for (int i = 0; i < commands.length; i++) {
            // Rotate
            if (commands[i] < 0) {
                // Java can return a negative reminder
                direction = (direction + (commands[i] == -1 ? 1 : -1)) % 4;
                if (direction < 0) direction += 4;
                stuck = false;
            }
            // Move command and not stuck
            else if (!stuck) {
                // Attempt to move
                for (int j = 0; j < commands[i] && !stuck; j++) {
                    tmp = map.getOrDefault(x + this.directions[direction][0], null);
                    if (tmp != null && tmp.contains(y + this.directions[direction][1])) {
                        stuck = true;
                    } else {
                        x += this.directions[direction][0];
                        y += this.directions[direction][1];
                    }
                }
                // Check if we are on the max
                max = Math.max(max, x * x + y * y);
            }
        }
        return max;
    }
}