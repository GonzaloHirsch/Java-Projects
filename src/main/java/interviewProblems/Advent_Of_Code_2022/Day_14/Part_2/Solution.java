package interviewProblems.Advent_Of_Code_2022.Day_14.Part_2;

public class Solution {
    public int findSandAmount(Main.Cave cave) {
        int total = 0;
        boolean bounded = true;
        while (bounded) {
            bounded = this.isSandBounded(cave);
            if (bounded) total++;
        }
        return total;
    }

    private boolean isSandBounded(Main.Cave cave) {
        int x = cave.drop, y = 0, moved = 0;
        while (cave.map[y][x] == '-') {
            moved++;
            // If in the last row, sand will fall
            if (y + 1 >= cave.map.length) return false;
            // Check if can place down
            if (cave.map[y + 1][x] == '-') {
                y++;
                continue;
            }
            // Try sides
            // Will fall on the left
            if (x - 1 < 0) return false;
            // Place down on the left
            if (cave.map[y + 1][x - 1] == '-') {
                y++;
                x--;
                continue;
            }
            // Will fall on the right
            if (x + 1 >= cave.map[0].length) return false;
            // Place down on the right
            if (cave.map[y + 1][x + 1] == '-') {
                y++;
                x++;
                continue;
            }
            // Needs to place down the sand because there's no place to go
            cave.map[y][x] = '+';
        }

        return moved > 0;
    }
}