package interviewProblems.Advent_Of_Code_2022.Day_20.Part_2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    private final int[][] DIRECTIONS = new int[][]{new int[]{1, 0, 0}, new int[]{0, 1, 0}, new int[]{0, 0, 1}, new int[]{-1, 0, 0}, new int[]{0, -1, 0}, new int[]{0, 0, -1}};

    public int findSurface(String input) {
        // Compute the coordinates
        char[][] coordinates = this.getCoordinates(input);
        // Find the limits of the space
        char[] limits = this.findLimits(coordinates);
        // Represent the 3D space and add the points with a 1
        char[][][] map = new char[limits[0] + 1][limits[1] + 1][limits[2] + 1];
        for (char[] point : coordinates) map[point[0]][point[1]][point[2]] = 10;
        // Propagate and find the pockets
        this.propagateSteam(map);
        // Store the hidden sides
        char[] visibleSides = new char[coordinates.length];
        int total = 0;
        for (int i = 0; i < coordinates.length; i++) {
            for (int[] dir : DIRECTIONS) {
                if (coordinates[i][0] + dir[0] >= 0 && coordinates[i][0] + dir[0] < map.length && coordinates[i][1] + dir[1] >= 0 && coordinates[i][1] + dir[1] < map[0].length && coordinates[i][2] + dir[2] >= 0 && coordinates[i][2] + dir[2] < map[0][0].length) {
                    if (map[coordinates[i][0] + dir[0]][coordinates[i][1] + dir[1]][coordinates[i][2] + dir[2]] == 1) visibleSides[i]++;
                } else visibleSides[i]++;
            }
            //System.out.println((int)hiddenSides[i]);
            total += visibleSides[i];
        }
        return total;
    }

    private void propagateSteam(char[][][] map) {
        Queue<char[]> pending = new LinkedList<>();
        Set<String> inQueue = new HashSet<>();
        char[] curr, tmp;
        char[][] corners = new char[][] {
                // 3 0s
                new char[]{0,0,0},
                // 2 0s
                new char[]{(char)(map.length - 1),0,0},
                new char[]{0,(char)(map[0].length - 1),0},
                new char[]{0,0,(char)(map[0][0].length - 1)},
                // 1 0s
                new char[]{(char)(map.length - 1),0,(char)(map[0][0].length - 1)},
                new char[]{(char)(map.length - 1),(char)(map[0].length - 1),0},
                new char[]{0,(char)(map[0].length - 1),(char)(map[0][0].length - 1)},
                // 0 0s
                new char[]{(char)(map.length - 1),(char)(map[0].length - 1),(char)(map[0][0].length - 1)}
        };
        // Iterate all points
        for (char[] corner : corners) {
            // Test them to see if they are generating a pocket
            pending.add(corner);
            inQueue.add(generateKey(corner));
            while (!pending.isEmpty()) {
                curr = pending.poll();
                map[curr[0]][curr[1]][curr[2]] = 1;
                for (int[] dir : DIRECTIONS) {
                    if (curr[0] + dir[0] >= 0 && curr[0] + dir[0] < map.length && curr[1] + dir[1] >= 0 && curr[1] + dir[1] < map[0].length && curr[2] + dir[2] >= 0 && curr[2] + dir[2] < map[0][0].length) {
                        tmp = new char[]{(char)(curr[0] + dir[0]),(char)(curr[1] + dir[1]),(char)(curr[2] + dir[2])};
                        if (map[tmp[0]][tmp[1]][tmp[2]] == 0 && !inQueue.contains(generateKey(tmp))) {
                            pending.add(tmp);
                            inQueue.add(generateKey(tmp));
                        }
                    }
                }
            }
        }
    }

    private String generateKey(char[] point) {
        return point[0] + "-" + point[1] + "-" + point[2];
    }

    private char[] findLimits(char[][] coordinates) {
        char[] limits = new char[3];
        for (char[] coord : coordinates) {
            for (int i = 0; i < limits.length; i++) limits[i] = (char) Math.max(limits[i], coord[i]);
        }
        return limits;
    }

    private char[][] getCoordinates(String input) {
        String[] lines = input.split("\n"), numbers;
        char[][] res = new char[lines.length][3];
        for (int i = 0; i < lines.length; i++) {
            numbers = lines[i].split(",");
            for (int j = 0; j < res[0].length; j++) res[i][j] = (char) Integer.parseInt(numbers[j]);
        }
        return res;
    }
}