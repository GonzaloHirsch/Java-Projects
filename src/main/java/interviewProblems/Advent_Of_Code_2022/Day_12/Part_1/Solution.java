package interviewProblems.Advent_Of_Code_2022.Day_12.Part_1;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Solution {
    public static int[][] DIRECTIONS = new int[][]{new int[]{1, 0}, new int[]{-1, 0}, new int[]{0, 1}, new int[]{0, -1}};

    public int findSteps(int[][] mat) {
        // Find the start and end
        int[][] limits = this.findStartEnd(mat);
        Node start = new Node(limits[0][0], limits[0][1]), end = new Node(limits[1][0], limits[1][1]);

        // Apply A*
        Map<Integer, Float> openSet = new HashMap<>(), closedSet = new HashMap<>();
        TreeSet<Node> open = new TreeSet<>();

        // Add the starting node
        open.add(start);
        openSet.put(start.hash, start.f);

        // Iterate
        Node curr, next;
        int val;
        while (!open.isEmpty()) {
            // Remove from the open list
            curr = open.pollFirst();
            openSet.remove(curr);

            // Attempt to move in 4 directions
            val = mat[curr.x][curr.y];
            for (int[] dir : DIRECTIONS) {
                // Can move in direction
                if (curr.x + dir[0] >= 0 && curr.x + dir[0] < mat.length && curr.y + dir[1] >= 0 && curr.y + dir[1] < mat[0].length && mat[curr.x + dir[0]][curr.y + dir[1]] - val <= 1) {
                    // Check if found solution
                    if (curr.x + dir[0] == end.x && curr.y + dir[1] == end.y) return curr.g + 1;
                    // Not found solution, create a new node
                    next = new Node(curr.x + dir[0], curr.y + dir[1]);
                    next.g = curr.g + 1;
                    next.f = next.g + Math.abs(next.x - end.x) + Math.abs(next.y - end.y);
                    // Check if in the open list
                    if ((!openSet.containsKey(next.hash) || openSet.get(next.hash) >= next.f) && (!closedSet.containsKey(next.hash) || closedSet.get(next.hash) >= next.f)) {
                        openSet.put(next.hash, next.f);
                        open.remove(next);
                        open.add(next);
                    }
                }
            }

            // Add to closed list
            closedSet.put(curr.hash, curr.f);
        }

        return -1;
    }

    public int[][] findStartEnd(int[][] mat) {
        int[][] res = new int[2][2];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == -1) res[0] = new int[]{i, j};
                else if (mat[i][j] == 'z' - 'a' + 1) res[1] = new int[]{i, j};
            }
        }
        return res;
    }

    public class Node implements Comparable<Node> {
        public int x, y, hash, g;
        public float f;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
            this.hash = this.x * 10000 + this.y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return this.hash;
        }

        @Override
        public int compareTo(Node o) {
            return Float.compare(this.f, o.f) == 0 ? (this.x == o.x ? Integer.compare(this.y, o.y) : Integer.compare(this.x, o.x)) : Float.compare(this.f, o.f);
        }
    }
}