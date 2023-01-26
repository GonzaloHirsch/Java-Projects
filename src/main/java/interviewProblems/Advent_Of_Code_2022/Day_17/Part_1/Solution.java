package interviewProblems.Advent_Of_Code_2022.Day_17.Part_1;

public class Solution {
    private final Rock[] rocks = new Rock[]{new RockBar(), new RockPlus(), new RockL(), new RockLong(), new RockBox()};

    public int findHeight(String input, int limit) {
        // Compute worst case rock height
        int rockHeight = 0;
        for (Rock rock : rocks) rockHeight += rock.height;
        // Get the input directions
        char[] wind = input.toCharArray();
        // Generate a cave
        char[][] cave = new char[rockHeight * (limit / this.rocks.length) + 10][7];
        int rockId = 0, currentHeight = cave.length - 4, windId = 0;
        boolean applyWind = true;
        for (int i = 1; i <= limit; i++) {
            // Set the height to the rock
            this.rocks[rockId].setCurrentHeight(currentHeight);
            // Make the rock fall
            while (true) {
                // Move horizontally if possible
                if (this.rocks[rockId].canMoveHorizontal(cave, this.getWindDir(wind[windId]))) {
                    this.rocks[rockId].move(this.getWindDir(wind[windId]), 0);
                }
                windId = (windId + 1) % wind.length;
                // Move vertically if possible
                if (!this.rocks[rockId].canMoveVertical(cave)) {
                    // Stop the rock
                    this.rocks[rockId].stopRock(cave);
                    break;
                }
                // Move vertically
                this.rocks[rockId].move(0, 1);
            }
            // Advance to next rock
            rockId = (rockId + 1) % rocks.length;
            // Update the new current height
            currentHeight = this.findTopHeight(cave, currentHeight) - 4;
        }
        /*for (char[] line : cave) {
            StringBuilder sb = new StringBuilder();
            for (char c : line) {
                sb.append(c <= 0 ? '.' : '#');
            }
            System.out.println(sb.toString());
        }*/
        return cave.length - this.findTopHeight(cave, currentHeight);
    }

    public int findTopHeight(char[][] cave, int currentHeight) {
        while (currentHeight > 0) {
            for (int x = 0; x < cave[0].length; x++) {
                if (cave[currentHeight][x] > 0) return currentHeight;
            }
            currentHeight++;
        }
        return -1;
    }

    public int getWindDir(char wind) {
        if (wind == '>') return 1;
        return -1;
    }

    public static abstract class Rock {
        public final int height;
        public final int[][] pattern; // Pattern is based on an origin bottom left
        public final int[][] position;

        public Rock(int height, int[][] pattern) {
            this.height = height;
            this.pattern = pattern;
            this.position = new int[pattern.length][pattern[0].length];
        }

        public void setCurrentHeight(int height) {
            for (int i = 0; i < pattern.length; i++) {
                this.position[i][0] = this.pattern[i][0] + height;
                this.position[i][1] = this.pattern[i][1] + 2;
            }
        }

        public void move(int x, int y) {
            for (int[] point : this.position) {
                point[0] += y;
                point[1] += x;
            }
        }

        public void stopRock(char[][] cave) {
            for (int[] point : this.position) cave[point[0]][point[1]] = 1;
        }

        public boolean canMoveHorizontal(char[][] cave, int x) {
            for (int[] point : this.position) {
                // Check if going over borders, this case cannot move horizontal
                if (point[1] + x >= cave[0].length || point[1] + x < 0) return false;
                // Check if hitting something
                if (cave[point[0]][point[1] + x] != 0) return false;
            }
            return true;
        }

        public boolean canMoveVertical(char[][] cave) {
            for (int[] point : this.position) {
                if (point[0] + 1 >= cave.length || point[0] + 1 < 0) return false;
                // Check if hitting something
                if (cave[point[0] + 1][point[1]] != 0) return false;
            }
            return true;
        }
    }

    // ####
    public static class RockBar extends Rock {
        public RockBar() {
            super(1, new int[][]{new int[]{0, 0}, new int[]{0, 1}, new int[]{0, 2}, new int[]{0, 3}});
        }
    }

    // .#.
    // ###
    // .#.
    public static class RockPlus extends Rock {
        public RockPlus() {
            super(3, new int[][]{new int[]{0, 1}, new int[]{-1, 0}, new int[]{-1, 1}, new int[]{-1, 2}, new int[]{-2, 1}});
        }
    }

    // ..#
    // ..#
    // ###
    public static class RockL extends Rock {
        public RockL() {
            super(3, new int[][]{new int[]{0, 0}, new int[]{0, 1}, new int[]{0, 2}, new int[]{-1, 2}, new int[]{-2, 2}});
        }
    }

    // #
    // #
    // #
    // #
    public static class RockLong extends Rock {
        public RockLong() {
            super(4, new int[][]{new int[]{0, 0}, new int[]{-1, 0}, new int[]{-2, 0}, new int[]{-3, 0}});
        }
    }

    // ##
    // ##
    public static class RockBox extends Rock {
        public RockBox() {
            super(2, new int[][]{new int[]{0, 0}, new int[]{0, 1}, new int[]{-1, 0}, new int[]{-1, 1}});
        }
    }
}